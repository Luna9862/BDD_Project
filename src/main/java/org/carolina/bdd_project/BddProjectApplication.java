package org.carolina.bdd_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableJpaRepositories("org.carolina.bdd_project.repository")
@EntityScan("org.carolina.bdd_project.model")  // Add this if necessary
public class BddProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(BddProjectApplication.class, args);
    }
}
