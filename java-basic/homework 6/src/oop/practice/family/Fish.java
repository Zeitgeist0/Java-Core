package oop.practice.family;

import java.util.Arrays;

public class Fish extends Pet  {
  private Species species;
  public   Fish () {this.species = Species.FISH;}

  public Fish (String nickname, int age, int trickLevel) {
    super(nickname,age,trickLevel);
    this.species = Species.FISH;
  }
  public Fish (String nickname, int age, int trickLevel, String[] habits) {
    super(nickname, age, trickLevel, habits);
    this.species = Species.FISH;
  }
  public void respond () {
    System.out.println("Glub glub glub");
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
