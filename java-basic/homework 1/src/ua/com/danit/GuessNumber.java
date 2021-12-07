package ua.com.danit;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
  public static void main(String[] args) {
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);
    int userNumber = 0;
    int randomNum = random.nextInt(100);
    System.out.println("Please enter your name");
    String userName = scanner.next();
    System.out.println("Let the game begin!");
    boolean userInputCorrect = false;
    while (!userInputCorrect) {
      System.out.println("Please enter your numberJ");
      String userInput = scanner.next();
      try {
        userNumber = Integer.parseInt(userInput);
      } catch (Exception e) {}

      if (userNumber < randomNum) {
        System.out.println("Your number is too small. Please, try again.");
      } else if (userNumber > randomNum) {
        System.out.println("Your number is too big. Please, try again.");
      } else {
        System.out.println("Congratulations " + userName + " you guessed the number");
        userInputCorrect = true;
      }
    }
  }
}
