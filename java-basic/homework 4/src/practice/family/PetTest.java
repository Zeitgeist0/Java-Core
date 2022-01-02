package practice.family;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PetTest {
  private Pet pet;
@BeforeEach
  void setUp() {
  pet = new Pet(Species.DOG, "Doge", 10, 78);
}
@AfterEach
  void tearDown () {
  pet = null;
}

@Test
  public void toStringWithoutHabits () {
assertEquals("DOG{nickname='Doge' , age=10, trickLevel=78, habits=[null]}", pet.toString().trim());
}
  @Test
  public void toStringWithHabits () {
    String[] habits = {"run", "jump", "bark"};
    pet.setHabits(habits);
    assertEquals("DOG{nickname='Doge' , age=10, trickLevel=78, habits=[[run, jump, bark]]}", pet.toString().trim());
  }

  @Test
  public void eat() {
   pet.eat();
  }
}