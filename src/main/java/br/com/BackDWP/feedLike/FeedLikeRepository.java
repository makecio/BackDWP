package br.com.BackDWP.feedLike;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FeedLikeRepository extends JpaRepository<FeedLikeEntity,Long>{

	@Query("SELECT COUNT(u) FROM FeedLikeEntity u WHERE u.idFeedComment=?1 and tipo = 0")
    public Long countByFeed(Long idFeedComment);
	
	@Query(value="SELECT COUNT(u) as qtd, u.idFeedComment as idFeedComment FROM FeedLikeEntity u group by u.idFeedComment") 
	public List<FeedLikeEntity> buscaTodosGroupByCount();
	
	@Query("SELECT u FROM FeedLikeEntity u WHERE u.idFeedComment=?1 and u.idUser=?2")
    public FeedLikeEntity buscaFeedLike(Long idFeedComment,Long idUser);
}
