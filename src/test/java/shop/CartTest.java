package shop;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CartTest {
    private Cart cart1, cart2;
    private RealItem realItem;
    private VirtualItem virtualItem;

    @BeforeEach
    public void setUp() {
        cart1 = new Cart("TestCart1");
        cart2 = new Cart("TestCart2");
        realItem = new RealItem();
        virtualItem = new VirtualItem();
        realItem.setPrice(2500);
        virtualItem.setPrice(2000);
        cart1.addRealItem(realItem);
        cart2.addVirtualItem(virtualItem);
    }

    @Test
    void getTotalPrice() {
        assertAll("Should return correct cart total for Real and Virtual item",
                () -> assertEquals(3000, cart1.getTotalPrice()),
                () -> assertEquals(2400, cart2.getTotalPrice())
        );
    }

    @Test
    void deleteRealItem(){
        cart1.deleteRealItem(realItem);
        assertEquals(0, cart1.getTotalPrice());
    }

    @AfterEach
    public void tearDown() {
        cart1 = null;
        cart2 = null;
    }
}
