package br.com.project.domain.entity;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.ReflectionUtils;

class BaseEntityTest {

  @Test
  void hasMethodGetCreatedDate() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            BaseEntity.class, method -> method.getName().equals("getCreatedDate")));
  }

  @Test
  void hasMethodSetCreatedDate() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            BaseEntity.class, method -> method.getName().equals("setCreatedDate")));
  }

  @Test
  void hasMethodGetUpdatedDate() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            BaseEntity.class, method -> method.getName().equals("getUpdatedDate")));
  }

  @Test
  void hasMethodSetUpdatedDate() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            BaseEntity.class, method -> method.getName().equals("setUpdatedDate")));
  }

  @Test
  void hasMethodGetDeletedDate() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            BaseEntity.class, method -> method.getName().equals("getDeletedDate")));
  }

  @Test
  void hasMethodSetDeletedDate() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            BaseEntity.class, method -> method.getName().equals("setDeletedDate")));
  }

  @Test
  void hasMethodEquals() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            BaseEntity.class, method -> method.getName().equals("equals")));
  }

  @Test
  void hasMethodHashCode() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            BaseEntity.class, method -> method.getName().equals("hashCode")));
  }

  @Test
  void hasMethodToString() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            BaseEntity.class, method -> method.getName().equals("toString")));
  }
}
