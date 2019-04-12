package br.com.BackDWP.folder;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FolderRepository extends JpaRepository<FolderEntity,Long>{
	
	
	public List<FolderEntity>findByUser(Long iduser);
	
	//public FolderEntity findByUserIdAnd

}
