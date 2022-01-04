package oop.practice.family;


import java.util.Arrays;
import java.util.Objects;

public abstract class Pet  {
  private Species species;
  private String nickname;
  private int age;
  private int trickLevel;
  private String[] habits;


  public Pet(String nickname, int age, int trickLevel, String[] habits) {
    this.species = Species.UNKNOWN;
    this.nickname = nickname;
    this.age = age;
    this.trickLevel = trickLevel;
    this.habits = habits;
  }
  public Pet (String nickname, int age, int trickLevel) {
    this.species = Species.UNKNOWN;
    this.nickname = nickname;
    this.age = age;
    this.trickLevel = trickLevel;
  }
  public Pet () {
    this.species = Species.UNKNOWN;
  }


  public void eat() {
    System.out.printf("I'm eating %n");
  }
  public abstract void respond ();


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Pet pet = (Pet) o;
    return species.equals(pet.species) && nickname.equals(pet.nickname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(species, nickname);
  }

  @Override
  public String toString() {
    return String.format("%s{nickname='%s' , age=%d, trickLevel=%d, habits=[%s]} %n ",
      species, nickname,age,trickLevel, Arrays.toString(habits));
  }
  @Override
  protected void finalize() throws Throwable {
    System.out.println(this.toString());
    super.finalize();
  }
  public Species getSpecies() {
    return species;
  }

  public void setSpecies(Species species) {
    this.species = species;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public int getTrickLevel() {
    return trickLevel;
  }

  public void setTrickLevel(int trickLevel) {
    this.trickLevel = trickLevel;
  }

  public String[] getHabits() {
    return habits;
  }

  public void setHabits(String[] habits) {
    this.habits = habits;
  }
}
