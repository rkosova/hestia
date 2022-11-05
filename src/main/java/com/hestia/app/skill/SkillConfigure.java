package com.hestia.app.skill;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SkillConfigure {
    @Bean
    CommandLineRunner commandLineRunner(SkillRepository repository) {
        return args -> {
            Skill java = new Skill(
                    "Java"
            );

            repository.saveAll(List.of());
        };
    }
}