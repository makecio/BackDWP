package br.com.test.backrest.main.repositories;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.BackDWP.user.UserEntity;
import br.com.BackDWP.user.UserRepository;
import br.com.test.backrest.AbstractTest;

public class UserRepositoryTest extends AbstractTest{
	
private static final Logger LOGGER = Logger.getLogger(UserRepositoryTest.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void testFindAll(){
		
		List<UserEntity> files = this.userRepository.findAll();
		
		LOGGER.info(files);
	}

}
