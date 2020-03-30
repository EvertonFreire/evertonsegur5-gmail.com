package br.com.project.domain.entity;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.ReflectionUtils;

class ProjectUserIdTest {

  @Test
  void hasMethodGetId() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            ProjectUserId.class, method -> method.getName().equals("getId")));
  }

  @Test
  void hasMethodGetUserId() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            ProjectUserId.class, method -> method.getName().equals("getUserId")));
  }

  @Test
  void hasMethodGetProjectId() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            ProjectUserId.class, method -> method.getName().equals("getProjectId")));
  }

  @Test
  void hasMethodSetId() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            ProjectUserId.class, method -> method.getName().equals("setId")));
  }

  @Test
  void hasMethodSetUserId() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            ProjectUserId.class, method -> method.getName().equals("setUserId")));
  }

  @Test
  void hasMethodSetProjectId() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            ProjectUserId.class, method -> method.getName().equals("setProjectId")));
  }

  @Test
  void hasMethodEquals() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            ProjectUserId.class, method -> method.getName().equals("equals")));
  }

  @Test
  void hasMethodHashCode() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            ProjectUserId.class, method -> method.getName().equals("hashCode")));
  }

  @Test
  void hasMethodToString() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            ProjectUserId.class, method -> method.getName().equals("toString")));
  }
}
