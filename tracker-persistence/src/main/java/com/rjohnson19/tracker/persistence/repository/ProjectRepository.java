package com.rjohnson19.tracker.persistence.repository;

import com.rjohnson19.tracker.data.domain.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long> {
}
