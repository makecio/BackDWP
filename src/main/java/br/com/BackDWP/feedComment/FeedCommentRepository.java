package br.com.BackDWP.feedComment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.BackDWP.feed.FeedEntity;



public interface FeedCommentRepository extends JpaRepository<FeedCommentEntity,Long>{

	public List<FeedCommentEntity> findByIdFeed(int idFeed);
	
	@Query(value="SELECT * FROM tb_feedcomment ORDER BY data DESC",  nativeQuery = true) 
	public List<FeedCommentEntity> findAllOrderByData();
}
