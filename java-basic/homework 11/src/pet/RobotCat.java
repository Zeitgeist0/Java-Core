package pet;


import java.util.HashSet;

public class RobotCat extends Pet implements Foul {

  public RobotCat(String nickname, int age, int trickLevel, HashSet <String> habits) {
    super( nickname, age, trickLevel, habits);

  }

  public RobotCat( String nickname, int age, int trickLevel) {
    super( nickname, age, trickLevel);

  }

  public RobotCat() {
    super();

  }

  @Override
  public void foul() {
    System.out.println("I've burnt the house,guess I need to find a new one");
  }

  @Override
  public void respond() {
    System.out.printf("Beep beep, I'm a %s and i'm new to this planet %n", this.getSpecies().getName());
  }


}
