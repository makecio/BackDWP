package br.com.BackDWP.file;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.BackDWP.config.ConfiguracaoEntity;
import br.com.BackDWP.config.ConfiguracaoRepository;
import br.com.BackDWP.folder.FolderEntity;
import br.com.BackDWP.folder.FolderRepository;
import br.com.BackDWP.utils.GenericService;
import br.com.BackDWP.utils.ServicePath;


@RestController
@RequestMapping(path = ServicePath.FILE_PATH)
public class FileService {
	
	
	@Autowired 
	FileRepository filesRepository;
	
	@Autowired
	ConfiguracaoRepository configRepository;
	
	@Autowired 
	FolderRepository folderRepository;
	
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/findbyuser/{id}",method = RequestMethod.GET)
	public ResponseEntity findByUser(@PathVariable("id") Integer id){
		
		if (this.filesRepository.findByUserId(id).size() == 0) {
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		  }

		  return new ResponseEntity<List <FilesEntity>>(this.filesRepository.findByUserId(id), HttpStatus.OK);
		  
		 
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/findbyfolder/{id}",method = RequestMethod.GET)
	public ResponseEntity findByFolder(@PathVariable("id") Integer id){
		
		if (this.filesRepository.findByFolderId(id).size() == 0) {
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		  }

		  return new ResponseEntity<List <FilesEntity>>(this.filesRepository.findByFolderId(id), HttpStatus.OK);
		  
		 
	}
	
	
	@RequestMapping(value = "/img", method = RequestMethod.GET, produces = "image/png")
	public ResponseEntity<InputStreamResource> downloadPDFFile()
	        throws IOException {

		File file = new File("/Users/adriano/Desktop/ambientes.png");
	    InputStream in = new FileInputStream(file);
	    InputStreamResource inputStreamResource = new InputStreamResource(in);
	   

	    
	    HttpHeaders headers = new HttpHeaders();
	    headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
	    headers.add("Pragma", "no-cache");
	    headers.add("Expires", "0");
	    headers.setContentDispositionFormData("png", "img.png");

	    return ResponseEntity
	            .ok()
	            .headers(headers)
	           // .contentLength(inputStreamResource.contentLength())
	            .contentType(MediaType.parseMediaType("application/octet-stream"))
	            
	          
	            .body(inputStreamResource);
	}
/*
	@ResponseBody
	@RequestMapping(value = "/getimg/{id}",  produces = "image/png")
	public Resource texture(@PathVariable("id") String id) {
		
		//return resourceLoader.getResource("file:Users/adriano/Documents"+File.separator +"1.png");
	    return (Resource) resourceLoader.getResource("classpath:br/com/backrest/" + id + ".png");
	}
	*/
	
	@RequestMapping(value="pdf",method = RequestMethod.GET)
	public void getPdf(HttpServletResponse response) throws IOException {
		
		File file = new File("/Users/adriano/Desktop/Manual_CRM.pdf");
		
		// Get your file stream from wherever.
		InputStream myStream = new FileInputStream(file);

		// Set the content type and attachment header.
		response.addHeader("Content-disposition", "attachment;filename=myfile.pdf");
		response.setContentType("application/pdf");

		// Copy the stream to the response's output stream.
		IOUtils.copy(myStream, response.getOutputStream());
		response.flushBuffer();
	    
	}
	
	

	@CrossOrigin
    @RequestMapping(value="/upload", method=RequestMethod.POST)
    public @ResponseBody String handleFileUpload(@RequestParam("file") MultipartFile file){
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(file.getName())));
                stream.write(bytes);
                stream.close();
                
              //  File convFile = new File( file.getOriginalFilename());
                
                System.out.println("nome file : "+ file.getContentType());
                FolderEntity folder = folderRepository.findOne(Long.parseLong("1"));
                
                ConfiguracaoEntity config = configRepository.findByCliente(1);
        		
                
                String typefile=file.getContentType().split("/")[1];
                
                System.out.println("nome type : "+ typefile);
                file.transferTo(new File(config.getDirRaiz()+folder.getPathAbsoluto()+file.getName().trim()+"."+typefile));
                
            	
                //filesRepository.save(filep);
                
                return "UPLOAD FEITO COM SUCESSO " + file.getName() + "!";
            } catch (Exception e) {
                return "Upload Falhou " + file.getName() + " => " + e.getMessage();
            }
        } else {
            return "Upload Falhou " + file.getName() + " ERRO.";
        }

    }
	
	
	/*

	@RequestMapping(value="/excel",method = RequestMethod.GET, produces="application/vnd.ms-excel")
	public Response getFile() {

		final String FILE_PATH = "c:\\excel-file.xls";

		
	File file = new File(FILE_PATH);

	ResponseBuilder response = Response.ok((Object) file);
	response.header("Content-Disposition",
		"attachment; filename=new-excel-file.xls");
	return response.build();

}
	
	
	
	@RequestMapping(value="/txt",method = RequestMethod.GET, produces="text/plain")
	public Response getTxt() {

		final String FILE_PATH = "c:\\file.txt";

		File file = new File(FILE_PATH);

		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition",
			"attachment; filename=\"file_from_server.log\"");
		return response.build();

	}
	*/
	
	
	
}
