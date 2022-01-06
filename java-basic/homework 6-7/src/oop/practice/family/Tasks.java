package oop.practice.family;

public enum Tasks {
  GO_TO_CINEMA("Go to the cinema"),
  WORKOUT("Workout"),
  SEE_FRIENDS("See friends"),
  GO_TO_RESTAURANT("Go to a restaurant"),
  PLAY_FOOTBALL("Play football");

  private final String name;

  Tasks(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
