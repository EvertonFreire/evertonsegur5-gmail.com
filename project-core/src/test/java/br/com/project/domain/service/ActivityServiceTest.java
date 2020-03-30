package br.com.project.domain.service;

import static java.util.Optional.ofNullable;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import br.com.project.domain.dto.ActivityDTO;
import br.com.project.domain.entity.Activity;
import br.com.project.domain.entity.ActivityProjectId;
import br.com.project.domain.mapper.ActivityMapper;
import br.com.project.domain.repository.ActivityRepository;
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

@SpringBootTest(classes = ActivityService.class)
@ExtendWith(MockitoExtension.class)
class ActivityServiceTest {

  @MockBean ActivityRepository repository;

  @InjectMocks ActivityService service;

  @MockBean ActivityMapper mapper;

  @Test
  @DirtiesContext(methodMode = MethodMode.AFTER_METHOD)
  void shouldReturnActivityDTO() {
    final var id = 2L;
    final var expectedActivity = buildActivity(id);
    final var expectedActivityDTO = buildActivityDTO(id);

    when(repository.findById(2L)).thenReturn(ofNullable(expectedActivity));
    when(mapper.map(expectedActivity)).thenReturn(expectedActivityDTO);
    final var savedActivity = service.findById(id);

    verify(repository).findById(id);
    assertThat(savedActivity, is(equalTo(expectedActivityDTO)));
  }

  @Test
  @DirtiesContext(methodMode = MethodMode.AFTER_METHOD)
  void shouldReturnAllActivitiesDTO() {
    final var expectedActivities =
        ImmutableList.of(
            buildActivity(40L), buildActivity(41L), buildActivity(42L), buildActivity(43L));
    final var expectedActivitiesDTO =
        ImmutableList.of(
            buildActivityDTO(40L),
            buildActivityDTO(41L),
            buildActivityDTO(42L),
            buildActivityDTO(43L));

    when(repository.findAll()).thenReturn(expectedActivities);
    when(mapper.map(expectedActivities.get(0))).thenReturn(expectedActivitiesDTO.get(0));
    when(mapper.map(expectedActivities.get(1))).thenReturn(expectedActivitiesDTO.get(1));
    when(mapper.map(expectedActivities.get(2))).thenReturn(expectedActivitiesDTO.get(2));
    when(mapper.map(expectedActivities.get(3))).thenReturn(expectedActivitiesDTO.get(3));

    final var savedActivities = service.findAll();
    verify(repository).findAll();
    assertThat(savedActivities, is(equalTo(expectedActivitiesDTO)));
  }

  @Test
  @DirtiesContext(methodMode = MethodMode.AFTER_METHOD)
  void shouldReturnSavedActivityDTO() {
    final var expectedActivity = buildActivity(100L);
    final var expectedActivityDTO = buildActivityDTO(100L);

    when(repository.save(expectedActivity)).thenReturn(expectedActivity);
    when(mapper.map(expectedActivity)).thenReturn(expectedActivityDTO);
    when(mapper.map(expectedActivityDTO)).thenReturn(expectedActivity);
    final var savedActivity = service.save(expectedActivityDTO);

    verify(repository).save(expectedActivity);
    assertThat(savedActivity, is(equalTo(expectedActivityDTO)));
  }

  @Test
  @DirtiesContext(methodMode = MethodMode.AFTER_METHOD)
  void shouldReturnUpdatedActivityDTO() {

    final var id = 70L;
    final var differentName = "DifferentName";
    var modifiedActivityDTO = buildActivityDTO(id);
    modifiedActivityDTO.setName(differentName);
    var modifiedActivity = buildActivity(id);
    modifiedActivity.setName(differentName);
    final var expectedActivity = buildActivity(id);
    final var expectedActivityDTO = buildActivityDTO(id);

    when(repository.save(expectedActivity)).thenReturn(expectedActivity);
    when(mapper.map(modifiedActivityDTO)).thenReturn(expectedActivity);
    when(mapper.map(expectedActivity)).thenReturn(expectedActivityDTO);
    final var updatedActivity = service.update(id, modifiedActivityDTO);

    verify(repository).findById(id);
    verify(repository).save(expectedActivity);
    assertThat(updatedActivity, is(equalTo(expectedActivityDTO)));
  }

  @Test
  @DirtiesContext(methodMode = MethodMode.AFTER_METHOD)
  void shouldCallSaveMethod() {

    final var id = 278L;

    when(repository.findById(id)).thenReturn(ofNullable(buildActivity(id)));
    when(repository.save(buildActivity(id))).thenReturn(buildActivity(id));
    service.delete(id);

    verify(repository).findById(id);
    verify(repository).save(buildActivity(id));
  }

  private ActivityDTO buildActivityDTO(Long id) {
    return ActivityDTO.builder()
        .id(id)
        .name("Nome")
        .user(null)
        .projectIds(Arrays.asList(465L, 124L))
        .startDate(LocalDateTime.MIN)
        .endDate(LocalDateTime.MAX)
        .concluded(false)
        .build();
  }

  private Activity buildActivity(Long id) {
    return Activity.builder()
        .id(id)
        .name("Nome")
        .user(null)
        .activityProjectId(
            Arrays.asList(
                ActivityProjectId.builder().id(465L).build(),
                ActivityProjectId.builder().id(124L).build()))
        .createdDate(LocalDateTime.MIN)
        .updatedDate(LocalDateTime.MIN)
        .deletedDate(LocalDateTime.MAX)
        .startDate(LocalDateTime.MIN)
        .endDate(LocalDateTime.MAX)
        .concluded(false)
        .deleted(true)
        .build();
  }
}
