import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ProductTest
{
    Product p1, p2;
    @BeforeEach
    void setup(){
        p1 = new Product("0001", "prod1", "this is prod 1 desc", 90.2);
        p2 = new Product("0002", "prod2", "this is prod 2 desc", 20.4);
    }
    @Test
    void setName(){
        p1.setName("bob");
        assertEquals("bob", p1.getName());
    }
    @Test
    void setDesc(){
        p1.setDescription("hello");
        assertEquals("hello", p1.getDescription());
    }
    @Test
    void setcost(){
        p1.setCost(30.2);
        assertEquals(30.2, p1.getCost());
    }

}
