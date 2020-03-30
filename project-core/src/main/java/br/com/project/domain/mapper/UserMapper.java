package br.com.project.domain.mapper;

import br.com.project.domain.dto.UserDTO;
import br.com.project.domain.entity.Activity;
import br.com.project.domain.entity.Project;
import br.com.project.domain.entity.ProjectUserId;
import br.com.project.domain.entity.User;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class UserMapper {

  @Mappings({
    @Mapping(source = "id", target = "id"),
    @Mapping(source = "name", target = "name"),
    @Mapping(source = "lastName", target = "lastName"),
    @Mapping(expression = "java(getProjectIds(dto.getProjects()))", target = "projectIds"),
    @Mapping(expression = "java(getActivityIds(dto.getActivities()))", target = "activityIds")
  })
  public abstract UserDTO map(User dto);

  @Mappings({
    @Mapping(source = "id", target = "id"),
    @Mapping(source = "name", target = "name"),
    @Mapping(source = "lastName", target = "lastName"),
    @Mapping(expression = "java(getProjectIdsFromDTO(dto.getProjectIds()))", target = "projects"),
    @Mapping(expression = "java(getActivitiesFromDTO(dto.getActivityIds()))", target = "activities")
  })
  public abstract User map(UserDTO dto);

  protected List<Activity> getActivitiesFromDTO(Collection<Long> values) {
    return values.parallelStream().map(this::buildActivities).collect(Collectors.toList());
  }

  protected List<ProjectUserId> getProjectIdsFromDTO(Collection<Long> values) {
    return values.parallelStream().map(this::buildProject).collect(Collectors.toList());
  }

  protected List<Long> getProjectIds(Collection<ProjectUserId> values) {
    return values
        .parallelStream()
        .map(ProjectUserId::getProjectId)
        .map(Project::getId)
        .collect(Collectors.toList());
  }

  protected List<Long> getActivityIds(Collection<Activity> values) {
    return values.parallelStream().map(Activity::getId).collect(Collectors.toList());
  }

  private ProjectUserId buildProject(Long id) {
    return ProjectUserId.builder().projectId(Project.builder().id(id).build()).build();
  }

  private Activity buildActivities(Long id) {
    return Activity.builder().id(id).build();
  }
}
