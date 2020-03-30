package br.com.project.infrastructure.controller;

import br.com.project.domain.dto.UserDTO;
import br.com.project.domain.service.UserService;
import br.com.project.infrastructure.controller.interfaces.UserControllerInterface;
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
@RequestMapping("/user/")
public class UserController implements UserControllerInterface {

  private UserService service;

  @Override
  @GetMapping("{id}")
  public UserDTO findById(@PathVariable Long id) {
    return service.findById(id);
  }

  @Override
  @GetMapping
  public List<UserDTO> findAll() {
    return service.findAll();
  }

  @Override
  @PostMapping("")
  public UserDTO save(@RequestBody UserDTO user) {
    return service.save(user);
  }

  @Override
  @PutMapping("{id}")
  public UserDTO update(@PathVariable Long id, @RequestBody UserDTO user) {
    return service.update(id, user);
  }

  @Override
  @DeleteMapping("{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Long id) {
    service.delete(id);
  }
}
