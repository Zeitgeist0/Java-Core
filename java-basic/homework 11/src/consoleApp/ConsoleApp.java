package consoleApp;
import family.*;
import human.*;
import pet.*;
import java.util.*;

public class ConsoleApp {

  private final Scanner scanner;
  private final FamilyController familyController;
//  private final List<OperationApp> command;
//  private final List<OperationApp> editFamilyCommand;
  private boolean isExit = true;
  private boolean isReturnToMainMenu = true;

  public ConsoleApp() {
    this.scanner = new Scanner(System.in);
    FamilyDao familyDao = FamilyCollection.instanceOf();
    FamilyService familyService = new FamilyService(familyDao);
    familyController = new FamilyController(familyService);

//    command = Arrays.asList(
//      new OperationApp("Generate test data", this::fillWithTestData),
//      new OperationApp("Display all families", this::printFamilyList),
//      new OperationApp("Display families who have more than the desired number of members", this::printFamiliesBiggerThan),
//      new OperationApp("Display families who have less than the desired number of members", this::privateFamiliesLessThan),
//      new OperationApp("Count the amount of families who have a specific number of member", this::printCountFamiliesWithMemberNumber),
//      new OperationApp("Create new family", this::createNewFamily),
//      new OperationApp("Delete a family by it's index", this::removeFamilyByIndex),
//      new OperationApp("Edit a family by it's index", this::editFamilyByIndex),
//      new OperationApp("Delete all childs older than a specific age", this::deleteAllChildrenOlderThen),
//      new OperationApp("Exit the app", this::exitTheApplication)
//    );
//
//    editFamilyCommand = Arrays.asList(
//      new OperationApp("Born a child", this::bornChild),
//      new OperationApp("Adopt a child", this::adoptChild),
//      new OperationApp("Go back to main menu", this::returnToMainMenu)
//    );
  }
}
