package br.com.project.domain.entity;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.ReflectionUtils;

class ProjectTest {

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

  @Test
  void hasMethodGetId() {
    assertTrue(
        ReflectionUtils.isMethodPresent(Project.class, method -> method.getName().equals("getId")));
  }

  @Test
  void hasMethodGetName() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            Project.class, method -> method.getName().equals("getName")));
  }

  @Test
  void hasMethodGetStartDate() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            Project.class, method -> method.getName().equals("getStartDate")));
  }

  @Test
  void hasMethodGetEndDate() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            Project.class, method -> method.getName().equals("getEndDate")));
  }

  @Test
  void hasMethodGetLate() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            Project.class, method -> method.getName().equals("getLate")));
  }

  @Test
  void hasMethodGetConcluded() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            Project.class, method -> method.getName().equals("getConcluded")));
  }

  @Test
  void hasMethodGetExcluded() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            Project.class, method -> method.getName().equals("getExcluded")));
  }

  @Test
  void hasMethodGetResponsibleUserId() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            Project.class, method -> method.getName().equals("getResponsibleUserId")));
  }

  @Test
  void hasMethodGetProjectUserIds() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            Project.class, method -> method.getName().equals("getProjectUserIds")));
  }

  @Test
  void hasMethodGetActivityProjectId() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            Project.class, method -> method.getName().equals("getActivityProjectId")));
  }

  @Test
  void hasMethodSetId() {
    assertTrue(
        ReflectionUtils.isMethodPresent(Project.class, method -> method.getName().equals("setId")));
  }

  @Test
  void hasMethodSetName() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            Project.class, method -> method.getName().equals("setName")));
  }

  @Test
  void hasMethodSetStartDate() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            Project.class, method -> method.getName().equals("setStartDate")));
  }

  @Test
  void hasMethodSetEndDate() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            Project.class, method -> method.getName().equals("setEndDate")));
  }

  @Test
  void hasMethodSetLate() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            Project.class, method -> method.getName().equals("getLate")));
  }

  @Test
  void hasMethodSetConcluded() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            Project.class, method -> method.getName().equals("setConcluded")));
  }

  @Test
  void hasMethodSetExcluded() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            Project.class, method -> method.getName().equals("setExcluded")));
  }

  @Test
  void hasMethodSetResponsibleUserId() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            Project.class, method -> method.getName().equals("setResponsibleUserId")));
  }

  @Test
  void hasMethodSetProjectUserIds() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            Project.class, method -> method.getName().equals("setProjectUserIds")));
  }

  @Test
  void hasMethodSetActivityProjectId() {
    assertTrue(
        ReflectionUtils.isMethodPresent(
            Project.class, method -> method.getName().equals("getActivityProjectId")));
  }
}
