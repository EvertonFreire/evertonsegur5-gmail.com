package br.com.project.domain.service;

import br.com.project.domain.dto.ProjectDTO;
import br.com.project.domain.mapper.ProjectMapper;
import br.com.project.domain.repository.ProjectRepository;
import br.com.project.domain.service.interfaces.ProjectServiceInterface;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProjectService implements ProjectServiceInterface {

  private ProjectRepository repository;
  private ProjectMapper mapper;

  @Override
  public ProjectDTO findById(Long id) {
    return mapper.map(repository.findById(id).orElse(null));
  }

  @Override
  public List<ProjectDTO> findAll() {
    return repository.findAll().parallelStream().map(mapper::map).collect(Collectors.toList());
  }

  @Override
  public ProjectDTO save(ProjectDTO object) {
    return mapper.map(repository.save(mapper.map(object)));
  }

  @Override
  public ProjectDTO update(Long id, ProjectDTO object) {
    return mapper.map(repository.save(mapper.map(object)));
  }

  @Override
  public void delete(Long id) {
    final var byId = repository.findById(id);
    byId.map(
            project -> {
              project.setDeleted(true);
              return project;
            })
        .map(repository::save)
        .ifPresent(project -> {});
  }
}
