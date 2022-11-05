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
            Skill python = new Skill(
                    "Python"
            );
            Skill kotlin = new Skill(
                    "Kotlin"
            );
            Skill php = new Skill(
                    "PHP"
            );
            Skill htmlcss = new Skill(
                    "HTML/CSS"
            );
            Skill react = new Skill(
                    "React"
            );
            Skill reactNative = new Skill(
                    "ReactNative"
            );
            Skill NET = new Skill(
                    ".NET"
            );
            Skill Swift = new Skill(
                    "Swift"
            );
            Skill Ruby = new Skill(
                    "Ruby"
            );
            Skill C = new Skill(
                    "C"
            );
            Skill Cplusplus = new Skill(
                    "C++"
            );
            Skill Csharp = new Skill(
                    "C#"
            );
            Skill JS = new Skill(
                    "JavaScript"
            );
            Skill SQL = new Skill(
                    "SQL"
            );
            Skill NoSQL = new Skill(
                    "NoSQL"
            );
            Skill Rust = new Skill(
                    "Rust"
            );
            Skill Perl = new Skill(
                    "Perl"
            );
            Skill Go = new Skill(
                    "Go"
            );

            repository.saveAll(List.of());
        };
    }
}