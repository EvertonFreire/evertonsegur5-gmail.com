package br.com.project.domain.entity;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "projects")
@SuperBuilder
public class Project extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private LocalDateTime startDate;

  private LocalDateTime endDate;

  private Boolean late;

  private Boolean concluded;

  private Boolean excluded;

  @OneToOne private User responsibleUserId;

  @OneToMany(mappedBy = "projectId")
  private List<ProjectUserId> projectUserIds;

  @OneToMany(mappedBy = "projectId")
  private List<ActivityProjectId> activityProjectId;
}
