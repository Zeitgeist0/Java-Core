package pet;

public enum Species {
  FISH("Fish"),
  DOMESTICCAT("Cat"),
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
