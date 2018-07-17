package com.rjohnson19.tracker.persistence.repository;

import com.rjohnson19.tracker.data.domain.Project;
import com.rjohnson19.tracker.data.domain.TimeEntry;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TimeEntryRepository extends CrudRepository<TimeEntry, Long> {
    List<TimeEntry> findByProject(Project project);

    /**
     * Find the top 100 most recent time entries by start time.
     * @return List of time entries (may be empty)
     */
    List<TimeEntry> findTop100ByOrderByStartTimeDesc();
}
