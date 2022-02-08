package human;

import pet.*;

import java.util.Map;

public final class Woman extends Human {
  public Woman(String name, String surname, String birthDate, int iq, Map<DayOfWeek, String> schedule) {
    super(name, surname, birthDate, iq, schedule);
  }

  public Woman(String name, String surname, long birthDate, int iq, Map<DayOfWeek, String> schedule) {
    super(name, surname, birthDate, iq, schedule);
  }

  public Woman(String name, String surname, String birthDate, int iq) {
    super(name, surname, birthDate, iq);
  }

  public Woman(String name, String surname, String birthDate) {
    super(name, surname, birthDate);
  }

  public Woman(String name, String surname, long birthDate) {
    super(name, surname, birthDate);
  }

  public Woman(String name, String surname) {
    super(name, surname);
  }

  public void run() {
    System.out.println("I need to speed up");
  }

  @Override
  public void greetPet(Pet pet) {
    if (isMyPet(pet)) {
      System.out.printf("Hi %s, i really missed you! %n", this.getFamily().findPet(pet).getNickname());
    }

  }
}
