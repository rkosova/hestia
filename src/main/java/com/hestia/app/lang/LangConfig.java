package com.hestia.app.lang;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class LangConfig {
    @Bean
    CommandLineRunner langRunner(LangRepository repository) {
        return args -> {
            Language java = new Language(
              "Java",
                ""
                    );

            Language python = new Language(
                    "python",
                    ""
                    );
            repository.saveAll(List.of(java, python));
        };
    }
}