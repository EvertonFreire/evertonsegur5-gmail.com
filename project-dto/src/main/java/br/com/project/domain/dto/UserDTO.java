package br.com.project.domain.dto;

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
public class UserDTO extends BaseDTO {

  private String name;
  private String lastName;
  private List<Long> projectIds;
  private List<Long> activityIds;
}
