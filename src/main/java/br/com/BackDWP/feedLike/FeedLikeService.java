package br.com.BackDWP.feedLike;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.BackDWP.utils.ServicePath;

@RestController
@RequestMapping(path = ServicePath.FEEDLIKE_PATH)
public class FeedLikeService {

	
	@Autowired 
	FeedLikeRepository feedLikeRepository;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/findbyfeedLikeId/{id}",method = RequestMethod.GET)
	public ResponseEntity findbyfeedLikeId(@PathVariable("id") Long id){
		
		if (this.feedLikeRepository.findOne(id) == null) {
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		  }

		  return new ResponseEntity (this.feedLikeRepository.findOne(id), HttpStatus.OK);
	 
	}
	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/findfeedlikes",method = RequestMethod.GET)
	public ResponseEntity findfeedlikes(){
		
		List<FeedLikeEntity> lsFeedlikes = this.feedLikeRepository.buscaTodosGroupByCount();
		
		if (lsFeedlikes == null) {
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
				
		return new ResponseEntity (lsFeedlikes, HttpStatus.OK);
		  
		 
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/findfeedlike/{idFeedComment}/{idUser}",method = RequestMethod.GET)
	public ResponseEntity findfeedlike(@PathVariable("idFeedComment") Long idFeedComment, @PathVariable("idUser") Long idUser){
		
		FeedLikeEntity Feedlikes = this.feedLikeRepository.buscaFeedLike(idFeedComment, idUser);
		
	
		return new ResponseEntity (Feedlikes, HttpStatus.OK);
		  
		 
	}
	
	@RequestMapping(value = "/saveFeedLike",method = RequestMethod.POST)
	public FeedLikeEntity saveFeedLike(@RequestBody FeedLikeEntity feedLike){
		
		FeedLikeEntity feedLikeEntityBD = new FeedLikeEntity();
		
		try{
			feedLikeEntityBD = feedLikeRepository.saveAndFlush(feedLike);
			feedLikeEntityBD.setQtd(feedLikeRepository.countByFeed(feedLikeEntityBD.getIdFeedComment()));
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return feedLikeEntityBD;
		  
		 
	}
}
