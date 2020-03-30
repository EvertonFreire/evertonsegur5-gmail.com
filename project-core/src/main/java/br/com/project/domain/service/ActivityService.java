package br.com.project.domain.service;

import br.com.project.domain.dto.ActivityDTO;
import br.com.project.domain.mapper.ActivityMapper;
import br.com.project.domain.repository.ActivityRepository;
import br.com.project.domain.service.interfaces.ActivityServiceInterface;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ActivityService implements ActivityServiceInterface {

  private ActivityRepository repository;
  private ActivityMapper mapper;

  @Override
  public ActivityDTO findById(Long id) {
    return mapper.map(repository.findById(id).orElse(null));
  }

  @Override
  public List<ActivityDTO> findAll() {
    return repository.findAll().parallelStream().map(mapper::map).collect(Collectors.toList());
  }

  @Override
  public ActivityDTO save(ActivityDTO object) {
    return mapper.map(repository.save(mapper.map(object)));
  }

  @Override
  public ActivityDTO update(Long id, ActivityDTO modifiedActivity) {

    repository.findById(id);

    return mapper.map(repository.save(mapper.map(modifiedActivity)));
  }

  @Override
  public void delete(Long id) {
    final var byId = repository.findById(id);
    byId.map(
            activity -> {
              activity.setDeleted(true);
              return activity;
            })
        .map(repository::save)
        .ifPresent(activity -> {});
  }
}
