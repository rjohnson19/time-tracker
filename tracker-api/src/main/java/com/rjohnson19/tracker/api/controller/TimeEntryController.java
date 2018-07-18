package com.rjohnson19.tracker.api.controller;

import com.rjohnson19.tracker.api.payload.StartTimeEntryBody;
import com.rjohnson19.tracker.api.payload.UpdateTimeEntryBody;
import com.rjohnson19.tracker.api.service.ProjectService;
import com.rjohnson19.tracker.api.service.TimeTrackerService;
import com.rjohnson19.tracker.data.domain.Project;
import com.rjohnson19.tracker.data.domain.TimeEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * Controller for Time Entry RESTful APIs
 */
@RestController
public class TimeEntryController {
    private TimeTrackerService timeTrackerService;
    private ProjectService projectService;

    @Autowired
    public TimeEntryController(TimeTrackerService timeTrackerService, ProjectService projectService) {
        this.timeTrackerService = timeTrackerService;
        this.projectService = projectService;
    }

    @RequestMapping(path = "/entries/recent", method = RequestMethod.GET)
    public List<TimeEntry> getRecentEntries() {
        return timeTrackerService.getRecentTimeEntries();
    }

    @RequestMapping(path = "/entries", method = RequestMethod.POST)
    public TimeEntry startTimeEntry(@RequestBody final StartTimeEntryBody startEntryBody) {
        return timeTrackerService.startTimeEntry(startEntryBody.getDescription(), startEntryBody.getProjectId());
    }

    @RequestMapping(path = "/entries/{timeEntryId}/end", method = RequestMethod.PUT)
    public TimeEntry endTimeEntry(@PathVariable("timeEntryId") final Long timeEntryId) {
        return timeTrackerService.endTimeEntryById(timeEntryId);
    }

    @RequestMapping(path = "/entries/{timeEntryId}", method = RequestMethod.DELETE)
    public TimeEntry deleteTimeEntry(@PathVariable("timeEntryId") final Long timeEntryId) {
        return timeTrackerService.deleteTimeEntryById(timeEntryId);
    }

    @RequestMapping(path = "/entries{timeEntryId}", method = RequestMethod.POST)
    public TimeEntry updateTimeEntry(@PathVariable("timeEntryId") final Long timeEntryId,
                                     @RequestBody final UpdateTimeEntryBody body) {
        Project project = null;
        if (Objects.nonNull(body.getProjectId())) {
            project = projectService.getProjectById(body.getProjectId());
            Assert.notNull(project, "Project with ID " + body.getProjectId() + " does not exist!");
        }
        final TimeEntry timeEntry = TimeEntry.builder()
                .id(timeEntryId)
                .description(body.getDescription())
                .startTime(body.getStartTime())
                .endTime(body.getEndTime())
                .project(project)
                .build();

        return timeTrackerService.updateTimeEntry(timeEntry);
    }

}
