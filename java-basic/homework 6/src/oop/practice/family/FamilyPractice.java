package oop.practice.family;

public class FamilyPractice {

  public static void main(String[] args) {
 Fish fish = new Fish("Fishy", 4 , 5);
    System.out.println(fish.getSpecies());

    Man man = new Man("Michael", "Myers", 1990, 120);
    Woman woman = new Woman("Caroline", "Johnson", 1950, 106);
    Family family = new Family(woman, man);
    family.setPet(fish);
    man.greetPet();
    man.describePet();
    woman.greetPet();
    RobotCat robotCat = new RobotCat("Mewtwo", 134, 150);
    robotCat.foul();
    robotCat.eat();
    robotCat.respond();
    System.out.println(robotCat.toString());
    man.swim();
    woman.run();
  }


  }

