import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class SaleTest {

    private ProductCatalog catalog;
    private Sale sale;

    @Before
    public void setUp() {
        // Prepare test data
        catalog = new ProductCatalog();
        sale = new Sale();
    }

    @Test
    public void testSaleWorkflow() {
        // Prepare test data
        ItemID itemId1 = new ItemID(100);
        ItemID itemId2 = new ItemID(200);
        Money price = new Money(3);
        ProductSpecification spec1 = new ProductSpecification(itemId1, price, "product 1");
        ProductSpecification spec2 = new ProductSpecification(itemId2, price, "product 2");

        // Make line items
        SalesLineItem lineItem1 = new SalesLineItem(spec1, 2);
        SalesLineItem lineItem2 = new SalesLineItem(spec2, 3);

        // Add line items to the sale
        sale.makeLineltem(spec1, 2);
        sale.makeLineltem(spec2, 3);

        // Verify line items
        List<SalesLineItem> lineItems = sale.getLineltems();
        assertNotNull(lineItems);
        assertEquals(2, lineItems.size());

        // Verify total
        Money expectedTotal = spec1.getPrice().times(2).add(spec2.getPrice().times(3));
        assertEquals(expectedTotal, sale.getTotal());

        // Verify balance (assuming cash tendered is sufficient)
        Money cashTendered = expectedTotal;
        sale.makePayment(cashTendered);
        assertEquals(new Money(0), sale.getBalance());

        // Verify sale completeness
        assertFalse(sale.isComplete());
        sale.becomeComplete();
        assertTrue(sale.isComplete());
    }
}
