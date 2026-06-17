package koeln.uni.idh.java1.session11.zoo.animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Alpaca extends WalkingMammal {
private static Random random = new Random();
private String name;

public Alpaca() {
this.name = "Alpaca";
}

public Alpaca(String name) {
this.name = name;
}

/**
 * Two alpacas mate and create a random number of children (1-2).
 * Alpacas typically have one offspring per year.
 * 
 * @param partner The partner alpaca
 * @param enclWidth The width of the enclosure
 * @param enclHeight The height of the enclosure
 * @return A list of newly born alpacas
 */
public List<Alpaca> mate(Alpaca partner, int enclWidth, int enclHeight) {
List<Alpaca> children = new ArrayList<>();
int numChildren = random.nextInt(2) + 1; // 1-2 children

for (int i = 0; i < numChildren; i++) {
Alpaca child = new Alpaca("Child of " + this.name + " and " + partner.name);
child.setX(random.nextInt(enclWidth));
child.setY(random.nextInt(enclHeight));
children.add(child);
}
return children;
}

@Override
public char getSymbol() {
return 'A';
}

public void spit() {
System.out.println("Ein Alpaka spuckt.");
}
}
