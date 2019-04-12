package br.com.BackDWP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.BackDWP.utils.AppContext;

@SpringBootApplication
public class BackDWPMain {
	
	public static void main(String[] args){
		
		SpringApplication.run(AppContext.class, args);
	}

}
