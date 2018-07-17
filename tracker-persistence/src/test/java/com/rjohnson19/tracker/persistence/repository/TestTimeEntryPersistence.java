package com.rjohnson19.tracker.persistence.repository;

import com.rjohnson19.tracker.data.domain.Project;
import com.rjohnson19.tracker.data.domain.TimeEntry;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
@EntityScan("com.rjohnson19.tracker.data.domain")
public class TestTimeEntryPersistence {
    @Autowired
    private TimeEntryRepository timeEntryRepository;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testFindByProject() {
        final Project project = new Project("test project");
        final Project savedProject = entityManager.persist(project);

        List<TimeEntry> initialState = timeEntryRepository.findByProject(savedProject);
        assertTrue("Should not have any time entries by project initially.", initialState.isEmpty());

        final TimeEntry noProjectEntry = entityManager.persist(new TimeEntry("entry1", LocalDateTime.now(),
                null, null));

        final TimeEntry testProjectEntry = entityManager.persist(new TimeEntry("entry2", LocalDateTime.now(),
                null, savedProject));

        List<TimeEntry> projectEntries = timeEntryRepository.findByProject(savedProject);
        assertEquals("Should find 1 entry.", 1, projectEntries.size());
        assertEquals("Should find expected entry.", testProjectEntry.getDescription(), projectEntries.get(0).getDescription());
    }


}
