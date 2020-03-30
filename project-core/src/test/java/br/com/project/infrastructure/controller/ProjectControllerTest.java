package br.com.project.infrastructure.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import br.com.project.domain.dto.ProjectDTO;
import br.com.project.domain.service.ProjectService;
import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@SpringBootTest(classes = ProjectController.class)
class ProjectControllerTest {

  @Autowired MockMvc mockMvc;
  @Autowired private ProjectController controller;
  @MockBean private ProjectService service;

  @Test
  void verifyCallFindById() {
    final var id = 2L;

    when(service.findById(id)).thenReturn(getProject(id));
    controller.findById(id);

    verify(service).findById(id);
  }

  @Test
  void verifyCallFindAll() {
    when(service.findAll())
        .thenReturn(ImmutableList.of(getProject(1L), getProject(2L), getProject(3L)));
    controller.findAll();

    verify(service).findAll();
  }

  @Test
  void verifyCallSave() {
    final var build = ProjectDTO.builder().build();

    when(service.save(build)).thenReturn(build);
    controller.save(build);

    verify(service).save(build);
  }

  @Test
  void verifyCallUpdate() {
    final var id = 19L;
    final var build = ProjectDTO.builder().build();

    when(service.update(id, build)).thenReturn(build);
    controller.update(id, build);

    verify(service).update(id, build);
  }

  @Test
  void verifyCallDelete() {
    final var id = 19L;

    doNothing().when(service).delete(id);
    controller.delete(id);

    verify(service).delete(id);
  }

  private ProjectDTO getProject(Long id) {
    return ProjectDTO.builder().id(id).build();
  }
}
