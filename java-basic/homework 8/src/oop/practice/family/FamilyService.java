package oop.practice.family;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class FamilyService extends FamilyCollection{


public  boolean familiesExist () {
 return (getAllFamilies().size() > 0);
}

 public void displayFamilies(List<Family> families) {

    if(!familiesExist()) {
      System.out.println("No families to display");
    }
    for (int i = 0; i < families.size(); i++) {
      System.out.printf("{Family index %d : {%s}}, ", i , families.get(i).toString());
    }
  }
public  void displayAllFamilies() {
   displayFamilies(getAllFamilies());
  }

  public List<Family> getFamiliesBiggerThan(int size) {
    if(size < 2) {
      System.out.println("All families  have at least 2 members");
      displayAllFamilies();
      return  getAllFamilies();
    }  else {
      List<Family> biggerFamilies = getAllFamilies().stream().
        filter(family -> family.getChildren().size() > (size - 2)).collect(Collectors.toList());
      displayFamilies(biggerFamilies);
      return biggerFamilies;
    }

  }
  public List<Family> getFamiliesLessThan(int size) {
    if(size <= 3) {
      System.out.println("All families  have at least 2 members");
      return  getAllFamilies();
    }  else {
      List<Family> smallerFamilies = getAllFamilies().stream().
        filter(family -> family.getChildren().size() < (size - 2)).collect(Collectors.toList());
      displayFamilies(smallerFamilies);
      return smallerFamilies;
    }
  }

 public long countFamiliesWithMemberNumber (int size) {
     if(size == 2) {
      return getAllFamilies().stream().filter(family ->
        family.getChildren().size() == 0).count();
   } else {
     return   getAllFamilies().stream().
         filter(family -> family.getChildren().size() == (size - 2)).count();
     }

  }

 public void createNewFamily (Human father, Human mother) {
    Family family = new Family(mother, father);
    getAllFamilies().add(family);
  }

 public void deleteFamilyByIndex (int index) {
    getAllFamilies().remove(index);
  }
public Family bornChild (Family family, String maleName, String femaleName) {

    double childRandomizer = Math.random();
    if (childRandomizer < 0.5) {
      Man man = new Man(maleName, family.getFather().getSurname());
      family.addChild(man);
    } else {
      Woman woman = new Woman(femaleName, family.getFather().getSurname());
      family.addChild(woman);
    }
    return family;
}

public Family adoptChild (Family family, Human human) {
    family.addChild(human);
    return family;
}

public void deleteAllChildrenOlderThan (int age) {
    getAllFamilies().stream().forEach(family -> {
    List<Human> youngChildren = family.getChildren().stream().
        filter(children -> (Calendar.getInstance().get(Calendar.YEAR) - children.getYear()) > age).collect(Collectors.toList());
    youngChildren.stream().forEach(child -> family.deleteChild(child));
    });
}

public int count() {
   return getAllFamilies().size();
}
public Family getFamilyById (int id) {
    return getAllFamilies().get(id);
}

public HashSet<Pet> getPets (int familyIndex) {
  return getAllFamilies().get(familyIndex).getPet();
  }

  void addPet (int familyIndex , Pet pet) {
    getAllFamilies().get(familyIndex).addPet(pet);
  }
}
