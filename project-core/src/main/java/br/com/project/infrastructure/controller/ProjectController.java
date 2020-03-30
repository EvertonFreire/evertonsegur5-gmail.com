package br.com.project.infrastructure.controller;

import br.com.project.domain.dto.ProjectDTO;
import br.com.project.domain.service.ProjectService;
import br.com.project.infrastructure.controller.interfaces.ProjectControllerInterface;
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
@RequestMapping(path = "/project/")
public class ProjectController implements ProjectControllerInterface {

  private ProjectService service;

  @Override
  @GetMapping(path = "{id}")
  @ResponseStatus(HttpStatus.OK)
  public ProjectDTO findById(@PathVariable Long id) {
    return service.findById(id);
  }

  @Override
  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<ProjectDTO> findAll() {
    return service.findAll();
  }

  // FIXME COLOCAR PRA DTO
  @Override
  @PostMapping
  @ResponseStatus(HttpStatus.OK)
  public ProjectDTO save(@RequestBody ProjectDTO object) {
    return service.save(object);
  }

  @Override
  @PutMapping(path = "{id}")
  @ResponseStatus(HttpStatus.OK)
  public ProjectDTO update(@PathVariable Long id, @RequestBody ProjectDTO object) {
    return service.update(id, object);
  }

  @Override
  @DeleteMapping(path = "{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Long id) {
    service.delete(id);
  }
}
