package com.javamentor.kidstarter;

//import com.javamentor.kidstarter.config.initializer.DataInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KidstarterApplication {

	public static void main(String[] args) {
		SpringApplication.run(KidstarterApplication.class, args);
	}

//	@Bean(initMethod = "init")
//	public DataInitializer initializer() {
//		return  new DataInitializer();
//	}
}
