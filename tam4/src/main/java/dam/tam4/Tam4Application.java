package dam.tam4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("dam.tam4")
public class Tam4Application {

	public static void main(String[] args) {
		SpringApplication.run(Tam4Application.class, args);
	}

}
