package App.Bs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;


@SpringBootApplication
public class IayApplication {

	public static void main(String[] args) {

		SpringApplication.run(IayApplication.class);
	}

}
