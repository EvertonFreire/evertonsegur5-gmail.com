package br.com.project.domain.service;

import br.com.project.domain.dto.UserDTO;
import br.com.project.domain.mapper.UserMapper;
import br.com.project.domain.repository.UserRepository;
import br.com.project.domain.service.interfaces.UserServiceInterface;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements UserServiceInterface {

  private UserRepository repository;
  private UserMapper mapper;

  @Override
  public UserDTO findById(Long id) {
    return mapper.map(repository.findById(id).orElse(null));
  }

  @Override
  public List<UserDTO> findAll() {
    return repository.findAll().parallelStream().map(mapper::map).collect(Collectors.toList());
  }

  @Override
  public UserDTO save(UserDTO object) {
    return mapper.map(repository.save(mapper.map(object)));
  }

  @Override
  public UserDTO update(Long id, UserDTO object) {
    return mapper.map(repository.save(mapper.map(object)));
  }

  @Override
  public void delete(Long id) {
    var persistedUser = repository.findById(id);
    persistedUser
        .map(
            user -> {
              user.setDeleted(true);
              return user;
            })
        .map(repository::save)
        .ifPresent(user -> {});
  }
}
