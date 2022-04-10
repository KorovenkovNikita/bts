package com.vhs.bts.settings;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "bts", description = "Best Technical Store",
        version = "1.0", contact = @Contact(name = "Korovenkov Nikita", email = "korovenkov.nik@mail.ru")))
public class SwaggerConfiguration {

}
