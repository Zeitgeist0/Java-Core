import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BattleShip {
  public static void main(String[] args) {
    System.out.println("All set. Get ready to rumble!");
    runGame();
  }

  public static String[][] initField() {
    String[][] field = new String[5][5];
    for (String[] strings : field) {
      Arrays.fill(strings, "-");
    }
    return field;
  }

  public static void printField(String[][] field) {
    System.out.print("    ");
    for (int i = 0; i < field.length; i++) {
      System.out.print(i + 1 + " | ");
    }
    System.out.println();
    for (int i = 0; i < field.length; i++) {
      System.out.print(i + 1 + " | ");
      for (int j = 0; j < field[i].length; j++) {
        System.out.printf("%s | ", field[i][j]);
      }
      System.out.println();
    }
  }
  public static boolean isValid(String string) {
    int intValue;
    try {
      intValue = Integer.parseInt(string);
      if (intValue <= 0 || intValue > 5 ) {
        System.out.println("Please enter a number between 1 and 5");
        return false;
      }
      return true;
    } catch (NumberFormatException e) {
      System.out.println("Please enter a number");
    }
    return false;
  }
  public static void runGame() {
    String[][] field = initField();
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);
    int firstRandom = random.nextInt(6 - 1) +1 ;
    int secondRandom = random.nextInt(6 -1 ) +1;
    boolean didHit = false;
    while (!didHit) {
      printField(field);
      boolean correctInput = false;
      int column = 0;
      int row = 0;

      while(!correctInput) {
        System.out.println("Please select the column to fire");
        String userColumnInput = scanner.next();
        System.out.println("And now select the row to fire");
        String userRowInput = scanner.next();
        if(isValid(userColumnInput) && isValid(userRowInput)) {
          row = Integer.parseInt(userRowInput);

          column = Integer.parseInt(userColumnInput);

          correctInput = true;
        }
      }
      if ( column == firstRandom && row == secondRandom) {
        didHit = true;
        System.out.println("Congratulations, you did hit he boat");

      } else {
        --row;
        --column;
        field[column][row] = "*";
      }

    }
  }
}
