import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class RegisterTest {

    private ProductCatalog catalog;
    private Register register;

    @Before
    public void setUp() {
        // Prepare test data
        catalog = new ProductCatalog();
        register = new Register(catalog);
    }

    @Test
    public void testRegisterWorkflow() {
        // Make a new sale
        register.makeNewSale();

        // Enter items to the sale
        ItemID itemId1 = new ItemID(100);
        int quantity1 = 2;
        register.enterltem(itemId1, quantity1);

        ItemID itemId2 = new ItemID(200);
        int quantity2 = 3;
        register.enterltem(itemId2, quantity2);

        // End the sale
        register.endSale();

        // Make a payment
        Money cashTendered = new Money(20);
        register.makePayment(cashTendered);

        // Get the sale from the register
        Sale sale = register.getSale();

        // Verify sale details
        assertNotNull(sale);
        assertTrue(sale.isComplete());

        // Verify line items in the sale
        assertEquals(2, sale.getLineltems().size());

        // Verify total and payment balance
        assertEquals(new Money(15), sale.getTotal());
        assertEquals(new Money(5), sale.getBalance());
    }
}
