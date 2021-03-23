package br.com.pacato.configuration;

import org.springframework.context.annotation.Bean;
import org.thymeleaf.dialect.springdata.SpringDataDialect;

public class ThymeleafAutoConfiguration {

    @Bean
    public SpringDataDialect springDataDialect() {
        return new SpringDataDialect();
    }
}
