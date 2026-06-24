package koeln.uni.idh.java1.session11.zoo.animals;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HorseTest {

    @Test
    public void testGetSymbol() {
        Horse horse = new Horse("Thunderbolt", "brown");
        assertEquals('H', horse.getSymbol());
    }

    @Test
    public void testInitialX() {
        Horse horse = new Horse("Spirit", "white");
        assertEquals(1, horse.getX());
    }

    @Test
    public void testInitialY() {
        Horse horse = new Horse("Spirit", "white");
        assertEquals(1, horse.getY());
    }

    @Test
    public void testWalkNorth() {
        Horse horse = new Horse("Dusty", "grey");
        // Default direction is 0 (north); walking decreases y by stepsize (1)
        horse.walk();
        assertEquals(0, horse.getY());
        assertEquals(1, horse.getX());
    }

    @Test
    public void testTurnRightThenWalkEast() {
        Horse horse = new Horse("Blaze", "black");
        // turn(1) sets direction to 90 (east); walking increases x by stepsize (1)
        horse.turn(1);
        horse.walk();
        assertEquals(2, horse.getX());
        assertEquals(1, horse.getY());
    }

    @Test
    public void testMateChildName() {
        Horse parent1 = new Horse("Alpha", "white");
        Horse parent2 = new Horse("Beta", "brown");
        Horse child = parent1.mate(parent2);
        assertEquals("Child of Alpha and Beta", child.name);
    }

    @Test
    public void testMateChildFurColorBlackDominant() {
        Horse parent1 = new Horse("Dark", "black");
        Horse parent2 = new Horse("Pale", "white");
        Horse child = parent1.mate(parent2);
        assertEquals("black", child.color);
    }

    @Test
    public void testMateChildFurColorBrownMix() {
        // When first parent is brown: result is fur2 + "-" + fur1
        Horse parent1 = new Horse("Sandy", "brown");
        Horse parent2 = new Horse("Misty", "white");
        Horse child = parent1.mate(parent2);
        assertEquals("white-brown", child.color);
    }

    @Test
    public void testMateChildFurColorDefault() {
        // Neither black nor brown first: result is fur1 + "-" + fur2
        Horse parent1 = new Horse("Ivory", "white");
        Horse parent2 = new Horse("Silver", "grey");
        Horse child = parent1.mate(parent2);
        assertEquals("white-grey", child.color);
    }

    @Test
    public void testSetAndGetX() {
        Horse horse = new Horse("Scout", "brown");
        horse.setX(10);
        assertEquals(10, horse.getX());
    }

    @Test
    public void testSetAndGetY() {
        Horse horse = new Horse("Scout", "brown");
        horse.setY(8);
        assertEquals(8, horse.getY());
    }
}
