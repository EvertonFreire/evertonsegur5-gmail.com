package br.com.project.domain.dto;

import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class ProjectDTO extends BaseDTO {

  private Long id;

  private String name;

  private LocalDateTime startDate;

  private LocalDateTime endDate;

  private Boolean late;

  private Boolean concluded;

  private Boolean excluded;

  private UserDTO responsibleUserId;

  private List<Long> projectUserIds;

  private List<Long> activityProjectIds;
}
