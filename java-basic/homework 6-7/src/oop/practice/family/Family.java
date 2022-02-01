package oop.practice.family;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Family {
  private Human mother;
  private Human father;
  private List<Human> children;
  private HashSet<Pet> pet;

  public Family(Human mother, Human father) {
    this.mother = mother;
    this.father = father;
    this.children = new ArrayList<>();
    this.pet = new HashSet<>();
    mother.setFamily(this);
    father.setFamily(this);
  }

  public Family() {

  }

  public void addChild (Human child) {
    this.children.add(child);
    child.setFamily(this);
  }

  public boolean deleteChild(int removeIndex) {
    if(this.children.toArray().length == 0 || removeIndex > this.children.toArray().length -1 || removeIndex < 0) {
      return false;
    }
    this.children.remove(removeIndex);
    return true;
  }

  public boolean deleteChild (Human human) {
   return  this.children.remove(human);
  }

  public int countFamily () {
  System.out.printf("This family has 2 parents, and %d children %n" ,  this.children.size());
  return this.children.size();
}
public void addPet (Pet newPet) {
    pet.add(newPet);
}
  public boolean hasPet () {
  return this.pet != null;
}

  public Pet findPet (Pet pet) {
    return getPet().stream().filter(pet::equals).findAny().orElse(null);
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Family family = (Family) o;
    return mother.equals(family.mother) && father.equals(family.father);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mother, father);
  }

  @Override
public String toString() {
    if(hasPet()) {
      return String.format("Family{%s, %s, %s, %s}",
        mother.toString(), father.toString(), children, pet.toString());
    }

  return String.format("Family{%s, %s, %s}",
    mother.toString(), father.toString(), children);


}

  @Override
  protected void finalize() throws Throwable {
    System.out.println(this.toString());
    super.finalize();
  }
  public Human getMother() {
    return mother;
  }

  public void setMother(Human mother) {
    this.mother = mother;
  }

  public Human getFather() {
    return father;
  }

  public void setFather(Human father) {
    this.father = father;
  }

  public List<Human> getChildren() {
    return children;
  }

  public void setChildren(List<Human> children) {
    this.children = children;
  }

  public HashSet<Pet> getPet() {
    return pet;
  }

  public void setPet(HashSet<Pet> pet) {
    this.pet = pet;
  }
}
