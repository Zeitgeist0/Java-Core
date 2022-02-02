package oop.practice.family;

import java.util.HashMap;
import java.util.Map;

public final class Woman extends Human{
  public Woman(String name, String surname, String birthDate, int iq, Map<String, String> schedule) {
    super(name, surname, birthDate, iq, schedule);
  }

  public Woman(String name, String surname, long birthDate, int iq, Map<String, String> schedule) {
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
  public void greetPet (Pet pet) {
    if (!hasFamily() || !this.getFamily().hasPet()) {
      System.out.println("I don't have a pet");
      return;
    }

    System.out.printf("Hi %s, i really missed you! %n", this.getFamily().findPet(pet).getNickname());
  }
}
