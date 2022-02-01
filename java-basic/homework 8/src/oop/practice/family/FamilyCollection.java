package oop.practice.family;

import java.util.ArrayList;
import java.util.List;

public class FamilyCollection implements FamilyDao{

private List<Family> families = new ArrayList<>();



  @Override
  public List<Family> getAllFamilies() {
    return families;
  }

  @Override
  public Family getFamilyByIndex(int index) {
    return families.get(index);
  }

  @Override
  public boolean deleteFamily(int index) {
    if(families.toArray().length == 0 || index > families.toArray().length -1 || index < 0) {
      return false;
    }
    families.remove(index);
    return true;

  }

  @Override
  public boolean deleteFamily(Family family) {
    return families.remove(family);
  }

  @Override
  public void saveFamily(Family family) {
    if (families.size() > 1 && families.contains(family)) {
     int replaceIndex =  families.indexOf(family);
     families.set(replaceIndex, family);
    } else {
      families.add(family);
    }

  }


}
