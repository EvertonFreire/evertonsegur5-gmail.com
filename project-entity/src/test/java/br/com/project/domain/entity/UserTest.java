package br.com.project.domain.entity;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.ReflectionUtils;

class UserTest {

  @Test
  void hasMethodHashCode() {
    assertTrue(
        ReflectionUtils.isMethodPresent(User.class, method -> method.getName().equals("hashCode")));
  }

  @Test
  void hasMethodEquals() {
    assertTrue(
        ReflectionUtils.isMethodPresent(User.class, method -> method.getName().equals("equals")));
  }

  @Test
  void hasMethodToString() {
    assertTrue(
        ReflectionUtils.isMethodPresent(User.class, method -> method.getName().equals("toString")));
  }

  @Test
  void isHeritageFromBaseEntity() {
    assertTrue(ReflectionUtils.isAssignableTo(User.builder().build(), BaseEntity.class));
  }

  @Test
  void hasMethodGetId() {
    assertTrue(
        ReflectionUtils.isMethodPresent(User.class, method -> method.getName().equals("getId")));
  }

  @Test
  void hasMethodGetName() {
    assertTrue(
        ReflectionUtils.isMethodPresent(User.class, method -> method.getName().equals("getName")));
  }

  @Test
  void hasMethodGetLastName() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            User.class, method -> method.getName().equals("getLastName")));
  }

  @Test
  void hasMethodGetProjects() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            User.class, method -> method.getName().equals("getProjects")));
  }

  @Test
  void hasMethodGetActivities() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            User.class, method -> method.getName().equals("getActivities")));
  }

  @Test
  void hasMethodSetId() {
    assertTrue(
        ReflectionUtils.isMethodPresent(User.class, method -> method.getName().equals("setId")));
  }

  @Test
  void hasMethodSetName() {
    assertTrue(
        ReflectionUtils.isMethodPresent(User.class, method -> method.getName().equals("setName")));
  }

  @Test
  void hasMethodSetLastName() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            User.class, method -> method.getName().equals("setLastName")));
  }

  @Test
  void hasMethodSetProjects() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            User.class, method -> method.getName().equals("setProjects")));
  }

  @Test
  void hasMethodSetActivities() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            User.class, method -> method.getName().equals("setActivities")));
  }
}
