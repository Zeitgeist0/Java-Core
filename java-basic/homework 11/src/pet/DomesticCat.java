package pet;


import java.util.HashSet;

public class DomesticCat extends Pet implements Foul {

  public DomesticCat(String nickname, int age, int trickLevel, HashSet <String> habits) {
    super( nickname, age, trickLevel, habits);

  }

  public DomesticCat(String nickname, int age, int trickLevel) {
    super( nickname, age, trickLevel);

  }

  public DomesticCat() {
    super();

  }

  @Override
  public void foul() {
    System.out.println("I've broken the vase, I should hide until they are calmed down");
  }

  @Override
  public void respond() {
    System.out.printf("Meow, I'm a %s and I don't need your attention", this.getSpecies().getName());
  }



}
