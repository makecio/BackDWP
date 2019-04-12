package br.com.BackDWP.folder;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.BackDWP.client.ClientRepository;
import br.com.BackDWP.config.ConfiguracaoEntity;
import br.com.BackDWP.config.ConfiguracaoRepository;
import br.com.BackDWP.file.FilesEntity;
import br.com.BackDWP.file.FileRepository;
import br.com.BackDWP.utils.GenericService;
import br.com.BackDWP.utils.ServicePath;

@RestController
@RequestMapping(path = ServicePath.FOLDER_PATH)
public class FolderService {
	
	
	
	@Autowired 
	FolderRepository folderRepository;
	
	@Autowired
	ConfiguracaoRepository configRepository;
	
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/folderuser/{id}",method = RequestMethod.GET)
	public ResponseEntity findByUser(@PathVariable("id") Long id){
		
		
		FolderEntity folder = folderRepository.findOne(id);
		
		if(folder !=null){
				
				ConfiguracaoEntity config = configRepository.findByCliente(id);
		
				File diretorio = new File(config.getDirRaiz()+folder.getPathAbsoluto()); // ajfilho é uma pasta!
				if (!diretorio.exists()) {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);} 
			}

		  return new ResponseEntity<List <FolderEntity>>(this.folderRepository.findByUser(id), HttpStatus.OK);
		
		 
	}
	
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/findbyid/{id}",method = RequestMethod.GET)
	public ResponseEntity findByid(@PathVariable("id") Long id){
		
		if (this.folderRepository.findOne(id) == null) {
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		  }

		  return new ResponseEntity (this.folderRepository.findOne(id), HttpStatus.OK);
		  
		 
	}
	

}
