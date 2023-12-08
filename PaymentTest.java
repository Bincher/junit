import static org.junit.Assert.*;
import org.junit.Test;

public class PaymentTest {

    @Test
    public void testGetAmount() {
        // Prepare test data
        Money cashTendered = new Money(50.0);
        Payment payment = new Payment(cashTendered);

        // Verify the getAmount method
        assertEquals(cashTendered, payment.getAmount());
    }
}