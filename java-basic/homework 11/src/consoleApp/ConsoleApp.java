package consoleApp;

import family.*;
import human.*;
import pet.*;

import java.util.*;
import java.util.stream.IntStream;

public class ConsoleApp {

  private final Scanner scanner;
  private final FamilyController familyController;
  private final List<OperationApp> command;
  private final List<OperationApp> editFamilyCommand;
  private boolean isRunning = true;
  private boolean returnToMainMenu = false;

  public ConsoleApp() {
    this.scanner = new Scanner(System.in);
    FamilyDao familyDao = FamilyCollection.instanceOf();
    FamilyService familyService = new FamilyService(familyDao);
    familyController = new FamilyController(familyService);

    command = Arrays.asList(
      new OperationApp("Generate test data", this::fillWithTestData),
      new OperationApp("Display all families", this::printAllFamilies),
      new OperationApp("Display families who have more than the desired number of members", this::printFamiliesBiggerThan),
      new OperationApp("Display families who have less than the desired number of members", this::printFamiliesSmallerThan),
      new OperationApp("Count the amount of families who have a specific number of member", this::printCountFamiliesWithMemberNumber),
      new OperationApp("Create new family", this::createNewFamily),
      new OperationApp("Delete a family by it's index", this::removeFamilyByIndex),
      new OperationApp("Edit a family by it's index", this::editFamilyByIndex),
      new OperationApp("Delete all childs older than a specific age", this::deleteAllChildrenOlderThan),
      new OperationApp("Exit the app", this::exitTheApplication)
    );

    editFamilyCommand = Arrays.asList(
      new OperationApp("Born a child", this::bornChild),
      new OperationApp("Adopt a child", this::adoptChild),
      new OperationApp("Go back to main menu", this::returnToMainMenu)
    );
  }

  public void run() {
    while (isRunning) {
      printCommand(command);
      OperationApp operationApp = command.get(scanInteger(1, command.size()) - 1);
      System.out.println(operationApp.operationName);
      operationApp.operation.operation();
    }
  }

  private void printCommand(List<OperationApp> command) {
    IntStream.range(0, command.size()).forEach(i -> System.out.println(i + 1 + " - " + command.get(i).operationName));
    System.out.print("Print command -> ");
  }

  public static boolean isNumeric(String strNum, int from, int to) {
    return strNum.matches("-?\\d+(\\.\\d+)?") && Integer.parseInt(strNum) >= from && Integer.parseInt(strNum) <= to;
  }

  public static boolean isNumeric(String strNum) {
    return strNum.matches("-?\\d+(\\.\\d+)?");
  }

  public int scanInteger() {
    String integer = scanner.next();
    boolean isValid = isNumeric(integer);
    while (!isValid) {
      integer = scanner.next();
      isValid = isNumeric(integer);
      System.out.println("Enter valid data");
    }
    return Integer.parseInt(integer);
  }

  public int scanInteger(int from, int to) {
    String integer = scanner.next();
    boolean isValid = isNumeric(integer, from, to);
    while (!isValid) {
      System.out.print("Enter valid data -> ");
      integer = scanner.next();
      isValid = isNumeric(integer);
    }
    return Integer.parseInt(integer);
  }

  private void exitTheApplication() {
    isRunning = false;
  }

  private void returnToMainMenu() {
    returnToMainMenu = true;
  }

  private void fillWithTestData() {
    Map<DayOfWeek, String> schedule = new HashMap<>();
    schedule.put(DayOfWeek.MONDAY, "Go to work");
    schedule.put(DayOfWeek.FRIDAY, "Go to cinema");
    schedule.put(DayOfWeek.SATURDAY, "Rest");
    HashSet<String> habits = new HashSet<>();
    habits.add("Jump");
    habits.add("Run");
    habits.add("Eat");
    Man man = new Man("John", "Doe", "24/10/1990", 111, schedule);
    Woman woman = new Woman("Lisa", "Taylor", "5/1/1993", 121, schedule);
    Man man1 = new Man("Alfred", "Spencer", "7/2/1997", 131, schedule);
    Woman woman1 = new Woman("Alice", "White", "25/12/1997", 115, schedule);
    Human child = new Man("John", "Doe", "20/1/2021", 22, schedule);
    Human boy = new Man("John", "Doe", "15/2/2015", 60);
    Human girl = new Woman("John", "Doe", "10/3/2017", 60);
    Pet pet = new Dog("Doge", 24, 35);
    RobotCat robotCat = new RobotCat("Tiger", 2, 99, habits);
    Family family = new Family(woman, man);
    family.addChild(child);
    familyController.saveFamily(family);
    familyController.createNewFamily(woman1, man1);
    familyController.adoptChild(1, girl);
    familyController.adoptChild(0, boy);
    familyController.addPet(0, pet);
    familyController.addPet(1, robotCat);
  }

