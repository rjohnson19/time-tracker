package com.rjohnson19.tracker.data.domain;

import com.rjohnson19.tracker.data.converter.LocalDateTimeConverter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity(name = "time_entry")
public class TimeEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String description;

    @Column(nullable = false)
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime startTime;

    @Column
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime endTime;

    @OneToOne
    private Project project;

    public TimeEntry(String description, LocalDateTime startTime, LocalDateTime endTime, Project project) {
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.project = project;
    }

    protected TimeEntry() {
    }

    public Long getId() {
        return id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeEntry timeEntry = (TimeEntry) o;
        return Objects.equals(id, timeEntry.id) &&
                Objects.equals(description, timeEntry.description) &&
                Objects.equals(startTime, timeEntry.startTime) &&
                Objects.equals(endTime, timeEntry.endTime) &&
                Objects.equals(project, timeEntry.project);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, startTime, endTime, project);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TimeEntry{");
        sb.append("id=").append(id);
        sb.append(", description='").append(description).append('\'');
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", project=").append(project);
        sb.append('}');
        return sb.toString();
    }
}
