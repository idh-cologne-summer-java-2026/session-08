package koeln.uni.idh.java1.session11.zoo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TreeTest {

    @Test
    public void testGetSymbol() {
        Tree tree = new Tree();
        assertEquals('T', tree.getSymbol());
    }
}
