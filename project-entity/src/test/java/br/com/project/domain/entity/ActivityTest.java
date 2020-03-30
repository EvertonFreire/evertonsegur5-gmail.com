package br.com.project.domain.entity;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.ReflectionUtils;

class ActivityTest {

  @Test
  void hasMethodGetId() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            Activity.class, method -> method.getName().equals("getId")));
  }

  @Test
  void hasMethodGetName() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            Activity.class, method -> method.getName().equals("getName")));
  }

  @Test
  void hasMethodGetStartDate() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            Activity.class, method -> method.getName().equals("getStartDate")));
  }

  @Test
  void hasMethodGetEndDate() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            Activity.class, method -> method.getName().equals("getEndDate")));
  }

  @Test
  void hasMethodGetConcluded() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            Activity.class, method -> method.getName().equals("getConcluded")));
  }

  @Test
  void hasMethodGetActivityProjectId() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            Activity.class, method -> method.getName().equals("getActivityProjectId")));
  }

  @Test
  void hasMethodGetActivityUserId() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            Activity.class, method -> method.getName().equals("getUser")));
  }

  @Test
  void hasMethodSetId() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            Activity.class, method -> method.getName().equals("setId")));
  }

  @Test
  void hasMethodSetName() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            Activity.class, method -> method.getName().equals("setName")));
  }

  @Test
  void hasMethodSetStartDate() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            Activity.class, method -> method.getName().equals("setStartDate")));
  }

  @Test
  void hasMethodSetEndDate() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            Activity.class, method -> method.getName().equals("setEndDate")));
  }

  @Test
  void hasMethodSetConcluded() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            Activity.class, method -> method.getName().equals("setConcluded")));
  }

  @Test
  void hasMethodSetActivityProjectId() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            Activity.class, method -> method.getName().equals("setActivityProjectId")));
  }

  @Test
  void hasMethodSetActivityUserId() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            Activity.class, method -> method.getName().equals("setUser")));
  }

  @Test
  void hasMethodHashCode() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            Activity.class, method -> method.getName().equals("hashCode")));
  }

  @Test
  void hasMethodEquals() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            Activity.class, method -> method.getName().equals("equals")));
  }

  @Test
  void hasMethodToString() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            Activity.class, method -> method.getName().equals("toString")));
  }

  @Test
  void isHeritageFromBaseEntity() {
    assertTrue(ReflectionUtils.isAssignableTo(Activity.builder().build(), BaseEntity.class));
  }
}
