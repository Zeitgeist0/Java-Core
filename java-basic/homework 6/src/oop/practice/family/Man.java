package oop.practice.family;

public final class Man extends Human{
  public Man(String name, String surname, int year, int iq, String[][] schedule) {
    super(name, surname, year, iq, schedule);
  }

  public Man(String name, String surname, int year, int iq) {
    super(name, surname, year, iq);
  }

  public Man() {
  }

  public void swim () {
    System.out.println("Glub glub, I should swim faster");
  }
  @Override
  public void greetPet () {
    if (!hasFamily() || !this.getFamily().hasPet()) {
      System.out.println("I don't have a pet");
      return;
    }

    System.out.printf("Hi %s, what a good boy! %n", this.getFamily().getPet().getNickname());
  }
}
