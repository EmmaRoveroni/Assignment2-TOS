////////////////////////////////////////////////////////////////////
// [Emma] [Roveroni] [1187275]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business.exceptionTest;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import it.unipd.tos.business.exception.TakeAwayBillException;

public class TakeAwayBillExceptionTest {
    
    @Test 
    public void getMessageTest() {
        String m = "Numero massimo elementi per ordinazione raggiunto";
        TakeAwayBillException e = new TakeAwayBillException(m);
        assertEquals(m, e.getMessage());
    }
}
