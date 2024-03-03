package com.player.playerbackendtask.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI myAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Players registry API")
                        .version("1.0"));
    }
}