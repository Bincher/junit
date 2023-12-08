import static org.junit.Assert.*;
import org.junit.Test;

public class ProductSpecificationTest {

    @Test
    public void testProductSpecification() {
        // Prepare test data
        ItemID itemId = new ItemID(100);
        Money price = new Money(3);
        String description = "Product Test";

        // Create ProductSpecification
        ProductSpecification productSpecification = new ProductSpecification(itemId, price, description);

        // Test methods
        assertEquals(itemId, productSpecification.getltemlD());
        assertEquals(price, productSpecification.getPrice());
        assertEquals(description, productSpecification.getDescription());
    }
}
