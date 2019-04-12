package br.com.BackDWP.permissionsFolder;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionsFolderRepository extends JpaRepository<PermissionsFolderEntity,Long>{

	

		
		
		public List<PermissionsFolderEntity>findByFolderId(Long folderid);

	

}
