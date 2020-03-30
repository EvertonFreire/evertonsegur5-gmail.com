package br.com.project.domain.repository;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import br.com.project.domain.entity.Activity;
import com.google.common.collect.ImmutableList;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class ActivityRepositoryTest {

  @Autowired private ActivityRepository repository;

  @Test
  void save() {
    final var activityName = createObjectToSave(null);
    final var expected = createObjectToSave(4L);

    final Activity save = repository.save(activityName);

    assertThat(save, is(equalTo(expected)));
  }

  @Test
  void findAll() {
    final var expectedActivities = getExpectedActivities().get(0);

    var savedActivities = repository.findAll().iterator().next();
    savedActivities.setActivityProjectId(null);
    savedActivities.setUser(null);

    assertThat(savedActivities, is(equalTo(expectedActivities)));
  }

  private ImmutableList<Activity> getExpectedActivities() {
    return ImmutableList.of(
        Activity.builder()
            .id(3L)
            .startDate(LocalDateTime.of(2020, 12, 19, 12, 1, 0))
            .endDate(LocalDateTime.of(2020, 12, 19, 12, 59, 0))
            .createdDate(LocalDateTime.of(2020, 12, 19, 12, 0, 0))
            .updatedDate(LocalDateTime.of(2020, 12, 19, 12, 30, 0))
            .deletedDate(LocalDateTime.of(2020, 12, 19, 13, 0, 0))
            .name("Atividade")
            .concluded(true)
            .activityProjectId(null)
            .user(null)
            .deleted(false)
            .build());
  }

  private Activity createObjectToSave(Long id) {
    return Activity.builder()
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
