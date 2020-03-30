package br.com.project.domain.mapper;

import br.com.project.domain.dto.ProjectDTO;
import br.com.project.domain.entity.Activity;
import br.com.project.domain.entity.ActivityProjectId;
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
public abstract class ProjectMapper {

  @Mappings({
    @Mapping(source = "id", target = "id"),
    @Mapping(source = "name", target = "name"),
    @Mapping(source = "startDate", target = "startDate"),
    @Mapping(source = "endDate", target = "endDate"),
    @Mapping(source = "excluded", target = "excluded"),
    @Mapping(source = "concluded", target = "concluded"),
    @Mapping(source = "late", target = "late"),
    @Mapping(
        expression = "java(getActivityIds(dto.getActivityProjectId()))",
        target = "activityProjectIds"),
    @Mapping(expression = "java(getUserIds(dto.getProjectUserIds()))", target = "projectUserIds"),
    @Mapping(source = "responsibleUserId", target = "responsibleUserId")
  })
  public abstract ProjectDTO map(Project dto);

  @Mappings({
    @Mapping(source = "id", target = "id"),
    @Mapping(source = "name", target = "name"),
    @Mapping(source = "startDate", target = "startDate"),
    @Mapping(source = "endDate", target = "endDate"),
    @Mapping(source = "excluded", target = "excluded"),
    @Mapping(source = "concluded", target = "concluded"),
    @Mapping(source = "late", target = "late"),
    @Mapping(
        expression = "java(buildActivityProject(dto.getActivityProjectIds()))",
        target = "activityProjectId"),
    @Mapping(
        expression = "java(buildProjectUser(dto.getProjectUserIds()))",
        target = "projectUserIds"),
    @Mapping(source = "responsibleUserId", target = "responsibleUserId")
  })
  public abstract Project map(ProjectDTO dto);

  protected List<ProjectUserId> buildProjectUser(Collection<Long> values) {
    return values
        .parallelStream()
        .map(id -> ProjectUserId.builder().projectId(Project.builder().id(id).build()).build())
        .collect(Collectors.toList());
  }

  protected List<ActivityProjectId> buildActivityProject(Collection<Long> values) {
    return values
        .parallelStream()
        .map(
            id -> ActivityProjectId.builder().activityId(Activity.builder().id(id).build()).build())
        .collect(Collectors.toList());
  }

  protected List<Long> getActivityIds(Collection<ActivityProjectId> values) {
    return values
        .parallelStream()
        .map(ActivityProjectId::getActivityId)
        .map(Activity::getId)
        .collect(Collectors.toList());
  }

  protected List<Long> getUserIds(List<ProjectUserId> values) {
    return values
        .parallelStream()
        .map(ProjectUserId::getUserId)
        .map(User::getId)
        .collect(Collectors.toList());
  }
}
