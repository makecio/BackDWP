package br.com.BackDWP.client;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.BackDWP.utils.ServicePath;

@RestController
@RequestMapping(path = ServicePath.CLIENTE_PATH)
public class ClientService {
	
	@Autowired 
	ClientRepository clienteRepository;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/findbyid/{id}",method = RequestMethod.GET)
	public ResponseEntity findByid(@PathVariable("id") Long id){
		
		if (this.clienteRepository.findOne(id) == null) {
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		  }

		  return new ResponseEntity (this.clienteRepository.findOne(id), HttpStatus.OK);
		  
		 
	}
	

}
