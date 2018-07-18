package com.rjohnson19.tracker.api.controller;

import com.rjohnson19.tracker.api.service.ProjectService;
import com.rjohnson19.tracker.data.domain.Project;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {
    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @RequestMapping(path = "/projects", method = RequestMethod.GET)
    public List<Project> getProjects() {
        return projectService.getProjects();
    }

    @RequestMapping(path = "/projects", method = RequestMethod.POST)
    public Project addProject(@RequestBody String name) {
        return projectService.addProject(new Project(name));
    }

    @RequestMapping(path = "/projects/{projectId}", method = RequestMethod.DELETE)
    public Project deleteProjectById(@PathVariable("projectId") final Long projectId) {
        return projectService.deleteProjectById(projectId);
    }
}
