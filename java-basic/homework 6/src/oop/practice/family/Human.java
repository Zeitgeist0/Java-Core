package oop.practice.family;

import java.util.Arrays;
import java.util.Objects;

public class Human {
private String name;
private String surname;
private int year;
private int iq;
private Family family;
private String[][] schedule;

  public Human(String name, String surname, int year, int iq, String[][] schedule) {
    this.name = name;
    this.surname = surname;
    this.year = year;
    this.iq = iq;
    this.schedule = schedule;
  }

  public Human(String name, String surname, int year, int iq) {
    this.name = name;
    this.surname = surname;
    this.year = year;
    this.iq = iq;
  }

  public  Human () {}

  public boolean hasFamily () {
    return this.family != null;
  }

  public void greetPet () {
    if (!hasFamily() || !family.hasPet()) {
      System.out.println("I don't have a pet");
      return;
    }

  System.out.printf("Hi %s%n", family.getPet().getNickname());
}

public void describePet () {
  if (!hasFamily() || !family.hasPet()) {
    System.out.println("I don't have a pet");
    return;
  }
  String howTricky = family.getPet().getTrickLevel() > 50 ?  "very tricky" : "not very tricky";
  System.out.printf("I have a %s, he is %d years old, and he is %s%n ", family.getPet().getSpecies().toString().toLowerCase(),
    family.getPet().getAge(), howTricky );
}

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Human human = (Human) o;
    return year == human.year && name.equals(human.name) && surname.equals(human.surname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, surname, year);
  }

  @Override
  public String toString() {
    return String.format("Human{name='%s', surname='%s', year=%d, iq=%d, schedule='%s'} %n ",
      name, surname,year,iq, Arrays.deepToString(schedule));
  }

  @Override
  protected void finalize() throws Throwable {
    System.out.println(this.toString());
    super.finalize();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public int getIq() {
    return iq;
  }

  public void setIq(int iq) {
    this.iq = iq;
  }



  public String[][] getSchedule() {
    return schedule;
  }

  public void setSchedule(String[][] schedule) {
    this.schedule = schedule;
  }

  public Family getFamily() {
    return family;
  }

  public void setFamily(Family family) {
    this.family = family;
  }
}
