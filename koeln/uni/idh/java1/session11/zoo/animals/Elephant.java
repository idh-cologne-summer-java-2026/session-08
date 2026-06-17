package koeln.uni.idh.java1.session11.zoo.animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Elephant extends WalkingMammal {
  private static Random random = new Random();
  private String name;

  public Elephant() {
    this.name = "Elephant";
  }

  public Elephant(String name) {
    this.name = name;
  }

  /**
   * Two elephants mate and create a random number of children (1-2).
   * Elephants typically have fewer offspring than horses.
   * 
   * @param partner The partner elephant
   * @param enclWidth The width of the enclosure
   * @param enclHeight The height of the enclosure
   * @return A list of newly born elephants
   */
  public List<Elephant> mate(Elephant partner, int enclWidth, int enclHeight) {
    List<Elephant> children = new ArrayList<>();
    int numChildren = random.nextInt(2) + 1; // 1-2 children
    
    for (int i = 0; i < numChildren; i++) {
      Elephant child = new Elephant("Child of " + this.name + " and " + partner.name);
      child.setX(random.nextInt(enclWidth));
      child.setY(random.nextInt(enclHeight));
      children.add(child);
    }
    return children;
  }

  @Override
  public char getSymbol() {
    return 'E';
  }

}
