package br.com.project.domain.service;

import static java.util.Optional.ofNullable;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import br.com.project.domain.dto.UserDTO;
import br.com.project.domain.entity.Activity;
import br.com.project.domain.entity.ProjectUserId;
import br.com.project.domain.entity.User;
import br.com.project.domain.mapper.UserMapper;
import br.com.project.domain.repository.UserRepository;
import com.google.common.collect.ImmutableList;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.MethodMode;

@SpringBootTest(classes = UserService.class)
@ExtendWith(MockitoExtension.class)
class UserServiceTest {

  @MockBean UserRepository repository;

  @InjectMocks UserService service;

  @MockBean UserMapper mapper;

  @Test
  void shouldReturnUserDTO() {
    final var id = 2L;
    final var expectedUser = buildUser(id);
    final var expectedUserDTO = buildUserDTO(id);

    when(repository.findById(2L)).thenReturn(ofNullable(expectedUser));
    when(mapper.map(expectedUser)).thenReturn(expectedUserDTO);
    final var savedUser = service.findById(id);

    verify(repository).findById(id);
    assertThat(savedUser, is(equalTo(expectedUserDTO)));
  }

  @Test
  @DirtiesContext(methodMode = MethodMode.AFTER_METHOD)
  void shouldReturnAllUsersList() {
    final var expectedUsers =
        ImmutableList.of(buildUser(1L), buildUser(2L), buildUser(3L), buildUser(4L));
    final var expectedUsersDTO =
        ImmutableList.of(buildUserDTO(1L), buildUserDTO(2L), buildUserDTO(3L), buildUserDTO(4L));

    when(repository.findAll()).thenReturn(expectedUsers);
    when(mapper.map(expectedUsers.get(0))).thenReturn(expectedUsersDTO.get(0));
    when(mapper.map(expectedUsers.get(1))).thenReturn(expectedUsersDTO.get(1));
    when(mapper.map(expectedUsers.get(2))).thenReturn(expectedUsersDTO.get(2));
    when(mapper.map(expectedUsers.get(3))).thenReturn(expectedUsersDTO.get(3));
    final var savedActivities = service.findAll();

    verify(repository).findAll();
    assertThat(savedActivities, is(equalTo(expectedUsersDTO)));
  }

  @Test
  @DirtiesContext(methodMode = MethodMode.AFTER_METHOD)
  void shouldReturnSavedUserDTO() {
    final var expectedUser = buildUser(100L);
    final var expectedUserDTO = buildUserDTO(100L);

    when(repository.save(expectedUser)).thenReturn(expectedUser);
    when(mapper.map(expectedUser)).thenReturn(expectedUserDTO);
    when(mapper.map(expectedUserDTO)).thenReturn(expectedUser);
    final var savedUser = service.save(expectedUserDTO);

    verify(repository).save(expectedUser);
    assertThat(savedUser, is(equalTo(expectedUserDTO)));
  }

  @Test
  @DirtiesContext(methodMode = MethodMode.AFTER_METHOD)
  void shouldReturnUpdatedUserDTO() {
    final var id = 2L;
    final var differentName = "DifferentName";
    final var activity = buildUser(id);
    var modifiedUserDTO = buildUserDTO(id);
    modifiedUserDTO.setName(differentName);
    var modifiedUser = buildUser(id);
    modifiedUser.setName(differentName);

    when(repository.findById(id)).thenReturn(ofNullable(activity));
    when(repository.save(modifiedUser)).thenReturn(modifiedUser);
    when(mapper.map(modifiedUser)).thenReturn(modifiedUserDTO);
    when(mapper.map(modifiedUserDTO)).thenReturn(modifiedUser);
    final var updatedUser = service.update(id, modifiedUserDTO);

    verify(repository).save(modifiedUser);
    assertThat(updatedUser, is(equalTo(modifiedUserDTO)));
  }

  @Test
  @DirtiesContext(methodMode = MethodMode.AFTER_METHOD)
  void shouldCallDeleteMethod() {

    final var id = 2L;

    when(repository.findById(id)).thenReturn(ofNullable(buildUser(id)));
    when(repository.save(buildUser(id))).thenReturn(buildUser(id));
    service.delete(id);

    verify(repository).findById(id);
    verify(repository).save(any());
  }

  private UserDTO buildUserDTO(Long id) {
    return UserDTO.builder()
        .id(id)
        .name("Nome")
        .lastName("SobreNome")
        .projectIds(ImmutableList.of(1L, 2L))
        .activityIds(ImmutableList.of(1L, 2L))
        .build();
  }

  private User buildUser(Long id) {
    return User.builder()
        .id(id)
        .name("Nome")
        .lastName("SobreNome")
        .projects(
            ImmutableList.of(
                ProjectUserId.builder().id(1L).build(), ProjectUserId.builder().id(2L).build()))
        .activities(
            ImmutableList.of(Activity.builder().id(1L).build(), Activity.builder().id(2L).build()))
        .createdDate(LocalDateTime.MIN)
        .updatedDate(LocalDateTime.MIN)
        .deletedDate(LocalDateTime.MAX)
        .deleted(false)
        .build();
  }
}
