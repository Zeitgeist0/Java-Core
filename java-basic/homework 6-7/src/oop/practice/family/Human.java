package oop.practice.family;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class Human {
private String name;
private String surname;
private long birthDate;
private int iq;
private Family family;
private Map<String, String> schedule;

  public Human() {
  }

  public Human(String name, String surname, String birthDate, int iq, Map<String, String> schedule) {
    this.name = name;
    this.surname = surname;
    this.birthDate = StringDateToLongDate(birthDate);
    this.iq = iq;
    this.schedule = schedule;

  }

  public Human(String name, String surname, long birthDate, int iq, Map<String, String> schedule) {
    this.name = name;
    this.surname = surname;
    this.birthDate = birthDate;
    this.iq = iq;
    this.schedule = schedule;

  }

  public Human(String name, String surname, String birthDate, int iq) {
    this.name = name;
    this.surname = surname;
    this.birthDate = StringDateToLongDate(birthDate);
    this.iq = iq;
  }
  public Human(String name, String surname, String birthDate) {
    this.name = name;
    this.surname = surname;
    this.birthDate = StringDateToLongDate(birthDate);
  }

  public Human(String name, String surname, long birthDate) {
    this.name = name;
    this.surname = surname;
    this.birthDate = birthDate;
  }
  public Human(String name, String surname) {
    this.name = name;
    this.surname = surname;
    this.birthDate = System.currentTimeMillis();
  }


  public boolean hasFamily () {
    return this.family != null;
  }

  private Period getCurrentYearsMonthsDays() {
    return Period.between(LocalDate.ofInstant(Instant.ofEpochMilli(birthDate), TimeZone.getDefault().toZoneId()), LocalDate.now());
  }

  public String describeAge() {
    Period period = getCurrentYearsMonthsDays();
    return "I have " +
      period.getYears() +
      " years " +
      period.getMonths() +
      " months " +
      period.getDays() +
      " days";
  }

public String dateOfBirthToString() {
  LocalDate localDate;
 StringBuilder stringBuilder = new StringBuilder();
   localDate = LocalDate.ofInstant(Instant.ofEpochMilli(birthDate), TimeZone.getDefault().toZoneId());
  stringBuilder.append("'");
  stringBuilder.append(localDate.getDayOfMonth());
  stringBuilder.append("/");
  stringBuilder.append(localDate.getMonthValue());
  stringBuilder.append("/");
  stringBuilder.append(localDate.getYear());
  stringBuilder.append('\'');
  return  stringBuilder.toString();

}
  private long StringDateToLongDate(String dateString) {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    try {
      return simpleDateFormat.parse(dateString).getTime();
    } catch (ParseException e) {
      return System.currentTimeMillis();
    }
  }
  public void greetPet (Pet pet) {
    if (!hasFamily() || !family.hasPet()) {
      System.out.println("I don't have a pet");
      return;
    }
  System.out.printf("Hi %s%n", this.getFamily().findPet(pet).getNickname());
}

public void describePet (Pet pet) {
  if (!hasFamily() || !family.hasPet()) {
    System.out.println("I don't have a pet");
    return;
  }
  String howTricky = this.getFamily().findPet(pet).getTrickLevel() > 50 ?  "very tricky" : "not very tricky";
  System.out.printf("I have a %s, he is %d years old, and he is %s%n ", this.getFamily().findPet(pet).getSpecies().getName().toLowerCase(),
    this.getFamily().findPet(pet).getAge(), howTricky );
}

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Human human = (Human) o;
    return birthDate == human.birthDate && name.equals(human.name) && surname.equals(human.surname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, surname, birthDate);
  }

  @Override
  public String toString() {
    return String.format("Human{name='%s', surname='%s', birthDate=%s, iq=%d, schedule='%s'} %n ",
      name, surname, dateOfBirthToString() ,iq, schedule);
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

  public long getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(long birthDate) {
    this.birthDate = birthDate;
  }

  public int getIq() {
    return iq;
  }

  public void setIq(int iq) {
    this.iq = iq;
  }


  public Map<String, String> getSchedule() {
    return schedule;
  }

  public void setSchedule(Map<String, String> schedule) {
    this.schedule = schedule;
  }

  public Family getFamily() {
    return family;
  }

  public void setFamily(Family family) {
    this.family = family;
  }
}
