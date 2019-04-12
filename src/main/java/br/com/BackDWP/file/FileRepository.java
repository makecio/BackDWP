	package br.com.BackDWP.file;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.BackDWP.user.UserEntity;
import br.com.BackDWP.user.UserRepository;

public interface FileRepository extends JpaRepository<FilesEntity,Long> {
	
	
	
		
	
	public List<FilesEntity> findByUserId(int iduser);
	public List<FilesEntity> findByFolderId(int idfolder);

}
