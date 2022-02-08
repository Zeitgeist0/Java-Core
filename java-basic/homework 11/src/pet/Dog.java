package pet;


import java.util.HashSet;

public class Dog extends Pet implements Foul {


  public Dog(String nickname, int age, int trickLevel, HashSet<String> habits) {
    super(nickname, age, trickLevel, habits);

  }

  public Dog(String nickname, int age, int trickLevel) {
    super(nickname, age, trickLevel);

  }

  public Dog() {
    super();

  }

  @Override
  public void foul() {
    System.out.println("I did tear the pillow, guess they'll need to buy a new one");
  }

  @Override
  public void respond() {
    System.out.printf("Bark bark! I'm a %s and I'm glad to see you as always", this.getSpecies().getName());
  }

}
