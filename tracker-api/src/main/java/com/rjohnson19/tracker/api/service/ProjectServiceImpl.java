package com.rjohnson19.tracker.api.service;

import com.rjohnson19.tracker.data.domain.Project;
import com.rjohnson19.tracker.persistence.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ProjectServiceImpl implements ProjectService {
    private ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Project> getProjects() {
        final List<Project> projects = new ArrayList<>();
        final Iterable<Project> repoProjects = projectRepository.findAll();
        if (Objects.nonNull(repoProjects)) {
            repoProjects.forEach(projects::add);
        }

        return projects;
    }

    @Override
    public Project addProject(Project project) {
        Assert.notNull(project, "project is a mandatory parameter.");
        if (StringUtils.isEmpty(project.getName())) {
            throw new IllegalArgumentException("Project name may not be empty.");
        }
        // TODO: check if project name already exists

        return projectRepository.save(project);
    }

    @Override
    public Project deleteProjectById(Long id) {
        Assert.notNull(id, "id is a mandatory parameter.");
        final Project project = projectRepository.findOne(id);
        if (Objects.nonNull(project)) {
            projectRepository.delete(id);
        }
        return project;
    }
}
