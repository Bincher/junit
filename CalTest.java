import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class CalTest {
    @Test
    public void testAdd() {
        Cal cal = new Cal();
        assertEquals("1+2==3", 3, cal.add(1, 2));
        assertNotEquals("1+2 !=4", 4, cal.add(1, 2));
    }
}