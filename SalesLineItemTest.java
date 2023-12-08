import static org.junit.Assert.*;
import org.junit.Test;

public class SalesLineItemTest {

    @Test
    public void testSalesLineltem() {
        // Prepare test data
        ItemID itemId = new ItemID(100);
        Money price = new Money(3);
        ProductSpecification spec = new ProductSpecification(itemId, price, "product 1");

        // Create SalesLineltem
        SalesLineItem lineItem = new SalesLineItem(spec, 2);

        // Verify product specification
        assertEquals(spec, lineItem.getProductSpec());

        // Verify quantity
        assertEquals(2, lineItem.getQuantity());

        // Verify subtotal
        Money expectedSubtotal = price.times(2);
        assertEquals(expectedSubtotal, lineItem.getSubtotal());
    }
}