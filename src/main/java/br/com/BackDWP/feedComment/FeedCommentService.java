package br.com.BackDWP.feedComment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.BackDWP.feed.FeedEntity;
import br.com.BackDWP.utils.ServicePath;

@RestController
@RequestMapping(path = ServicePath.FEEDCOMMENT_PATH)
public class FeedCommentService {

	
	@Autowired 
	FeedCommentRepository feedCommentRepository;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/findbyfeedCommentId/{id}",method = RequestMethod.GET)
	public ResponseEntity findbyfeedCommentId(@PathVariable("id") Long id){
		
		if (this.feedCommentRepository.findOne(id) == null) {
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		  }

		  return new ResponseEntity (this.feedCommentRepository.findOne(id), HttpStatus.OK);
		  
		 
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/findfeedcomments",method = RequestMethod.GET)
	public ResponseEntity findfeedcomments(){
		
		List<FeedCommentEntity> lsFeeds = this.feedCommentRepository.findAllOrderByData();
		
		if (lsFeeds == null) {
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		  }

		  return new ResponseEntity (lsFeeds, HttpStatus.OK);
		  
		 
	}
	
	@RequestMapping(value = "/saveFeedComment",method = RequestMethod.POST)
	public FeedCommentEntity saveFeedComment(@RequestBody FeedCommentEntity feedComment){
		
		FeedCommentEntity feedCommentBD = new FeedCommentEntity();
		
		try{
			feedCommentBD = feedCommentRepository.saveAndFlush(feedComment);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return feedCommentBD;
		  
		 
	}
}
