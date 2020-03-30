package br.com.project.domain.repository;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import br.com.project.domain.entity.Project;
import com.google.common.collect.ImmutableList;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class ProjectRepositoryTest {

  @Autowired private ProjectRepository repository;

  @Test
  void save() {
    final var projectName = createObjectToSave(null);
    final var expected = createObjectToSave(4L);

    final Project save = repository.save(projectName);

    assertThat(save, is(equalTo(expected)));
  }

  @Test
  void findAll() {
    final var expectedProjects = getExpectedProjects().get(0);

    var savedProjects = repository.findAll().iterator().next();
    savedProjects.setActivityProjectId(null);
    savedProjects.setProjectUserIds(null);
    savedProjects.setResponsibleUserId(null);

    assertThat(savedProjects, is(equalTo(expectedProjects)));
  }

  private ImmutableList<Project> getExpectedProjects() {
    return ImmutableList.of(
        Project.builder()
            .id(3L)
            .startDate(LocalDateTime.of(2020, 3, 22, 15, 6, 40))
            .endDate(LocalDateTime.of(2020, 3, 22, 15, 6, 19))
            .createdDate(LocalDateTime.of(2020, 3, 22, 15, 6, 5))
            .updatedDate(LocalDateTime.of(2020, 3, 22, 15, 6, 15))
            .deletedDate(LocalDateTime.of(2020, 3, 22, 15, 6, 7))
            .name("Project")
            .concluded(true)
            .late(false)
            .excluded(true)
            .activityProjectId(null)
            .projectUserIds(null)
            .responsibleUserId(null)
            .deleted(false)
            .build());
  }

  private Project createObjectToSave(Long id) {
    return Project.builder()
        .id(id)
        .createdDate(LocalDateTime.MIN)
        .updatedDate(LocalDateTime.of(2020, 12, 19, 12, 00))
        .deletedDate(null)
        .concluded(false)
        .startDate(LocalDateTime.of(2020, 12, 19, 12, 00))
        .endDate(LocalDateTime.of(2020, 12, 20, 12, 00))
        .name("Activity Name")
        .build();
  }
}
