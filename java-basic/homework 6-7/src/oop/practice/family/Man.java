package oop.practice.family;

import java.util.HashMap;
import java.util.Map;

public final class Man extends Human{

  public Man(String name, String surname, String birthDate, int iq, Map<String, String> schedule) {
    super(name, surname, birthDate, iq, schedule);
  }

  public Man(String name, String surname, long birthDate, int iq, Map<String, String> schedule) {
    super(name, surname, birthDate, iq, schedule);
  }

  public Man(String name, String surname, String birthDate, int iq) {
    super(name, surname, birthDate, iq);
  }

  public Man(String name, String surname, String birthDate) {
    super(name, surname, birthDate);
  }

  public Man(String name, String surname, long birthDate) {
    super(name, surname, birthDate);
  }

  public Man(String name, String surname) {
    super(name, surname);
  }
  public void swim () {
    System.out.println("Glub glub, I should swim faster");
  }
  @Override
  public void greetPet (Pet pet) {
    if (!hasFamily() || !this.getFamily().hasPet()) {
      System.out.println("I don't have a pet");
      return;
    }

    System.out.printf("Hi %s, what a good boy! %n", this.getFamily().findPet(pet).getNickname());
  }
}
