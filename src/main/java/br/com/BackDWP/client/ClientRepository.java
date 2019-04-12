package br.com.BackDWP.client;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.BackDWP.file.FilesEntity;

public interface ClientRepository extends JpaRepository<ClientEntity,Long>{

}
