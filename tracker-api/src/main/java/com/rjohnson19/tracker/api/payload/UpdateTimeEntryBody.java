package com.rjohnson19.tracker.api.payload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateTimeEntryBody {
    private String description;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Long projectId;

    @JsonCreator
    public UpdateTimeEntryBody(
            @JsonProperty("description") String description,
            @JsonProperty("startTime") LocalDateTime startTime,
            @JsonProperty("endTime") LocalDateTime endTime,
            @JsonProperty("projectId") Long projectId) {
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.projectId = projectId;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public Long getProjectId() {
        return projectId;
    }
}
