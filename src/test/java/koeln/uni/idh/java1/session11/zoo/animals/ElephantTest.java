package koeln.uni.idh.java1.session11.zoo.animals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ElephantTest {

    private Elephant elephant;

    @BeforeEach
    public void setUp() {
        elephant = new Elephant();
    }

    @Test
    public void testGetSymbol() {
        assertEquals('E', elephant.getSymbol());
    }

    @Test
    public void testInitialX() {
        assertEquals(1, elephant.getX());
    }

    @Test
    public void testInitialY() {
        assertEquals(1, elephant.getY());
    }

    @Test
    public void testWalkNorth() {
        // Default direction is 0 (north); walking decreases y by stepsize (1)
        elephant.walk();
        assertEquals(0, elephant.getY());
        assertEquals(1, elephant.getX());
    }

    @Test
    public void testTurnRightThenWalkEast() {
        // turn(1) sets direction to 90 (east); walking increases x by stepsize (1)
        elephant.turn(1);
        elephant.walk();
        assertEquals(2, elephant.getX());
        assertEquals(1, elephant.getY());
    }

    @Test
    public void testSetAndGetX() {
        elephant.setX(7);
        assertEquals(7, elephant.getX());
    }

    @Test
    public void testSetAndGetY() {
        elephant.setY(4);
        assertEquals(4, elephant.getY());
    }
}
