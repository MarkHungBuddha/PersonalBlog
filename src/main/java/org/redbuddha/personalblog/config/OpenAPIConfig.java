/*
 * Copyright (c) 2024 - redBuddhaHung.
  */
package org.redbuddha.personalblog.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
  @Bean
  public OpenAPI myOpenAPI() {
    Contact contact = new Contact();
    contact.setEmail("1909kram@gmail.com");
    contact.setName("RedBuddhaHung");

    Info info =
        new Info().title("Blog API").version("1.0").contact(contact).description("個人部落格 API 文檔");

    return new OpenAPI().info(info);
  }
}
