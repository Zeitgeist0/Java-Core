package oop.practice.family;

public enum Species {
  FISH("Fish"),
  DOMESTIC_CAT("Cat"),
  DOG("Dog"),
  ROBOT_CAT("Robot cat"),
  UNKNOWN("...");

  private final String name;

  Species(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
