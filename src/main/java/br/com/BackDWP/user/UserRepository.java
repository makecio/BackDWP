package br.com.BackDWP.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
	
	public UserEntity  findByName(String name);
	
	public List<UserEntity> findAll();

}
