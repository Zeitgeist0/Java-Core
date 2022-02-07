package pet;


import java.util.HashSet;

public class Fish extends Pet {

  public   Fish () {}

  public Fish (String nickname, int age, int trickLevel) {
    super(nickname,age,trickLevel);

  }
  public Fish (String nickname, int age, int trickLevel, HashSet <String> habits) {
    super(nickname, age, trickLevel, habits);

  }
  public void respond () {
    System.out.println("Glub glub glub");
  }

}
