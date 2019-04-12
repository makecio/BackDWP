package br.com.test.backrest.main.repositories;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.BackDWP.file.FilesEntity;
import br.com.BackDWP.file.FileRepository;
import br.com.test.backrest.AbstractTest;

public class FilesRepositoryTest extends AbstractTest{
	
	private static final Logger LOGGER = Logger.getLogger(FilesRepositoryTest.class);
	
	@Autowired
	private FileRepository filesRepository;
	
	@Test
	public void testFindAll(){
		
		List<FilesEntity> files = this.filesRepository.findAll();
		
		LOGGER.info(files);
	}

}
