package practice.family;

import java.util.Arrays;
import java.util.Objects;

public class Family {
  private Human mother;
  private Human father;
  private Human[] children;
  private Pet pet;

  public Family(Human mother, Human father) {
    this.mother = mother;
    this.father = father;
    this.children = new Human[0];
    mother.setFamily(this);
    father.setFamily(this);
  }

  public Family() {

  }

  public void addChild (Human child) {
    this.children = Arrays.copyOf(this.children, this.children.length + 1);
    this.children[this.children.length - 1] = child;
    child.setFamily(this);
  }

  public boolean deleteChild(int removeIndex) {
    if(this.children.length == 0 || removeIndex > this.children.length -1 || removeIndex < 0) {
      return false;
    }
    Human[] proxyArray = new Human[this.children.length - 1];
    for (int j = 0 , k = 0; j < this.children.length; j++) {
      if(j == removeIndex) {
        this.children[j].setFamily(null);
        continue;
      }
      proxyArray[k++] = this.children[j];
    }
    this.children = proxyArray;
    return true;
  }
public void countFamily () {
  System.out.printf("This family has 2 parents, and %d children %n" , children.length );
}

public boolean hasPet () {
  return this.pet != null;
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
        mother.toString(), father.toString(), Arrays.toString(children), pet.toString());
    }

  return String.format("Family{%s, %s, %s}",
    mother.toString(), father.toString(), Arrays.toString(children));


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

  public Human[] getChildren() {
    return children;
  }

  public void setChildren(Human[] children) {
    this.children = children;
  }

  public Pet getPet() {
    return pet;
  }

  public void setPet(Pet pet) {
    this.pet = pet;
  }
}
