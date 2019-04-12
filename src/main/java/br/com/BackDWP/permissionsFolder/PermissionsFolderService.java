package br.com.BackDWP.permissionsFolder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.BackDWP.utils.GenericService;
import br.com.BackDWP.utils.ServicePath;

@RestController
@RequestMapping(path = ServicePath.PERMISSIONFOLDER_PATH)
public class PermissionsFolderService {

	
	@Autowired 
	PermissionsFolderRepository permissionsfolderRespository;
	
	private ResourceLoader resourceLoader = new DefaultResourceLoader();
	
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/findbyfolderid/{id}",method = RequestMethod.GET)
	public ResponseEntity findByFolder(@PathVariable("id") Long id){
		
		if (this.permissionsfolderRespository.findByFolderId(id).size() == 0) {
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		  }

		  return new ResponseEntity<List <PermissionsFolderEntity>>(this.permissionsfolderRespository.findByFolderId(id), HttpStatus.OK);
		
		 
	}
}
