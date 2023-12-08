import static org.junit.Assert.*;
import org.junit.Test;

public class StoreTest {

    @Test
    public void testStoreInitialization() {
        // Create a store
        Store store = new Store();

        // Verify that the store has a register
        assertNotNull(store.getRegister());

        // Verify that the register has a catalog
        assertNotNull(store.getRegister().getCatalog());

    }
}
