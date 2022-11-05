package com.hestia.app.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository) {
        return args -> {
            User ron = new User(
                    "Ron",
                    "Kosova",
                    "ron@ron.com",
                    "$2a$10$rjPFMs8KOo1fHLnCOQSEH.GLu4HZ8.zbEVpw.JaV9EPk7E..jlPZe"
            );

            User anika = new User(
                    "Anika",
                    "Hynonen",
                    "anika.hynonen@student.hamk.fi",
                    "wowowowow"
            );

            repository.saveAll(List.of(ron, anika));
        };
    }
}
