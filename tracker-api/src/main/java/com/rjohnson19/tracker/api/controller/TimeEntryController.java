package com.rjohnson19.tracker.api.controller;

import com.rjohnson19.tracker.api.payload.StartTimeEntryBody;
import com.rjohnson19.tracker.api.service.TimeTrackerService;
import com.rjohnson19.tracker.data.domain.TimeEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller for Time Entry RESTful APIs
 */
@RestController
public class TimeEntryController {
    private TimeTrackerService timeTrackerService;

    @Autowired
    public TimeEntryController(TimeTrackerService timeTrackerService) {
        this.timeTrackerService = timeTrackerService;
    }

    @RequestMapping(path = "/entries/recent", method = RequestMethod.GET)
    public List<TimeEntry> getRecentEntries() {
        return timeTrackerService.getRecentTimeEntries();
    }

    @RequestMapping(path = "/entries", method = RequestMethod.POST)
    public TimeEntry startTimeEntry(@RequestBody final StartTimeEntryBody startEntryBody) {
        return timeTrackerService.startTimeEntry(startEntryBody.getDescription(), startEntryBody.getProjectId());
    }

}
