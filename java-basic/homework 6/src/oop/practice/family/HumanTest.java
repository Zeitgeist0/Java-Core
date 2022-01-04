package oop.practice.family;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HumanTest {
  private Human human;
  @BeforeEach
  void setUp() {
     human = new Human("John", "Doe", 1997, 105);
  }
  @AfterEach
  void tearDown () {
   human = null;
  }
@Test
   public void toStringWithoutSchedule() {
 assertEquals("Human{name='John', surname='Doe', year=1997, iq=105, schedule='null'}", human.toString().trim());
}
  @Test
  public void toStringWithSchedule() {
    String[][] schedule = new String[2][2];
    schedule[0][0] = DayOfWeek.FRIDAY.getName();
    schedule[0][1] = Tasks.GO_TO_CINEMA.getName();
    schedule[1][0] = DayOfWeek.MONDAY.getName();
    schedule[1][1] = Tasks.WORKOUT.getName();
    human.setSchedule(schedule);
    assertEquals("Human{name='John', surname='Doe', year=1997, iq=105, schedule='[[Friday, Go to the cinema], [Monday, Workout]]'}", human.toString().trim());
  }
}