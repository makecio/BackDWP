package br.com.BackDWP.feedShare;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.BackDWP.utils.ServicePath;

@RestController
@RequestMapping(path = ServicePath.FILE_DETAIL_PATH)
public class FeedShareService {

	
	@Autowired 
	FeedShareRepository feedShareRepository;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/findbyfeedShareId/{id}",method = RequestMethod.GET)
	public ResponseEntity findByfileid(@PathVariable("id") Long id){
		
		if (this.feedShareRepository.findOne(id) == null) {
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		  }

		  return new ResponseEntity (this.feedShareRepository.findOne(id), HttpStatus.OK);
		  
		 
	}
}
