package koeln.uni.idh.java1.session11.zoo.animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Horse extends WalkingMammal {
static int numberOfHorses = 0;
private static Random random = new Random();

/**
 * How many "fields" does the horse move if it takes a single step?
 */
int stepsize = 1;

/**
 * The name of the horse
 */
String name;

/**
 * The color of the horse's fur
 */
String color;

/**
 * Horses need to have a name and a fur color. There is no technical reason
 * here, it just shows some variation of constructors.
 * 
 * @param name
 * @param color
 */
public Horse(String name, String color) {
numberOfHorses++;
this.name = name;
this.color = color;
}

/**
 * Two horses mate and create a random number of children (1-3).
 * 
 * @param partner The partner of the current horse
 * @param enclWidth The width of the enclosure
 * @param enclHeight The height of the enclosure
 * @return A list of newly born horses
public List<Horse> mate(Horse partner, int enclWidth, int enclHeight) {
List<Horse> children = new ArrayList<>();
int numChildren = random.nextInt(3) + 1; // 1-3 children

for (int i = 0; i < numChildren; i++) {
Horse child = new Horse("Child of " + this.name + " and " + partner.name,
mixFurColors(this.color, partner.color));
child.setX(random.nextInt(enclWidth));
child.setY(random.nextInt(enclHeight));
children.add(child);
}
return children;
}

private String mixFurColors(String fur1, String fur2) {
if (fur1.equals("black") || fur2.equals("black"))
return "black";
if (fur1.equals("brown"))
return fur2 + "-" + fur1;
return fur1 + "-" + fur2;
}

@Override
public char getSymbol() {
return 'H';
}



}
