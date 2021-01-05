package dam.tam4;

import java.nio.file.Paths;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("dam.tam4")
public class Tam4Application {

	public static void main(String[] args) {
		String log4jConfPath = Paths.get("src", "main", "resources", "log4j.properties").toString();
		PropertyConfigurator.configure(log4jConfPath);

		SpringApplication.run(Tam4Application.class, args);
	}
}
