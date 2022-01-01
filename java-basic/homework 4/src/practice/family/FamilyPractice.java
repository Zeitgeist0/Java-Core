package practice.family;

public class FamilyPractice {
  public static void main(String[] args) {
    String[][] schedule = generateSchedule();
    Pet pet1 = new Pet("Dog", "Doge", 5, 75);
    Pet pet2 = new Pet("Cat" , "Mewtwo", 2, 34);
    Human human1 = new Human("John","Doe", 1997 , 105, schedule);
    Human human2 = new Human("Mary", "Wilson", 1996, 104 );
    Human human3 = new Human("Anthony", "Spencer", 1950, 145);
    Human human4 = new Human("Lara", "Mayer", 1951, 123, schedule);
    Human human5 = new Human("Stephen", "King", 2005, 76);
    Human human6 = new Human("Melissa", "Connor", 2020, 78, schedule);
    Human human7 = new Human("Melissa", "Connor", 2020, 78);
    Family family1 = new Family(human2, human1);
    Family family2 = new Family(human6,human5);
    family1.addChild(human3);
    family1.addChild(human4);
    family1.deleteChild(0);
    family2.addChild(human3);
    family1.setPet(pet1);
    family2.addChild(human7);
//    System.out.println(human1.toString());
//    System.out.println(human2.toString());
//    System.out.println(human4.toString());
//    System.out.println(human3.getFamily());
//human3.describePet();
//human3.greetPet();
//human4.describePet();
//human4.greetPet();
//pet2.respond();
//pet2.eat();
//pet1.foul();
//    family1.countFamily();
//    family2.countFamily();
//    System.out.println(human6.getFamily());


  }

  public static String[][] generateSchedule () {
    String[][] schedule = new String[7][2];
    schedule[0][0] = "Monday";
    schedule[0][1] = "Do some homework";
    schedule[1][0] = "Tuesday";
    schedule[1][1] = "Workout";
    schedule[2][0] = "Wednesday";
    schedule[2][1] = "Take a walk";
    schedule[3][0] = "Thursday";
    schedule[3][1] = "Go to the cinema";
    schedule[4][0] = "Friday";
    schedule[4][1] = "Go to the club";
    schedule[5][0] = "Saturday";
    schedule[5][1] = "Go to the theatre";
    schedule[6][0] = "Sunday";
    schedule[6][1] = "Rest at home";
    return schedule;
  }
}
