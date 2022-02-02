package oop.practice.family;

public class FamilyApp {
  public static Man man1 = new Man("John", "Doe");
  public static Man man2 = new Man("Mark", "Watson");
  public static Man man3 = new Man("Steven", "White");
  public static Man man4 = new Man("Brock", "Rock");
  public static  Woman woman1 = new Woman("Alice", "Jones");
  public static  Woman woman2 = new Woman("Elisabeth", "Taylor");
  public static  Woman woman3 = new Woman("Emma", "Philips", "2000", 45);
  public static  Woman woman4 = new Woman("Tina", "Turner");
 public static Family family1 = new Family(woman1, man1);
  public static Family family2 = new Family(woman4, man4);

  public static void main(String[] args) {
//
    FamilyDao familyDao = FamilyCollection.instanceOf();
    FamilyService familyService = new FamilyService(familyDao);
    FamilyController familyController = new FamilyController(familyService);
    familyController.saveFamily(family1);
familyController.createNewFamily(man2, woman2);

    familyController.saveFamily(family2);
   family1.addChild(woman3);
   familyController.bornChild(family2, "ZZZZZZ", "XXXXXX");
   familyController.bornChild(family1, "ALFRED", "MONICA");
   familyController.getFamiliesBiggerThan(3);
    familyController.getFamiliesLessThan(3);
   familyController.displayAllFamilies();
    familyController.deleteAllChildrenOlderThan(18);

    familyController.adoptChild(family1, man3);
    familyController.displayAllFamilies();
    RobotCat robotCat = new RobotCat("Tiger", 143, 22222);
    familyController.addPet(0, robotCat);
    System.out.println(familyController.getPets(0));
    System.out.println(familyController.getFamilyByIndex(2));
    System.out.println(familyController.countFamiliesWithMemberNumber(4));
  }


}
