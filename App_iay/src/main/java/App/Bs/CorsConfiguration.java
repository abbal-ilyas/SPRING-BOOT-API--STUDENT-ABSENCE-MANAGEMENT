package App.Bs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Autoriser les requêtes CORS pour toutes les routes
                        .allowedOrigins("http://localhost:3000") // Autoriser votre origine frontend
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Autoriser les méthodes nécessaires
                        .allowedHeaders("*") // Autoriser tous les headers
                        .allowCredentials(true); // Autoriser les cookies et l'authentification par session si nécessaire
            }
        };
    }
}
