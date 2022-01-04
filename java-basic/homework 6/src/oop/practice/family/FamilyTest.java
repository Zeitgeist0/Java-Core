package oop.practice.family;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FamilyTest {
  private Family family;
  private Man man1;
  private Woman woman1;
  private Man man2;
  private Woman woman2;
  private DomesticCat domesticCat;
  @BeforeEach
  void setUp() {
    man1 = new Man("John", "Doe", 1997, 106);
    woman1 = new Woman("Margot" , "Robbie", 1985, 120);
    man2 = new Man("Lisa", "Simpson", 1990, 145);
    woman2 = new Woman("Bart", "Simpson", 1990,65 );
    domesticCat = new DomesticCat( "Bubi", 5,90);
    family = new Family(woman1, man1);
  }
  @AfterEach
  void tearDown () {
    family = null;
    man1 = null;
    woman1 = null;
    man2 = null;
    woman2 = null;
    domesticCat = null;
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
    family.addChild(man2);
    assertEquals(initialChilds + 1, family.getChildren().length );
  }
  @Test
  public void theCorrectChildIsAddedToTheArray () {
    family.addChild(man2);
    Human[] childsArray = family.getChildren();
    assertEquals(man2, childsArray[family.getChildren().length - 1]);
  }


@Test
  public void childIsDeletedWhenPassingValidIndex() {
    int validRemoveIndex = 1;
    family.addChild(man2);
    family.addChild(woman2);
  assertTrue(family.deleteChild(validRemoveIndex));
    Human[] childsArray = family.getChildren();
  assertNotEquals(woman2, childsArray[validRemoveIndex - 1]);

}
  @Test
  public void childIsNotDeletedWhenPassingNotExistingIndex() {
    int invalidRemoveIndex = 5;
    int actualChildIndex = 1;
    family.addChild(man2);
    family.addChild(woman2);
    int initialChildsLength = family.getChildren().length;
    assertFalse(family.deleteChild(invalidRemoveIndex));
    Human[] childsArray = family.getChildren();
    int finalChildsLength = family.getChildren().length;
    assertEquals(woman2, childsArray[actualChildIndex]);
    assertEquals(initialChildsLength, finalChildsLength);
  }
  @Test
  public void childIsDeletedWhenPassingExistingChild() {
    family.addChild(man2);
    family.addChild(woman2);
    int initialChildsLength = family.getChildren().length;
    assertTrue(family.deleteChild(woman2));
    int finalChildsLength = family.getChildren().length;
    assertNotEquals(initialChildsLength, finalChildsLength);
  }
  @Test
  public void childIsNotDeletedWhenPassingNotExistingChild() {
    family.addChild(man2);
    family.addChild(woman2);
    int initialChildsLength = family.getChildren().length;
    assertFalse(family.deleteChild(man1));
    int finalChildsLength = family.getChildren().length;
    assertEquals(initialChildsLength, finalChildsLength);
  }
  @Test
  public void childsAreProperlyCounted() {
    int initialChildsLength = family.getChildren().length;
    family.addChild(man2);
    family.addChild(woman2);
    int finalChildsLength = family.getChildren().length;
    assertEquals(finalChildsLength, family.countFamily());
    assertEquals(initialChildsLength + 2, family.countFamily());
    assertNotEquals(initialChildsLength, family.countFamily());
  }

}