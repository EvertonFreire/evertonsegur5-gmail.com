package br.com.project.domain.service;

import static java.util.Optional.ofNullable;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import br.com.project.domain.dto.ProjectDTO;
import br.com.project.domain.entity.ActivityProjectId;
import br.com.project.domain.entity.Project;
import br.com.project.domain.entity.ProjectUserId;
import br.com.project.domain.mapper.ProjectMapper;
import br.com.project.domain.repository.ProjectRepository;
import com.google.common.collect.ImmutableList;
import java.time.LocalDateTime;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.MethodMode;

@SpringBootTest(classes = ProjectService.class)
@ExtendWith(MockitoExtension.class)
class ProjectServiceTest {

  @MockBean ProjectRepository repository;

  @InjectMocks ProjectService service;

  @MockBean ProjectMapper mapper;

  @Test
  @DirtiesContext(methodMode = MethodMode.AFTER_METHOD)
  void shouldReturnProjectDTO() {
    final var id = 2L;
    final var expectedProject = buildProject(id);
    final var expectedProjectDTO = buildProjectDTO(id);

    when(repository.findById(2L)).thenReturn(ofNullable(expectedProject));
    when(mapper.map(expectedProject)).thenReturn(expectedProjectDTO);
    final var savedProject = service.findById(id);

    verify(repository).findById(id);
    assertThat(savedProject, is(equalTo(expectedProjectDTO)));
  }

  @Test
  @DirtiesContext(methodMode = MethodMode.AFTER_METHOD)
  void shouldReturnAllProjectsDTO() {
    final var expectedProjects =
        ImmutableList.of(buildProject(1L), buildProject(2L), buildProject(3L), buildProject(4L));

    final var expectedProjectsDTO =
        ImmutableList.of(
            buildProjectDTO(1L), buildProjectDTO(2L), buildProjectDTO(3L), buildProjectDTO(4L));

    when(repository.findAll()).thenReturn(expectedProjects);
    when(mapper.map(expectedProjects.get(0))).thenReturn(expectedProjectsDTO.get(0));
    when(mapper.map(expectedProjects.get(1))).thenReturn(expectedProjectsDTO.get(1));
    when(mapper.map(expectedProjects.get(2))).thenReturn(expectedProjectsDTO.get(2));
    when(mapper.map(expectedProjects.get(3))).thenReturn(expectedProjectsDTO.get(3));
    final var savedActivities = service.findAll();

    verify(repository).findAll();
    assertThat(savedActivities, is(equalTo(expectedProjectsDTO)));
  }

  @Test
  @DirtiesContext(methodMode = MethodMode.AFTER_METHOD)
  void shouldReturnSavedDTO() {
    final var expectedProject = buildProject(100L);
    final var expectedProjectDTO = buildProjectDTO(100L);

    when(repository.save(expectedProject)).thenReturn(expectedProject);
    when(mapper.map(expectedProjectDTO)).thenReturn(expectedProject);
    when(mapper.map(expectedProject)).thenReturn(expectedProjectDTO);
    final var savedProject = service.save(expectedProjectDTO);

    verify(repository).save(expectedProject);
    assertThat(savedProject, is(equalTo(expectedProjectDTO)));
  }

  @Test
  @DirtiesContext(methodMode = MethodMode.AFTER_METHOD)
  void shouldReturnUpdatedProjectDTO() {

    final var id = 2L;
    final var differentName = "DifferentName";
    final var modifiedProjectDTO = buildProjectDTO(id);
    modifiedProjectDTO.setName(differentName);
    var modifiedProject = buildProject(id);
    modifiedProject.setName(differentName);

    when(repository.save(modifiedProject)).thenReturn(modifiedProject);
    when(mapper.map(modifiedProject)).thenReturn(modifiedProjectDTO);
    when(mapper.map(modifiedProjectDTO)).thenReturn(modifiedProject);
    final var updatedProject = service.update(id, modifiedProjectDTO);

    verify(repository).save(modifiedProject);
    assertThat(updatedProject, is(equalTo(modifiedProjectDTO)));
  }

  @Test
  @DirtiesContext(methodMode = MethodMode.AFTER_METHOD)
  void shouldCallDeletedMethod() {

    final var id = 2L;

    when(repository.findById(id)).thenReturn(ofNullable(buildProject(id)));
    when(repository.save(buildProject(id))).thenReturn(buildProject(id));
    service.delete(id);

    verify(repository).findById(id);
    verify(repository).save(any());
  }

  private ProjectDTO buildProjectDTO(Long id) {
    return ProjectDTO.builder()
        .id(id)
        .name("Nome")
        .excluded(false)
        .late(true)
        .responsibleUserId(null)
        .projectUserIds(Arrays.asList(2122L, 212221L))
        .activityProjectIds(Arrays.asList(154L, 287L))
        .endDate(LocalDateTime.MAX)
        .concluded(false)
        .build();
  }

  private Project buildProject(Long id) {
    return Project.builder()
        .id(id)
        .name("Nome")
        .excluded(false)
        .late(true)
        .responsibleUserId(null)
        .projectUserIds(
            Arrays.asList(
                ProjectUserId.builder().id(2122L).build(),
                ProjectUserId.builder().id(212221L).build()))
        .activityProjectId(
            Arrays.asList(
                ActivityProjectId.builder().id(154L).build(),
                ActivityProjectId.builder().id(287L).build()))
        .createdDate(LocalDateTime.MIN)
        .updatedDate(LocalDateTime.MIN)
        .deletedDate(LocalDateTime.MAX)
        .startDate(LocalDateTime.MIN)
        .endDate(LocalDateTime.MAX)
        .concluded(false)
        .deleted(false)
        .build();
  }
}
