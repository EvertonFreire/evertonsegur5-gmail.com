package br.com.project.domain.repository;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import br.com.project.domain.entity.User;
import com.google.common.collect.ImmutableList;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class UserRepositoryTest {

  @Autowired private UserRepository repository;

  @Test
  void save() {
    final var userName = createObjectToSave(null);
    final var expected = createObjectToSave(4L);

    final User save = repository.save(userName);

    assertThat(save, is(equalTo(expected)));
  }

  @Test
  void findAll() {
    final var expectedUsers = getExpectedUsers().get(0);

    var savedUsers = repository.findAll().iterator().next();
    savedUsers.setActivities(null);
    savedUsers.setProjects(null);

    assertThat(savedUsers, is(equalTo(expectedUsers)));
  }

  private ImmutableList<User> getExpectedUsers() {
    return ImmutableList.of(
        User.builder()
            .id(3L)
            .createdDate(LocalDateTime.of(2020, 3, 22, 15, 6, 5))
            .updatedDate(LocalDateTime.of(2020, 3, 22, 15, 6, 15))
            .deletedDate(LocalDateTime.of(2020, 3, 22, 15, 6, 7))
            .name("name")
            .lastName("User")
            .activities(null)
            .projects(null)
            .deleted(false)
            .build());
  }

  private User createObjectToSave(Long id) {
    return User.builder()
        .id(id)
        .createdDate(LocalDateTime.MIN)
        .updatedDate(LocalDateTime.of(2020, 12, 19, 12, 0))
        .deletedDate(null)
        .name("User Name")
        .lastName("last")
        .build();
  }
}
