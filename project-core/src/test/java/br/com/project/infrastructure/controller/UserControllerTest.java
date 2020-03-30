package br.com.project.infrastructure.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import br.com.project.domain.dto.UserDTO;
import br.com.project.domain.service.UserService;
import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@SpringBootTest(classes = UserController.class)
class UserControllerTest {

  @Autowired MockMvc mockMvc;
  @Autowired private UserController controller;
  @MockBean private UserService service;

  @Test
  void verifyCallFindById() {
    final var id = 2L;

    when(service.findById(id)).thenReturn(getUser(id));
    controller.findById(id);

    verify(service).findById(id);
  }

  @Test
  void verifyCallFindAll() {
    when(service.findAll()).thenReturn(ImmutableList.of(getUser(1L), getUser(2L), getUser(3L)));
    controller.findAll();

    verify(service).findAll();
  }

  @Test
  void verifyCallSave() {
    final var build = UserDTO.builder().build();

    when(service.save(build)).thenReturn(build);
    controller.save(build);

    verify(service).save(build);
  }

  @Test
  void verifyCallUpdate() {
    final var id = 19L;
    final var build = UserDTO.builder().build();

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

  private UserDTO getUser(Long id) {
    return UserDTO.builder().id(id).build();
  }
}
