package family;


import human.*;
import pet.*;

import java.util.HashSet;
import java.util.List;


public class FamilyController {
  private final FamilyService familyService;

  public FamilyController(FamilyService familyService) {
    this.familyService = familyService;
  }

  public List<Family> getAllFamilies() {
    return familyService.getAllFamilies();
  }

  public boolean familiesExist() {
    return familyService.familiesExist();
  }

  public void displayFamilies(List<Family> families) {
    familyService.displayFamilies(families);
  }

  public void displayAllFamilies() {
    familyService.displayAllFamilies();
  }

  public Family getFamilyByIndex(int index) {
    return familyService.getFamilyByIndex(index);
  }

  public List<Family> getFamiliesBiggerThan(int size) {
    return familyService.getFamiliesBiggerThan(size);
  }

  public List<Family> getFamiliesLessThan(int size) {
    return familyService.getFamiliesLessThan(size);
  }

  public long countFamiliesWithMemberNumber(int size) {
    return familyService.countFamiliesWithMemberNumber(size);
  }

  public void createNewFamily(Human father, Human mother) {
    familyService.createNewFamily(father, mother);
  }

  public void saveFamily(Family family) {
    familyService.saveFamily(family);
  }

  public boolean deleteFamily(int index) {
    return familyService.deleteFamily(index);
  }

  public boolean deleteFamily(Family family) {
    return familyService.deleteFamily(family);
  }

  public Family bornChild(Family family, String maleName, String femaleName) {
    return familyService.bornChild(family, maleName, femaleName);
  }

  public Family adoptChild(Family family, Human human) {
    return familyService.adoptChild(family, human);
  }

  public Family bornChild(int index, String maleName, String femaleName) {
    return familyService.bornChild(index, maleName, femaleName);
  }

  public Family adoptChild(int index, Human human) {
    return familyService.adoptChild(index, human);
  }

  public void deleteAllChildrenOlderThan(int age) {
    familyService.deleteAllChildrenOlderThan(age);
  }

  public int count() {
    return familyService.count();
  }

  public Family getFamilyById(int id) {
    return familyService.getFamilyById(id);
  }

  public HashSet<Pet> getPets(int familyIndex) {
    return familyService.getPets(familyIndex);
  }

  public void addPet(int familyIndex, Pet pet) {
    familyService.addPet(familyIndex, pet);
  }


}
