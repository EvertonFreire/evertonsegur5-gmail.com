package br.com.project.infrastructure.controller;

import br.com.project.domain.dto.ActivityDTO;
import br.com.project.domain.service.ActivityService;
import br.com.project.infrastructure.controller.interfaces.ActivityControllerInterface;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/activity")
public class ActivityController implements ActivityControllerInterface {

  private ActivityService service;

  @Override
  @GetMapping(path = "/{id}")
  public ActivityDTO findById(@PathVariable Long id) {
    return service.findById(id);
  }

  @Override
  @GetMapping
  public List<ActivityDTO> findAll() {
    return service.findAll();
  }

  @Override
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ActivityDTO save(@RequestBody ActivityDTO object) {
    return service.save(object);
  }

  @Override
  @PutMapping(path = "/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ActivityDTO update(@PathVariable Long id, @RequestBody ActivityDTO object) {
    return service.update(id, object);
  }

  @Override
  @DeleteMapping(path = "/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Long id) {
    service.delete(id);
  }
}
