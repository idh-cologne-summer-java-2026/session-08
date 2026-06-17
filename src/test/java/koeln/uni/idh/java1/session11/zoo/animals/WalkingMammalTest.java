package koeln.uni.idh.java1.session11.zoo.animals;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class WalkingMammalTest {

  @Test
  void walkMovesAnimalUpByDefault() {
    Alpaca alpaca = new Alpaca();
    alpaca.setX(4);
    alpaca.setY(5);

    alpaca.walk();

    assertEquals(4, alpaca.getX());
    assertEquals(4, alpaca.getY());
  }

  @Test
  void subclassesExposeExpectedSymbols() {
    assertEquals('A', new Alpaca().getSymbol());
    assertEquals('E', new Elephant().getSymbol());
    assertEquals('H', new Horse("Spirit", "brown").getSymbol());
  }
}
