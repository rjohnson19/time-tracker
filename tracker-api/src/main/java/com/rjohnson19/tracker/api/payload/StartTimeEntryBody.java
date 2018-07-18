package com.rjohnson19.tracker.api.payload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StartTimeEntryBody {
    private String description;
    private Long projectId;

    @JsonCreator
    public StartTimeEntryBody(@JsonProperty("description") final String description,
                              @JsonProperty("projectId") final Long projectId) {
        this.description = description;
        this.projectId = projectId;
    }

    public String getDescription() {
        return description;
    }

    public Long getProjectId() {
        return projectId;
    }

}
