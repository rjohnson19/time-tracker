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

    public TimeEntry(Long id, String description, LocalDateTime startTime, LocalDateTime endTime, Project project) {
        this.id = id;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.project = project;
    }

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

    public Project getProject() {
        return project;
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
    public static TimeEntryBuilder builder() {
        return new TimeEntryBuilder();
    }

    public static TimeEntryBuilder builder(final TimeEntry timeEntry) {
        return new TimeEntryBuilder(timeEntry);
    }

    public static final class TimeEntryBuilder {
        private Long id;
        private String description;
        private LocalDateTime startTime;
        private LocalDateTime endTime;
        private Project project;

        private TimeEntryBuilder() {
        }

        private TimeEntryBuilder(TimeEntry other) {
            this.id = other.id;
            this.description = other.description;
            this.startTime = other.startTime;
            this.endTime = other.endTime;
            this.project = other.project;
        }

        public TimeEntryBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public TimeEntryBuilder description(String description) {
            this.description = description;
            return this;
        }

        public TimeEntryBuilder startTime(LocalDateTime startTime) {
            this.startTime = startTime;
            return this;
        }

        public TimeEntryBuilder endTime(LocalDateTime endTime) {
            this.endTime = endTime;
            return this;
        }

        public TimeEntryBuilder project(Project project) {
            this.project = project;
            return this;
        }

        public TimeEntry build() {
            return new TimeEntry(id, description, startTime, endTime, project);
        }
    }
}
