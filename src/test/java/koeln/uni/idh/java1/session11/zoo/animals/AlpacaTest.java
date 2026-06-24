package koeln.uni.idh.java1.session11.zoo.animals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AlpacaTest {

    private Alpaca alpaca;

    @BeforeEach
    public void setUp() {
        alpaca = new Alpaca();
    }

    @Test
    public void testGetSymbol() {
        assertEquals('A', alpaca.getSymbol());
    }

    @Test
    public void testInitialX() {
        assertEquals(1, alpaca.getX());
    }

    @Test
    public void testInitialY() {
        assertEquals(1, alpaca.getY());
    }

    @Test
    public void testWalkNorth() {
        // Default direction is 0 (north); walking decreases y by stepsize (1)
        alpaca.walk();
        assertEquals(0, alpaca.getY());
        assertEquals(1, alpaca.getX());
    }

    @Test
    public void testTurnRightThenWalkEast() {
        // turn(1) sets direction to 90 (east); walking increases x by stepsize (1)
        alpaca.turn(1);
        alpaca.walk();
        assertEquals(2, alpaca.getX());
        assertEquals(1, alpaca.getY());
    }

    @Test
    public void testSetAndGetX() {
        alpaca.setX(5);
        assertEquals(5, alpaca.getX());
    }

    @Test
    public void testSetAndGetY() {
        alpaca.setY(3);
        assertEquals(3, alpaca.getY());
    }
}
