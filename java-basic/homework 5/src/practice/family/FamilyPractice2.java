package practice.family;

import java.util.Arrays;

public class FamilyPractice2 {
  public static void main(String[] args) {
//    Finalize usage example
//    for (int i = 0; i < 10000000; i++) {
//      Human human = new Human("John", "Spencer", i, i);
//    }

    Pet pet1 = new Pet(Species.BIRD, "Bubi", 4 , 56);
    Pet pet2 = new Pet(Species.BIRD, "Bubi", 5 , 88);
    Human human1 = new Human("Alfred", "Spencer", 1997, 105);
    Human human2 = new Human("Mary", "Wilson", 1996, 104 );
    Human human3 = new Human("Anthony", "Spencer", 1950, 145);
    Human human4 = new Human("John","Doe", 1997 , 105);
    String[][] schedule = new String[2][2];
    schedule[0][0] = DayOfWeek.FRIDAY.getName();
    schedule[0][1] = Tasks.GO_TO_CINEMA.getName();
    schedule[1][0] = DayOfWeek.MONDAY.getName();
    schedule[1][1] = Tasks.WORKOUT.getName();
    human1.setSchedule(schedule);
    System.out.println(human1.toString());
    Family family1 = new Family(human2, human1);
    family1.setPet(pet1);
    family1.addChild(human3);
    family1.addChild(human4);
    human3.greetPet();
    human3.describePet();
    pet1.foul();
    System.out.println(pet1.getSpecies().toString().toLowerCase());
    pet1.respond();
    System.out.println(pet1.equals(pet2));
    family1.countFamily();
    family1.deleteChild(human4);
    System.out.println(human4.getFamily());
    family1.countFamily();


  }
}
