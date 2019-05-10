//Justin Cai, jc5pz, Ayush Mayur, am3nz
import static org.junit.Assert.*;

import junit.framework.Test;

class HW3Tests {

	@Test(timeout=100)
    public void testEqualsSuccess() {
        Photograph p = new Photograph("beach.jpg", "Beach", "2019-02-13", 5);
        Photograph po = new Photograph("beach.jpg", "Beach", "2019-02-13", 5);
        assertTrue(p.equals(po));
        
    }

}
