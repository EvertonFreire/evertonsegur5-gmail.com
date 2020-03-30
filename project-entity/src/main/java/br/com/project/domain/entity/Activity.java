package br.com.project.domain.entity;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = false)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
@ToString
public class Activity extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
  private Boolean concluded;

  @OneToMany(mappedBy = "activityId", fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
  private List<ActivityProjectId> activityProjectId;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
  private User user;
}
