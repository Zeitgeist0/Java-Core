package oop.practice.family;


import java.util.HashSet;

public class DomesticCat extends  Pet implements Foul {
  private Species species;
  public DomesticCat(String nickname, int age, int trickLevel, HashSet <String> habits) {
    super( nickname, age, trickLevel, habits);
    this.species = Species.DOMESTIC_CAT;
  }

  public DomesticCat(String nickname, int age, int trickLevel) {
    super( nickname, age, trickLevel);
    this.species = Species.DOMESTIC_CAT;
  }

  public DomesticCat() {
    super();
    this.species = Species.DOMESTIC_CAT;
  }

  @Override
  public void foul() {
    System.out.println("I've broken the vase, I should hide until they are calmed down");
  }

  @Override
  public void respond() {
    System.out.printf("Meow, I'm a %s and I don't need your attention", this.getSpecies().getName());
  }

  @Override
  public String toString() {
    return String.format("%s{nickname='%s' , age=%d, trickLevel=%d, habits=[%s]} %n ",
      species, this.getNickname(),this.getAge(),this.getTrickLevel(),  this.getHabits());
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
