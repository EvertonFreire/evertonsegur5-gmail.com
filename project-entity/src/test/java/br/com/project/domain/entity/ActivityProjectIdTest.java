package br.com.project.domain.entity;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.ReflectionUtils;

class ActivityProjectIdTest {

  @Test
  void hasMethodGetId() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            ActivityProjectId.class, method -> method.getName().equals("getId")));
  }

  @Test
  void hasMethodGetActivityId() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            ActivityProjectId.class, method -> method.getName().equals("getActivityId")));
  }

  @Test
  void hasMethodGetProjectId() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            ActivityProjectId.class, method -> method.getName().equals("getProjectId")));
  }

  @Test
  void hasMethodSetId() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            ActivityProjectId.class, method -> method.getName().equals("setId")));
  }

  @Test
  void hasMethodSetActivityId() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            ActivityProjectId.class, method -> method.getName().equals("setActivityId")));
  }

  @Test
  void hasMethodSetProjectId() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            ActivityProjectId.class, method -> method.getName().equals("setProjectId")));
  }

  @Test
  void hasMethodEquals() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            ActivityProjectId.class, method -> method.getName().equals("equals")));
  }

  @Test
  void hasMethodHashCode() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            ActivityProjectId.class, method -> method.getName().equals("hashCode")));
  }

  @Test
  void hasMethodToString() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            ActivityProjectId.class, method -> method.getName().equals("toString")));
  }
}
