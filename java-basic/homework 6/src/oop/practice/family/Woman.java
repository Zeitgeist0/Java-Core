package oop.practice.family;

public final class Woman extends Human{
  public Woman(String name, String surname, int year, int iq, String[][] schedule) {
    super(name, surname, year, iq, schedule);
  }

  public Woman(String name, String surname, int year, int iq) {
    super(name, surname, year, iq);
  }

  public Woman() {
  }
  public void run() {
    System.out.println("I need to speed up");
  }
  @Override
  public void greetPet () {
    if (!hasFamily() || !this.getFamily().hasPet()) {
      System.out.println("I don't have a pet");
      return;
    }

    System.out.printf("Hi %s, i really missed you! %n", this.getFamily().getPet().getNickname());
  }
}
