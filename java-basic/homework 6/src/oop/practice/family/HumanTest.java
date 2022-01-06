package oop.practice.family;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

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
    HashMap<String, String> schedule = new HashMap<>();
    schedule.put(DayOfWeek.FRIDAY.getName(), Tasks.GO_TO_CINEMA.getName());
    schedule.put( DayOfWeek.MONDAY.getName(),Tasks.WORKOUT.getName() );
    human.setSchedule(schedule);
    assertEquals("Human{name='John', surname='Doe', year=1997, iq=105, schedule='{Monday=Workout, Friday=Go to the cinema}'}", human.toString().trim());
  }
}