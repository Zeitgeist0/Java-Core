package oop.practice.family;

import java.util.HashSet;

public class FamilyPractice {

  public static void main(String[] args) {
 Fish fish = new Fish("Fishy", 4 , 5);
    System.out.println(fish.getSpecies());
    Man man = new Man("Michael", "Myers", 1990, 120);
    Woman woman = new Woman("Caroline", "Johnson", 1950, 106);
     Man man2 = new Man("Michael", "Corleone", 1990, 120);
    Family family = new Family(woman, man);
    RobotCat robotCat = new RobotCat("Mewtwo", 134, 150);
    RobotCat robotCat2 = new RobotCat("Mewtwo", 134, 150);
    robotCat.foul();
    robotCat.eat();
    robotCat.respond();
    HashSet <String> habits = new HashSet<>();
    habits.add("Jump");
    robotCat.setHabits(habits);
    robotCat2.setHabits(habits);
    System.out.println(robotCat.toString());
    man.swim();
    woman.run();
    System.out.println(robotCat.equals(robotCat2));
    HashSet<Pet> pets = new HashSet<>();
    pets.add(robotCat);
    family.setPet(pets);
    man.greetPet(robotCat);
    man.describePet(robotCat);
     man2.greetPet(robotCat);
     man2.greetPet(robotCat2);
  }


  }

