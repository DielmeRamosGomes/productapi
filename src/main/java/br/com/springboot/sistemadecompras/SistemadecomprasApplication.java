package br.com.springboot.sistemadecompras;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@ComponentScan({"br.com.springboot.sistemadecompras.controller"})
//@EntityScan("br.com.springboot.sistemadecompras.entity")
//@EnableJpaRepositories("br.com.springboot.sistemadecompras.repository")
@SpringBootApplication
public class SistemadecomprasApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemadecomprasApplication.class, args);
	}

}
