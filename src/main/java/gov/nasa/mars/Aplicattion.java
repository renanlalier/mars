package gov.nasa.mars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("gov.nasa.mars")
public class Aplicattion {
	
	public static void main(String[] args) {
		SpringApplication.run(Aplicattion.class, args);
	}

}
