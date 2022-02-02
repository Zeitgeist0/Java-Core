package oop.practice.family;

public class FamilyDateApp {
  public static Man man1 = new Man("John", "Doe", System.currentTimeMillis());
  public static Man man2 = new Man("Mark", "Watson" );
  public static Man man3 = new Man("Steven", "White");
  public static Man man4 = new Man("Brock", "Rock");
  public static  Woman woman1 = new Woman("Alice", "Jones");
  public static  Woman woman2 = new Woman("Elisabeth", "Taylor");
  public static  Woman woman3 = new Woman("Emma", "Philips", "25/08/1990", 45);
  public static  Woman woman4 = new Woman("Tina", "Turner");
  public static Family family1 = new Family(woman1, man1);
  public static Family family2 = new Family(woman4, man4);


  public static void main(String[] args) {
    FamilyDao familyDao = FamilyCollection.instanceOf();
    FamilyService familyService = new FamilyService(familyDao);
    FamilyController familyController = new FamilyController(familyService);
   familyController.createNewFamily(man2, woman3);
   familyController.displayAllFamilies();

    System.out.println(woman3.describeAge());


  }
}
