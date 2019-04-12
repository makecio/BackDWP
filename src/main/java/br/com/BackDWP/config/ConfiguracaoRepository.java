package br.com.BackDWP.config;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.BackDWP.companys.CompanyEntity;
import br.com.BackDWP.file.FilesEntity;

public interface ConfiguracaoRepository extends JpaRepository<ConfiguracaoEntity, Long>{
	
	
	public ConfiguracaoEntity  findByCliente(long idcliente);

}
