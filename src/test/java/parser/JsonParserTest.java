package parser;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import shop.Cart;
import shop.RealItem;

import java.io.File;

import static org.apiguardian.api.API.Status.EXPERIMENTAL;
import static org.junit.jupiter.api.Assertions.*;

public class JsonParserTest {
    private Parser parser;
    Cart nastyaCart = new Cart("nastya-cart");
    RealItem car = new RealItem();
    File file;

    @BeforeEach
    public void setUp() {
        parser = new JsonParser();

    }

    @Test
    void writeToFile() {
        file = new File("src/main/resources/nastya-cart.json");
        car.setName("Audi");
        car.setPrice(32026.9);
        car.setWeight(1560);
        nastyaCart.addRealItem(car);
        parser.writeToFile(nastyaCart);
        assertTrue(file.exists(), "File exists");
    }

    @Disabled
    void readFromFile_NotNull() {
        assertNotNull(parser.readFromFile(new File("src/main/resources/eugen-cart.json")));
    }


    @ParameterizedTest
    @ValueSource(strings = { "src/main/resources/eugen.json",
            "src/main/resources/andrew.json",
            "src/main/resources/andrew1.json",
            "src/main/resources/andrew2.json",
            "src/main/resources/andrew3.json"})
    void readFromFile_NoSuchFileException(String pathName) {
        Exception exception = assertThrows(Exception.class,
                () -> parser.readFromFile(new File(pathName)));
        assertEquals("File "+ pathName + ".json not found!", exception.getMessage());
    }

    @AfterEach
    public void tearDown() {
        parser = null;
        if (file != null){
            file.delete();
        }
    }

}
