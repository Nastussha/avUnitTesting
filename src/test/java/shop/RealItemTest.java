package shop;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RealItemTest {
    private RealItem realItem;

    @BeforeEach
    public void setUp() {
        realItem = new RealItem();
    }

    @Test
    void toStringTest() {
        assertEquals("Class: class shop.RealItem; Name: null; Price: 0.0; Weight: 0.0",
                realItem.toString());
    }

    @AfterEach
    public void tearDown() {
        realItem = null;
    }
}
