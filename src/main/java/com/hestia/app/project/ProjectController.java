package com.hestia.app.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/projects")
public class ProjectController {
    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public List<Project> getProjects() {
        return projectService.getProjects();
    }

    @PostMapping("/create")
    public void addProjects(@RequestBody MultiValueMap<String, String> request) {
        Project project = new Project();
        project.setName(request.getFirst("name"));
        project.setDescription(request.getFirst("description"));
        projectService.addProject(project, Long.getLong(request.getFirst("userId"))); // use Session ID
    }

    @DeleteMapping(path = "{projectId}")
    public void deleteProject(@PathVariable("projectId") Long projectId) {
        projectService.deleteProject(projectId);
    }
}
