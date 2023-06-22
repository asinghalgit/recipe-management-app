package com.abnamro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = "com.abnamro")
@EnableJpaRepositories
@EnableSwagger2
public class RecipeManagementApp {

    public static void main(String[] args) {
        SpringApplication.run(RecipeManagementApp.class, args);
    }

}
