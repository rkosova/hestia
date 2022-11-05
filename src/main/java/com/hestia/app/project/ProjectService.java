package com.hestia.app.project;

import com.hestia.app.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository, UserRepository userRepository) {
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
    }

    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    public void addProject(Project project, Long userId) {
        project.setUser(userRepository.findById(userId).get());
        projectRepository.save(project);
    }

    public void deleteProject(Long projectId) {
        if (!projectRepository.existsById(projectId)) {
            throw new IllegalStateException("Project does not exist!");
        }

        projectRepository.deleteById(projectId);
    }

}
