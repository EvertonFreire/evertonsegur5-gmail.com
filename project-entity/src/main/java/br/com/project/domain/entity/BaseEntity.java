package br.com.project.domain.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@MappedSuperclass
@Data
@ToString
@EqualsAndHashCode
public class BaseEntity implements Serializable {
  @CreatedDate private LocalDateTime createdDate;

  @LastModifiedDate private LocalDateTime updatedDate;
  private LocalDateTime deletedDate;
  private Boolean deleted;
}
