package oop.practice.family;

import java.util.Arrays;

public class RobotCat extends Pet implements Foul {
  private Species species;
  public RobotCat(String nickname, int age, int trickLevel, String[] habits) {
    super( nickname, age, trickLevel, habits);
    this.species = Species.ROBOT_CAT;
  }

  public RobotCat( String nickname, int age, int trickLevel) {
    super( nickname, age, trickLevel);
    this.species = Species.ROBOT_CAT;
  }

  public RobotCat() {
    super();
    this.species = Species.ROBOT_CAT;
  }

  @Override
  public void foul() {
    System.out.println("I've burnt the house,guess I need to find a new one");
  }

  @Override
  public void respond() {
    System.out.printf("Beep beep, I'm a %s and i'm new to this planet %n", this.getSpecies().getName());
  }

  @Override
  public String toString() {
    return String.format("%s{nickname='%s' , age=%d, trickLevel=%d, habits=[%s]} %n ",
      species, this.getNickname(),this.getAge(),this.getTrickLevel(),  Arrays.toString(this.getHabits()));
  }

  @Override
  public Species getSpecies() {
    return species;
  }

  @Override
  public void setSpecies(Species species) {
    this.species = species;
  }
}
