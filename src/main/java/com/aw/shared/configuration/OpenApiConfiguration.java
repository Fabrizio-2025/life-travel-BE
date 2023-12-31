package com.aw.shared.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("OpenApiConfiguration")
public class OpenApiConfiguration {

    @Bean
    public CustomOpenApi customOpenApi(Project project) {
        return (CustomOpenApi) new CustomOpenApi(project)
                .components(new Components())
                .info(new Info().title(project.getProjectTitle()).description(project.getProjectDescription()).contact(new Contact().name(project.getAuthorName()).url(project.getAuthorGithubUrl())));
    }

    @Bean
    public Project project() {
        return new Project("Life-Travel", "This project is Life travel, which deals with hotel management and package sales.", "https://github.com/Fabrizio-2025", "Life-Travel");
    }

}
