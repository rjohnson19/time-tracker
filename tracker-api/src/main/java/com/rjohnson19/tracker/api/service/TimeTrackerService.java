package com.rjohnson19.tracker.api.service;

import com.rjohnson19.tracker.data.domain.TimeEntry;

import java.util.List;

/**
 * Service for managing time tracking entries.
 */
public interface TimeTrackerService {
    /**
     * Get recent time entries ordered by start date (most recent first)
     *
     * @return List of recent time entries.
     */
    List<TimeEntry> getRecentTimeEntries();

    /**
     * Start a new time entry.
     * - You can't start a new time entry if one is still running (not ended).
     *
     * @param description Optional description of the new time entry.
     * @param projectId   Optional project ID of a project the entry is related to.
     * @return The new TimeEntry, started at the current local time.
     */
    TimeEntry startTimeEntry(String description, Long projectId);

    /**
     * Update an existing time entry.
     * - The end date can't be before the start date.
     * - Once set, an end date can't be unset.
     *
     * @param timeEntry The time entry to update
     * @return Updated TimeEntry.
     */
    TimeEntry updateTimeEntry(TimeEntry timeEntry);

    /**
     * End a time entry by ID. The end time will be the current local time.
     * - You can't end a time entry more than once.
     *
     * @param timeEntryId The ID of the time entry to end.
     * @return Updated TimeEntry.
     */
    TimeEntry endTimeEntryById(Long timeEntryId);

    /**
     * Delete a time entry by ID.
     *
     * @param timeEntryId ID of the time entry to delete.
     * @return The TimeEntry that was deleted.
     */
    TimeEntry deleteTimeEntryById(Long timeEntryId);
}