  private void printAllFamilies() {
    familyController.displayAllFamilies();
  }

  private void printFamiliesBiggerThan() {
    System.out.print("Bigger than -> ");
    List<Family> familyList = familyController.getFamiliesBiggerThan(scanInteger());
    familyController.displayFamilies(familyList);
  }

  private void printFamiliesSmallerThan() {
    System.out.print("Smaller than -> ");
    List<Family> familyList = familyController.getFamiliesLessThan(scanInteger());
    familyController.displayFamilies(familyList);
  }

  public void printCountFamiliesWithMemberNumber() {
    System.out.print("Equals to -> ");
    System.out.println(familyController.countFamiliesWithMemberNumber(scanInteger()));
  }

  public void createNewFamily() {
    System.out.print("Mother's name -> ");
    String motherName = scanner.next();
    System.out.print("Mother's surname -> ");
    String motherSurname = scanner.next();
    System.out.print("Mother's year of birth -> ");
    String motherYear = scanner.next();
    System.out.print("Mother's month of birth -> ");
    String motherMonth = scanner.next();
    System.out.print("Mother's day of birth -> ");
    String motherDay = scanner.next();
    System.out.print("Mother's IQ -> ");
    int motherIQ = scanInteger();

    System.out.print("Father's name -> ");
    String fatherName = scanner.next();
    System.out.print("Father's surname -> ");
    String fatherSurname = scanner.next();
    System.out.print("Father's year of birth -> ");
    String fatherYear = scanner.next();
    System.out.print("Father's month of birth -> ");
    String fatherMonth = scanner.next();
    System.out.print("Father's day of birth -> ");
    String fatherDay = scanner.next();
    System.out.print("Father's IQ -> ");
    int fatherIQ = scanInteger();

    familyController.createNewFamily(
      new Woman(motherName, motherSurname, (motherDay + "/" + motherMonth + "/" + motherYear), motherIQ),
      new Man(fatherName, fatherSurname, (fatherDay + "/" + fatherMonth + "/" + fatherYear), fatherIQ)
    );
  }

  private void removeFamilyByIndex() {
    System.out.print("Family index -> ");
    boolean result = familyController.deleteFamily(scanInteger());
    if (result) {
      System.out.println("Family successfully deleted");
    } else {
      System.out.println("Family wasn't deleted");
    }
  }

  private void editFamilyByIndex() {
    returnToMainMenu = false;
    while (!returnToMainMenu) {
      printCommand(editFamilyCommand);
      OperationApp operationApp = editFamilyCommand.get(scanInteger(1, editFamilyCommand.size()) - 1);
      System.out.println(operationApp.operationName);
      operationApp.operation.operation();
    }
  }

  private boolean familyIndexCheck(int index) {
    return index < familyController.getAllFamilies().size();
  }

  private void bornChild() {
    System.out.print("Family index -> ");
    int familyIndex = scanInteger();
    if (!familyIndexCheck(familyIndex)) {
      System.out.println("There is no family for such index");
      return;
    }
    System.out.print("Boy's name -> ");
    String boyName = scanner.next();
    System.out.print("Girl's name -> ");
    String girlName = scanner.next();

    Family family = familyController.getFamilyByIndex(familyIndex);
    System.out.println(familyController.bornChild(family, girlName, boyName).toPrettyFormat());
  }

  private void adoptChild() {
    System.out.print("Family index -> ");
    int familyIndex = scanInteger();
    if (!familyIndexCheck(familyIndex)) {
      System.out.println("There is no family for such index");
      return;
    }
    System.out.print("Child's name -> ");
    String childName = scanner.next();
    System.out.print("Child's surname -> ");
    String childSurname = scanner.next();
    System.out.print("Child's year of birth -> ");
    String childYear = scanner.next();
    System.out.print("Child's month of birth -> ");
    String childMonth = scanner.next();
    System.out.print("Child's day of birth -> ");
    String childDay = scanner.next();
    System.out.print("Child's IQ -> ");
    int childIQ = scanInteger();
    System.out.println("Child's gender 1-boy, 2-girl");
    int gender = scanInteger(1, 2);

    Family family = familyController.getFamilyByIndex(familyIndex);

    Human child;
    if (gender == 1) {
      child = new Man(childName, childSurname, (childDay + "/" + childMonth + "/" + childYear), childIQ);
    } else {
      child = new Woman(childName, childSurname, (childDay + "/" + childMonth + "/" + childYear), childIQ);
    }

    System.out.println(familyController.adoptChild(family, child).toPrettyFormat());
  }

  private void deleteAllChildrenOlderThan() {
    System.out.print("Older than -> ");
    familyController.deleteAllChildrenOlderThan(scanInteger());
    System.out.println("Action completed");
  }
}
