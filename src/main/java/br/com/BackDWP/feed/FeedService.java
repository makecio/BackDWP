package br.com.BackDWP.feed;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.BackDWP.feedLike.FeedLikeRepository;
import br.com.BackDWP.user.UserRepository;
import br.com.BackDWP.utils.ServicePath;

@RestController
@RequestMapping(path = ServicePath.FEED_PATH)
public class FeedService {

	
	@Autowired 
	FeedRepository feedRepository;
	
	@Autowired 
	UserRepository userRepository;
	
	@Autowired 
	FeedLikeRepository feedLikeRepository;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/findbyfeedId/{id}",method = RequestMethod.GET)
	public ResponseEntity findByfeedid(@PathVariable("id") Long id){
		
		if (this.feedRepository.findOne(id) == null) {
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		  }

		  return new ResponseEntity (this.feedRepository.findOne(id), HttpStatus.OK);
		  
		 
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/findfeeds",method = RequestMethod.GET)
	public ResponseEntity findfeeds(){
		
		List<FeedEntity> lsFeeds = this.feedRepository.findAllOrderByData();
		
		if (lsFeeds == null) {
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
		
		for(FeedEntity f: lsFeeds){
			f.setQtdLikes(feedLikeRepository.countByFeed(f.getId()));
		}
		
		return new ResponseEntity (lsFeeds, HttpStatus.OK);
		  
		 
	}
	
	@RequestMapping(value = "/saveFeed",method = RequestMethod.POST)
	public Long saveFeed(@RequestBody FeedEntity feed){
		
		FeedEntity feedBD = new FeedEntity();
		
		try{
			feedBD = feedRepository.save(feed);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return feedBD.getId();
		  
		 
	}
}
