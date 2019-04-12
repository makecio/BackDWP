package br.com.BackDWP.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.BackDWP.utils.ServicePath;

//@Path("/fileservice")
@RequestMapping(path = ServicePath.FILE_PATH)
public class UploadFile {

	 
	    public static final String UPLOAD_FILE_SERVER = "c:/temp/upload/";
	 
	   
	 
	    // http://localhost:8080/Jersey-UP-DOWN-Image-File/rest/fileservice/upload/images
	    
	    //@Path("/upload/images")
	    @POST
	    @RequestMapping(value = "/upload/images", method = RequestMethod.POST)	    
	    @Consumes(MediaType.MULTIPART_FORM_DATA)
	    public Response uploadImageFile(
	            @FormDataParam("uploadFile") InputStream fileInputStream,
	            @FormDataParam("uploadFile") FormDataContentDisposition fileFormDataContentDisposition) {
	 
	        // local variables
	        String fileName = null;
	        String uploadFilePath = null;
	 
	        try {
	            fileName = fileFormDataContentDisposition.getFileName();
	            uploadFilePath = writeToFileServer(fileInputStream, fileName);
	        }
	        catch(IOException ioe){
	            ioe.printStackTrace();
	        }
	        finally{
	            // release resources, if any
	        }
	        return Response.ok("File uploaded successfully at " + uploadFilePath).build();
	    }
	 
	    /**
	     * write input stream to file server
	     * @param inputStream
	     * @param fileName
	     * @throws IOException
	     */
	    private String writeToFileServer(InputStream inputStream, String fileName) throws IOException {
	 
	        OutputStream outputStream = null;
	        String qualifiedUploadFilePath = UPLOAD_FILE_SERVER + fileName;
	 
	        try {
	            outputStream = new FileOutputStream(new File(qualifiedUploadFilePath));
	            int read = 0;
	            byte[] bytes = new byte[1024];
	            while ((read = inputStream.read(bytes)) != -1) {
	                outputStream.write(bytes, 0, read);
	            }
	            outputStream.flush();
	        }
	        catch (IOException ioe) {
	            ioe.printStackTrace();
	        }
	        finally{
	            //release resource, if any
	            outputStream.close();
	        }
	        return qualifiedUploadFilePath;
	    }
	}

