package App.Bs;


import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.AbstractNeo4jConfig;
import org.springframework.data.neo4j.core.DatabaseSelection;
import org.springframework.data.neo4j.core.Neo4jClient;
import org.springframework.data.neo4j.core.Neo4jTemplate;
import org.springframework.data.neo4j.core.mapping.Neo4jMappingContext;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@Configuration
@EnableNeo4jRepositories(basePackages = "App.Bs")
@EnableTransactionManagement
public class Neo4jConfig extends AbstractNeo4jConfig {


	protected Neo4jMappingContext neo4jMappingContext() {
		return new Neo4jMappingContext();
	}

	@Bean
	public Neo4jClient neo4jClient() {
		return Neo4jClient.create(driver());
	}


	@Bean
	public Neo4jTemplate neo4jTemplate(Neo4jClient neo4jClient, Neo4jMappingContext mappingContext) {
		return new Neo4jTemplate(neo4jClient, mappingContext);
	}

	@Bean
	protected DatabaseSelection getDefaultDatabaseSelection() {
		return DatabaseSelection.byName("neo4j");
	}

	@Bean
	@Override
	public Driver driver() {
		return GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "password"));
	}
}
