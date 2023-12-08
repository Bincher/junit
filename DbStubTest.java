import static org.junit.Assert.*;

import org.junit.Test;

public class DbStubTest {

    @Test
    public void testSaveAndGetProductSpecification() {
        ProductSpecification productSpec = new ProductSpecification(new ItemID(1), new Money(10.0), "Test Product");
        DbStub.saveProductSpecification(productSpec);

        ProductSpecification retrievedSpec = DbStub.getProductSpecification(1);

        assertNotNull(retrievedSpec);
        assertEquals(productSpec.getDescription(), retrievedSpec.getDescription());
        assertEquals(productSpec.getPrice().getAmount(), retrievedSpec.getPrice().getAmount());
    }


    @Test
    public void testSavePaymentAndIsSaleComplete() {
        // Prepare data
        Money cashTendered = new Money(20.0);
        Sale sale = new Sale();
        int saleId = DbStub.saveSale(sale);

        // Make payment and complete sale
        DbStub.savePayment(saleId, cashTendered);
        DbStub.getSale(saleId).becomeComplete();

        // Check if the sale is complete
        boolean isComplete = DbStub.isSaleComplete(saleId);

        assertTrue(isComplete);
    }

}
