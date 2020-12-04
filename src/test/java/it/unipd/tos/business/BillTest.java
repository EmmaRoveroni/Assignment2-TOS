////////////////////////////////////////////////////////////////////
// [Emma] [Roveroni] [1187275]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import it.unipd.tos.business.Bill;
import it.unipd.tos.model.User;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.business.exception.TakeAwayBillException;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalTime;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;

public class BillTest {

    Bill b; 
    List<MenuItem> l;
    User u;

    @Before
    public void setup (){
        b = new Bill(LocalTime.of(12,0,0,0));
        l = new ArrayList<MenuItem>();
        l.add(new MenuItem("Pinguino",MenuItem.items.Budino,6.00));
        l.add(new MenuItem("Coppa Nafta",MenuItem.items.Gelato,3.50));
        u = new User("Emma","Roveroni",21,0);
    }

    @Test
    public void ComputeTotalTest() {
        
        try {
        assertEquals(9.50,b.getOrderPrice(l,u),0.0);
        } catch (TakeAwayBillException e) {
        System.out.println("Errore");
        }
    }
}
