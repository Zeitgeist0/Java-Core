package pet;


import java.util.HashSet;
import java.util.Objects;

public abstract class Pet {
  private Species species;
  private String nickname;
  private int age;
  private int trickLevel;
  private HashSet<String> habits;

  {
    try {
      species = Species.valueOf(this.getClass().getSimpleName().toUpperCase());
    } catch (IllegalArgumentException e) {
      
      species = Species.UNKNOWN;
    }
  }

  public Pet(String nickname, int age, int trickLevel, HashSet<String> habits) {
    this.nickname = nickname;
    this.age = age;
    this.trickLevel = trickLevel;
    this.habits = habits;
  }

  public Pet(String nickname, int age, int trickLevel) {
    this.nickname = nickname;
    this.age = age;
    this.trickLevel = trickLevel;
  }

  public Pet() {
  }


  public void eat() {
    System.out.printf("I'm eating %n");
  }

  public abstract void respond();


  @Override
  public String toString() {
    return String.format("{species='%s', nickname='%s' , age=%d, trickLevel=%d, habits=%s}%n",
      species, nickname, age, trickLevel, habits);
  }

  @Override
  protected void finalize() throws Throwable {
    System.out.println(this);
    super.finalize();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Pet pet = (Pet) o;
    return age == pet.age && trickLevel == pet.trickLevel && species == pet.species && nickname.equals(pet.nickname) && Objects.equals(habits, pet.habits);
  }

  @Override
  public int hashCode() {
    return Objects.hash(species, nickname, age, trickLevel, habits);
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

  public HashSet<String> getHabits() {
    return habits;
  }

  public void setHabits(HashSet<String> habits) {
    this.habits = habits;
  }
}
