package br.com.BackDWP.user;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.BackDWP.utils.GenericService;
import br.com.BackDWP.utils.ServicePath;


@RestController
@RequestMapping(path = ServicePath.USER_PATH)
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
		
	
	public UserEntity insert(@RequestBody UserEntity entity){
		
		entity.setCreated(new Date());
		
		return userRepository.saveAndFlush(entity);
	}
	
	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/findbyid/{id}",method = RequestMethod.GET)
	public ResponseEntity findByid(@PathVariable("id") Long id){
		
		if (this.userRepository.findOne(id) == null) {
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		  }

		  return new ResponseEntity (this.userRepository.findOne(id), HttpStatus.OK);
		  
		 
	}

	
}
