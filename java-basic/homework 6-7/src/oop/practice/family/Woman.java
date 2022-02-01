package oop.practice.family;

import java.util.HashMap;

public final class Woman extends Human{
  public Woman(String name, String surname, int year, int iq, HashMap<String, String> schedule) {
    super(name, surname, year, iq, schedule);
  }

  public Woman(String name, String surname, int year, int iq) {
    super(name, surname, year, iq);
  }
  public Woman(String name, String surname) {
    super(name, surname);
  }
  public Woman() {
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
