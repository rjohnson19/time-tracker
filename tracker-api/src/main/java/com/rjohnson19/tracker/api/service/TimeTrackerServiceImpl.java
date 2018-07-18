package com.rjohnson19.tracker.api.service;

import com.rjohnson19.tracker.data.domain.Project;
import com.rjohnson19.tracker.data.domain.TimeEntry;
import com.rjohnson19.tracker.persistence.repository.ProjectRepository;
import com.rjohnson19.tracker.persistence.repository.TimeEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class TimeTrackerServiceImpl implements TimeTrackerService {

    private TimeEntryRepository timeEntryRepository;
    private ProjectRepository projectRepository;

    @Autowired
    public TimeTrackerServiceImpl(TimeEntryRepository timeEntryRepository, ProjectRepository projectRepository) {
        this.timeEntryRepository = timeEntryRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    public List<TimeEntry> getRecentTimeEntries() {
        final List<TimeEntry> entries = new ArrayList<>();
        final List<TimeEntry> repoEntries = timeEntryRepository.findTop100ByOrderByStartTimeDesc();
        if (Objects.nonNull(repoEntries)) {
            entries.addAll(repoEntries);
        }

        return entries;
    }

    @Override
    public TimeEntry startTimeEntry(String description, Long projectId) {
        // TODO: check for already running time entry
        final Project project = resolveProjectById(projectId);
        final TimeEntry timeEntry = new TimeEntry(description, LocalDateTime.now(), null, project);
        return timeEntryRepository.save(timeEntry);
    }

    @Override
    public TimeEntry updateTimeEntry(TimeEntry timeEntry) {
        Assert.notNull(timeEntry, "timeEntry is a mandatory parameter");
        Assert.notNull(timeEntry.getId(), "Trying to update a timeEntry with no ID!");
        Assert.notNull(timeEntry.getStartTime(), "Time entry start time may not be removed.");

        final TimeEntry prevTimeEntry = timeEntryRepository.findOne(timeEntry.getId());
        Assert.notNull(prevTimeEntry, "The time entry with ID " + timeEntry.getId() + " was not found!");
        if (Objects.nonNull(timeEntry.getEndTime()) && timeEntry.getEndTime().isBefore(timeEntry.getStartTime())) {
            throw new IllegalArgumentException("Cannot set an emd time before the start time.");
        }
        return null;
    }

    @Override
    public TimeEntry endTimeEntryById(Long timeEntryId) {
        final TimeEntry timeEntry = resolveMandatoryTimeEntryById(timeEntryId);
        Assert.isNull(timeEntry.getEndTime(), "Specified time entry has already ended!");
        TimeEntry endedEntry = TimeEntry.builder(timeEntry)
                .endTime(LocalDateTime.now())
                .build();

        return timeEntryRepository.save(endedEntry);
    }

    @Override
    public TimeEntry deleteTimeEntryById(Long timeEntryId) {
        final TimeEntry timeEntry = resolveMandatoryTimeEntryById(timeEntryId);
        timeEntryRepository.delete(timeEntryId);
        return timeEntry;
    }

    private Project resolveProjectById(Long projectId) {
        Project project = null;
        if (Objects.nonNull(projectId)) {
            project = projectRepository.findOne(projectId);
            if (Objects.isNull(project)) {
                throw new IllegalArgumentException("Project with ID " + projectId + " does not exist!");
            }
        }

        return project;
    }

    private TimeEntry resolveMandatoryTimeEntryById(Long timeEntryId) {
        Assert.notNull(timeEntryId, "timeEntryId is a mandatory parameter");
        final TimeEntry timeEntry = timeEntryRepository.findOne(timeEntryId);
        if (Objects.isNull(timeEntry)) {
            throw new IllegalArgumentException("Time entry with ID " + timeEntryId + " does not exist!");
        }

        return timeEntry;
    }
}
