package koeln.uni.idh.java1.session11.zoo.ui;

import koeln.uni.idh.java1.session11.zoo.animals.Alpaca;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AsciiImageTest {

    private AsciiImage image;

    @BeforeEach
    public void setUp() {
        image = new AsciiImage(10, 5);
    }

    @Test
    public void testWidth() {
        assertEquals(10, image.width());
    }

    @Test
    public void testHeight() {
        assertEquals(5, image.height());
    }

    @Test
    public void testInitialToStringContainsOnlyDots() {
        String result = image.toString();
        // All pixels should be '.' initially; image has 5 rows of 10 dots each
        assertTrue(result.replace("\n", "").chars().allMatch(c -> c == '.'));
    }

    @Test
    public void testDotPaintsBlackPixel() {
        image.dot(3, 2);
        String result = image.toString();
        String[] lines = result.split("\n");
        assertEquals('#', lines[2].charAt(3));
    }

    @Test
    public void testDotWithWalkingMammal() {
        Alpaca alpaca = new Alpaca();
        image.dot(4, 1, alpaca);
        String result = image.toString();
        String[] lines = result.split("\n");
        assertEquals('A', lines[1].charAt(4));
    }

    @Test
    public void testToStringLineSeparators() {
        String result = image.toString();
        // Each row ends with a newline; 5 rows => 5 newlines
        long newlineCount = result.chars().filter(c -> c == '\n').count();
        assertEquals(5, newlineCount);
    }

    @Test
    public void testDotDoesNotAffectOtherPixels() {
        image.dot(0, 0);
        String result = image.toString();
        String[] lines = result.split("\n");
        // Only pixel (0,0) should be '#', everything else '.'
        for (int row = 0; row < lines.length; row++) {
            for (int col = 0; col < lines[row].length(); col++) {
                if (row == 0 && col == 0) {
                    assertEquals('#', lines[row].charAt(col));
                } else {
                    assertEquals('.', lines[row].charAt(col));
                }
            }
        }
    }
}
