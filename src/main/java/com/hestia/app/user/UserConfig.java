package com.hestia.app.user;

import com.hestia.app.project.Project;
import com.hestia.app.project.ProjectRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository, ProjectRepository repository2) {
        return args -> {
            User ron = new User(
                    "Ron",
                    "Kosova",
                    "eduardo.sbassani@gmail.com",
                    "$2a$10$rjPFMs8KOo1fHLnCOQSEH.GLu4HZ8.zbEVpw.JaV9EPk7E..jlPZe"
            );

            User anika = new User(
                    "Anika",
                    "Hynonen",
                    "anika.hynonen@student.hamk.fi",
                    "wowowowow"
            );

            Project pro = new Project(1L,"name","description", ron);



            repository.saveAll(List.of(ron, anika));
            repository2.save(pro);
        };
    }
}
