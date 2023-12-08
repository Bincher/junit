import static org.junit.Assert.*;
import org.junit.Test;

public class ProductCatalogTest {

    @Test
    public void testGetSpecification() {
        // Prepare test data
        ProductCatalog productCatalog = new ProductCatalog();
        ItemID existingItemId = new ItemID(100);
        ItemID nonExistingItemId = new ItemID(300);

        // Test existing item
        ProductSpecification existingSpecification = productCatalog.getSpecification(existingItemId);
        assertNotNull("Existing specification should not be null", existingSpecification);
        assertEquals(existingItemId, existingSpecification.getltemlD());

        // Test non-existing item
        ProductSpecification nonExistingSpecification = productCatalog.getSpecification(nonExistingItemId);
        assertNull("Non-existing specification should be null", nonExistingSpecification);
    }
}
