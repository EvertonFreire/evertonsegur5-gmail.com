package br.com.project.infrastructure.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import br.com.project.domain.dto.ActivityDTO;
import br.com.project.domain.service.ActivityService;
import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@SpringBootTest(classes = ActivityController.class)
class ActivityControllerTest {

  @Autowired MockMvc mockMvc;
  @Autowired ActivityController controller;
  @MockBean ActivityService service;

  @Test
  void verifyCallFindById() {
    final var id = 2L;

    when(service.findById(id)).thenReturn(getActivity(id));
    controller.findById(id);

    verify(service).findById(id);
  }

  @Test
  void verifyCallFindAll() {
    when(service.findAll())
        .thenReturn(ImmutableList.of(getActivity(1L), getActivity(2L), getActivity(3L)));
    controller.findAll();

    verify(service).findAll();
  }

  @Test
  void verifyCallSave() {
    final var build = ActivityDTO.builder().build();

    when(service.save(build)).thenReturn(build);
    controller.save(build);

    verify(service).save(build);
  }

  @Test
  void verifyCallUpdate() {
    final var id = 19L;
    final var build = ActivityDTO.builder().build();

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

  private ActivityDTO getActivity(Long id) {
    return ActivityDTO.builder().id(id).build();
  }
}
