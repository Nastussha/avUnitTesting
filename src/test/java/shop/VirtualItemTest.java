package shop;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VirtualItemTest {
    private VirtualItem virtualItem;

    @BeforeEach
    public void setUp() {
        virtualItem = new VirtualItem();
    }

    @Test
    void toStringTest() {
        assertEquals("Class: class shop.VirtualItem; Name: null; Price: 0.0; Size on disk: 0.0",
                virtualItem.toString());
    }

    @AfterEach
    public void tearDown() {
        virtualItem = null;
    }
}
