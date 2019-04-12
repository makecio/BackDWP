package br.com.test.backrest;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import br.com.BackDWP.utils.AppContext;

@Configuration
@Import(value= { AppContext.class})
@ComponentScan(basePackages = {"br.com.test.backrest"})
public class AppContextTest {

}
