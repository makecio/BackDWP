package br.com.BackDWP.feed;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FeedRepository extends JpaRepository<FeedEntity,Long>{

	@Query(value="SELECT * FROM tb_feed ORDER BY data DESC",  nativeQuery = true) 
	public List<FeedEntity> findAllOrderByData();
	
}
