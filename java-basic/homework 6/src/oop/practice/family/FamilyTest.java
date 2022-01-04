package oop.practice.family;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FamilyTest {
  private Family family;
  private Human human1;
  private Human human2;
  private Human human3;
  private Human human4;
  private Pet pet;
  @BeforeEach
  void setUp() {
    human1 = new Human("John", "Doe", 1997, 106);
    human2 = new Human("Margot" , "Robbie", 1985, 120);
    human3 = new Human("Lisa", "Simpson", 1990, 145);
    human4 = new Human("Bart", "Simpson", 1990,65 );
//    pet = new Pet(Species.BIRD, "Bubi", 5,90);
    family = new Family(human2, human1);
  }
  @AfterEach
  void tearDown () {
    family = null;
    human1 = null;
    human2 = null;
    human3 = null;
    human4 = null;
    pet = null;
  }

//  @Test
//  public void completeToString () {
//    System.out.println(family.toString().trim());
//    assertEquals("Family{Human{name='Margot', surname='Robbie', year=1985, iq=120, schedule='null'} \n" +
//        " , Human{name='John', surname='Doe', year=1997, iq=106, schedule='null'} \n" +
//        " , []}",
//      family.toString().trim());
//  }

  @Test
  public void anElementIsAddedToTheChildrensArray () {
    int initialChilds = family.getChildren().length;
    family.addChild(human3);
    assertEquals(initialChilds + 1, family.getChildren().length );
  }
  @Test
  public void theCorrectChildIsAddedToTheArray () {
    family.addChild(human3);
    Human[] childsArray = family.getChildren();
    assertEquals(human3, childsArray[family.getChildren().length - 1]);
  }


@Test
  public void childIsDeletedWhenPassingValidIndex() {
    int validRemoveIndex = 1;
    family.addChild(human3);
    family.addChild(human4);
  assertTrue(family.deleteChild(validRemoveIndex));
    Human[] childsArray = family.getChildren();
  assertNotEquals(human4, childsArray[validRemoveIndex - 1]);

}
  @Test
  public void childIsNotDeletedWhenPassingNotExistingIndex() {
    int invalidRemoveIndex = 5;
    int actualChildIndex = 1;
    family.addChild(human3);
    family.addChild(human4);
    int initialChildsLength = family.getChildren().length;
    assertFalse(family.deleteChild(invalidRemoveIndex));
    Human[] childsArray = family.getChildren();
    int finalChildsLength = family.getChildren().length;
    assertEquals(human4, childsArray[actualChildIndex]);
    assertEquals(initialChildsLength, finalChildsLength);
  }
  @Test
  public void childIsDeletedWhenPassingExistingChild() {
    family.addChild(human3);
    family.addChild(human4);
    int initialChildsLength = family.getChildren().length;
    assertTrue(family.deleteChild(human4));
    int finalChildsLength = family.getChildren().length;
    assertNotEquals(initialChildsLength, finalChildsLength);
  }
  @Test
  public void childIsNotDeletedWhenPassingNotExistingChild() {
    family.addChild(human3);
    family.addChild(human4);
    int initialChildsLength = family.getChildren().length;
    assertFalse(family.deleteChild(human1));
    int finalChildsLength = family.getChildren().length;
    assertEquals(initialChildsLength, finalChildsLength);
  }
  @Test
  public void childsAreProperlyCounted() {
    int initialChildsLength = family.getChildren().length;
    family.addChild(human3);
    family.addChild(human4);
    int finalChildsLength = family.getChildren().length;
    assertEquals(finalChildsLength, family.countFamily());
    assertEquals(initialChildsLength + 2, family.countFamily());
    assertNotEquals(initialChildsLength, family.countFamily());
  }

}