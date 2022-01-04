package oop.practice.family;

import java.util.Arrays;

public class Dog extends Pet implements Foul{
private Species species;

  public Dog(String nickname, int age, int trickLevel, String[] habits) {
    super(nickname, age, trickLevel, habits);
    this.species = Species.DOG;
  }

  public Dog(String nickname, int age, int trickLevel) {
    super(nickname, age, trickLevel);
    this.species = Species.DOG;
  }

  public Dog() {
    super();
    this.species = Species.DOG;
  }

  @Override
  public void foul() {
    System.out.println("I did tear the pillow, guess they'll need to buy a new one");
  }

  @Override
  public void respond() {
    System.out.printf("Bark bark! I'm a %s and I'm glad to see you as always", this.getSpecies().getName());
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
