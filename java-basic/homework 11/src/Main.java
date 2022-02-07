import family.Family;
import human.*;
import pet.*;

import java.util.HashSet;

public class Main {
  public static void main(String[] args) {
    Dog dog = new Dog("Doge", 23 , 245);
    HashSet<String> habits = new HashSet<>();
    habits.add("Run");
    habits.add("Jump");
    dog.setHabits(habits);
//    System.out.println(dog.toString());
    Man man = new Man("John", "Trial", 23);
    Woman woman = new Woman("John", "Trial", 23);
    Woman woman1 = new Woman("John", "Trial", 23);
    Man man2 = new Man("John", "Trial", 23);
    Man man3 = new Man("John", "Trial", 23);
    Family family = new Family(woman, man);
    family.addPet(dog);
    Dog dog1 = new Dog("Doge", 23 , 245);

    family.addPet(dog1);

    family.addChild(man2);
    family.addChild(man3);
    family.addChild(woman1);
    System.out.println(family.toPrettyFormat());
  }
}
