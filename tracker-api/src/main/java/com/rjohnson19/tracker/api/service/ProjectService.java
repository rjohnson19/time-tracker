package com.rjohnson19.tracker.api.service;

import com.rjohnson19.tracker.data.domain.Project;

import java.util.List;

/**
 * Service for managing time trackable projects.
 */
public interface ProjectService {
    /**
     * Get all projects.
     *
     * @return List of all projects. May be empty.
     */
    List<Project> getProjects();

    /**
     * Add a new project.
     *
     * @param project The project to add.
     * @return Added project.
     */
    Project addProject(Project project);

    /**
     * Delete a project by its ID.
     *
     * @param id The project ID to delete.
     * @return The project that was deleted.
     */
    Project deleteProjectById(Long id);
}
