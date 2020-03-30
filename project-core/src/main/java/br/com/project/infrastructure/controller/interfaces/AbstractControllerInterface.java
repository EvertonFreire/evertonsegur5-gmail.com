package br.com.project.infrastructure.controller.interfaces;

import br.com.project.domain.dto.BaseDTO;
import java.util.List;

public interface AbstractControllerInterface<T extends BaseDTO> {

  T findById(Long id);

  List<T> findAll();

  T save(T object);

  T update(Long id, T object);

  void delete(Long id);
}
