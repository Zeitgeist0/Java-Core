package family;

import human.*;

import pet.*;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class FamilyService {
  private final FamilyDao familyDao;

  public FamilyService(FamilyDao familyDao) {
    this.familyDao = familyDao;
  }

  public boolean familiesExist() {
    return (familyDao.getAllFamilies().size() > 0);
  }

  public void displayFamilies(List<Family> families) {

    if (!familiesExist()) {
      System.out.println("No families to display");
    }
//    families.forEach(family -> {
//      System.out.printf("Family index %d :%n %s%n", families.indexOf(family), family.toPrettyFormat());
//    });
    for (int i = 0; i < families.size(); i++) {
      System.out.printf("Family index %d :%n %s%n", i, families.get(i).toPrettyFormat());
    }
  }

  public void displayAllFamilies() {
    displayFamilies(familyDao.getAllFamilies());
  }

  public List<Family> getAllFamilies() {
    return familyDao.getAllFamilies();
  }

  public Family getFamilyByIndex(int index) {
    return familyDao.getFamilyByIndex(index);
  }

  public List<Family> getFamiliesBiggerThan(int size) {
    if (size < 2) {
      System.out.println("All families  have at least 2 members5");
      return familyDao.getAllFamilies();
    } else {
      return familyDao.getAllFamilies().stream().
        filter(family -> family.getChildren().size() > (size - 2)).collect(Collectors.toList());
    }

  }

  public List<Family> getFamiliesLessThan(int size) {
    if (size <= 3) {
      System.out.println("All families  have at least 2 members");
      return familyDao.getAllFamilies();
    } else {
      return familyDao.getAllFamilies().stream().
        filter(family -> family.getChildren().size() < (size - 2)).collect(Collectors.toList());
    }
  }

  public long countFamiliesWithMemberNumber(int size) {
    if (size == 2) {
      return familyDao.getAllFamilies().stream().filter(family ->
        family.getChildren().size() == 0).count();
    } else {
      return familyDao.getAllFamilies().stream().
        filter(family -> family.getChildren().size() == (size - 2)).count();
    }
  }

  public void createNewFamily(Human father, Human mother) {
    Family family = new Family(mother, father);
    familyDao.saveFamily(family);
  }

  public void saveFamily(Family family) {
    familyDao.saveFamily(family);
  }

  public boolean deleteFamily(int index) {
    return familyDao.deleteFamily(index);
  }

  public boolean deleteFamily(Family family) {
    return familyDao.deleteFamily(family);
  }

  public Family bornChild(Family family, String maleName, String femaleName) {
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

  public Family bornChild(int index, String maleName, String femaleName) {
    double childRandomizer = Math.random();
    if (childRandomizer < 0.5) {
      Man man = new Man(maleName, getFamilyByIndex(index).getFather().getSurname());
      getFamilyByIndex(index).addChild(man);
    } else {
      Woman woman = new Woman(femaleName, getFamilyByIndex(index).getFather().getSurname());
      getFamilyByIndex(index).addChild(woman);
    }
    return getFamilyByIndex(index);
  }

  public Family adoptChild(Family family, Human human) {
    family.addChild(human);
    return family;
  }

  public Family adoptChild(int index, Human human) {
    getFamilyByIndex(index).addChild(human);
    return getFamilyByIndex(index);
  }

  public void deleteAllChildrenOlderThan(int age) {
    familyDao.getAllFamilies().forEach(family -> {
      List<Human> youngChildren = family.getChildren().stream().
        filter(children -> (Calendar.getInstance().get(Calendar.YEAR) - children.getBirthDate()) > age).collect(Collectors.toList());
      youngChildren.forEach(family::deleteChild);
    });
  }

  public int count() {
    return familyDao.getAllFamilies().size();
  }

  public Family getFamilyById(int id) {
    return familyDao.getAllFamilies().get(id);
  }

  public HashSet<Pet> getPets(int familyIndex) {
    return familyDao.getAllFamilies().get(familyIndex).getPet();
  }

  void addPet(int familyIndex, Pet pet) {
    familyDao.getAllFamilies().get(familyIndex).addPet(pet);
  }


}
