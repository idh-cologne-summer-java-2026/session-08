package koeln.uni.idh.java1.session11.zoo;

import java.util.ArrayList;
import java.util.List;

import koeln.uni.idh.java1.session11.zoo.animals.Alpaca;
import koeln.uni.idh.java1.session11.zoo.animals.Elephant;
import koeln.uni.idh.java1.session11.zoo.animals.Horse;
import koeln.uni.idh.java1.session11.zoo.animals.WalkingMammal;
import koeln.uni.idh.java1.session11.zoo.ui.AsciiImage;

public class Main {

public static void main(String[] args) {
int width = 15;
int height = 10;

// Create an enclosure and add animals
List<WalkingMammal> animals = new ArrayList<>();

// Create horses
Horse horse1 = new Horse("Spirit", "brown");
Horse horse2 = new Horse("Thunder", "black");
horse1.setX(2);
horse1.setY(2);
horse2.setX(8);
horse2.setY(3);
animals.add(horse1);
animals.add(horse2);

// Create alpacas
Alpaca alpaca1 = new Alpaca("Alpie");
Alpaca alpaca2 = new Alpaca("Fuzz");
alpaca1.setX(5);
alpaca1.setY(5);
alpaca2.setX(10);
alpaca2.setY(7);
animals.add(alpaca1);
animals.add(alpaca2);

// Create elephants
Elephant elephant1 = new Elephant("Dumbo");
Elephant elephant2 = new Elephant("Ellie");
elephant1.setX(3);
elephant1.setY(8);
elephant2.setX(12);
elephant2.setY(2);
animals.add(elephant1);
animals.add(elephant2);

System.out.println("Initial enclosure:");
displayEnclosure(animals, width, height);

// Horses mate
System.out.println("\nHorses mating...");
List<Horse> horseChildren = horse1.mate(horse2, width, height);
System.out.println("Horses produced " + horseChildren.size() + " children.");
animals.addAll(horseChildren);

// Alpacas mate
System.out.println("\nAlpacas mating...");
List<Alpaca> alpacaChildren = alpaca1.mate(alpaca2, width, height);
System.out.println("Alpacas produced " + alpacaChildren.size() + " children.");
animals.addAll(alpacaChildren);

// Elephants mate
System.out.println("\nElephants mating...");
List<Elephant> elephantChildren = elephant1.mate(elephant2, width, height);
System.out.println("Elephants produced " + elephantChildren.size() + " children.");
animals.addAll(elephantChildren);

System.out.println("\nEnclosure after mating:");
displayEnclosure(animals, width, height);
}

private static void displayEnclosure(List<WalkingMammal> animals, int width, int height) {
AsciiImage image = new AsciiImage(width, height);
for (WalkingMammal animal : animals) {
image.dot(animal.getX(), animal.getY(), animal);
}
System.out.println(image.toString());
}

}
