package br.com.project.domain.mapper;

import br.com.project.domain.dto.ActivityDTO;
import br.com.project.domain.entity.Activity;
import br.com.project.domain.entity.ActivityProjectId;
import br.com.project.domain.entity.Project;
import java.util.List;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class ActivityMapper {

  @Mappings({
    @Mapping(source = "id", target = "id"),
    @Mapping(source = "name", target = "name"),
    @Mapping(source = "user", target = "user"),
    @Mapping(source = "startDate", target = "startDate"),
    @Mapping(source = "endDate", target = "endDate"),
    @Mapping(source = "concluded", target = "concluded"),
    @Mapping(expression = "java(getProjectIds(dto.getActivityProjectId()))", target = "projectIds"),
  })
  public abstract ActivityDTO map(Activity dto);

  @Mappings({
    @Mapping(source = "id", target = "id"),
    @Mapping(source = "name", target = "name"),
    @Mapping(source = "user", target = "user"),
    @Mapping(source = "startDate", target = "startDate"),
    @Mapping(source = "endDate", target = "endDate"),
    @Mapping(source = "concluded", target = "concluded"),
    @Mapping(
        expression = "java(getActivityProjects(dto.getProjectIds()))",
        target = "activityProjectId"),
  })
  public abstract Activity map(ActivityDTO dto);

  protected List<ActivityProjectId> getActivityProjects(List<Long> values) {
    return values.stream()
        .map(id -> ActivityProjectId.builder().projectId(Project.builder().id(id).build()).build())
        .collect(Collectors.toList());
  }

  protected List<Long> getProjectIds(List<ActivityProjectId> values) {
    return values
        .parallelStream()
        .map(ActivityProjectId::getProjectId)
        .map(Project::getId)
        .collect(Collectors.toList());
  }
}
