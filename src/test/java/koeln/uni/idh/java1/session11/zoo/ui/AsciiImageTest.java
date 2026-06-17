package koeln.uni.idh.java1.session11.zoo.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;

import koeln.uni.idh.java1.session11.zoo.animals.Alpaca;
import org.junit.jupiter.api.Test;

class AsciiImageTest {

  @Test
  void createsEmptyImageWithExpectedSize() {
    AsciiImage image = new AsciiImage(3, 2);

    assertEquals(3, image.width());
    assertEquals(2, image.height());
    assertEquals("...\n...\n", image.toString());
  }

  @Test
  void writesBlackPixelAndAnimalSymbol() {
    AsciiImage image = new AsciiImage(3, 2);

    image.dot(1, 0);
    image.dot(2, 1, new Alpaca());

    assertEquals(".#.\n..A\n", image.toString());
  }
}
