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
import org.junit.After;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BillTest {

    Bill b; 
    List<MenuItem> l;
    User u;
    @Before
    public void setup (){
        u = new User("Emma","Roveroni",21,0);
        b = new Bill(LocalTime.of(12,0,0,0),u);
        l = new ArrayList<MenuItem>();
    }
    @Test
    public void getUserTest() {
        assertEquals(u,b.getUser());
    }
    
    @Test
    public void getLocalTimeTest() {
        assertEquals(LocalTime.of(12,0,0,0),b.getLocalTime());
    }
    
    @Test
    public void getGiftedTest() {
        assertFalse(b.getGifted());
    }
    @Test
    public void ComputeTotalTest() {
        l.add(new MenuItem("Coppa Nafta",MenuItem.items.Gelato,3.50));
        l.add(new MenuItem("Pinguino",MenuItem.items.Budino,6.00));
        l.add(new MenuItem("Coppa Nafta",MenuItem.items.Gelato,3.50));
        try {
        assertEquals(13.00,b.getOrderPrice(l,u),0.0);
        } catch (TakeAwayBillException e) {
        System.out.println("Errore");
        }
    }
    
    @Test
    public void FiveIcecreamDiscount() {
        for(int i = 0;i<5;i++) {
            l.add(new MenuItem("Coppa Nafta",MenuItem.items.Gelato,3.50));
        }
        try {
            assertEquals(15.75,b.getOrderPrice(l,u),0.0);
        } catch (TakeAwayBillException e) {
        System.out.println("Errore");
            }
    }
    @Test
    public void TotalHigher50DiscountTest() {
        
        l.add(new MenuItem("Coppa Nafta",MenuItem.items.Gelato, 10.00));
        l.add(new MenuItem("Coppa Nafta",MenuItem.items.Gelato, 10.00));
        l.add(new MenuItem("Coppa Nafta",MenuItem.items.Gelato, 10.00));
        l.add(new MenuItem("Biancaneve",MenuItem.items.Budino, 10.00));
        l.add(new MenuItem("Biancaneve",MenuItem.items.Budino, 10.00));
        try {
            assertEquals(45,b.getOrderPrice(l,u),0.0);
        } catch (TakeAwayBillException e) {
            System.out.println("Error");
        }
    }
    @Test (expected = TakeAwayBillException.class)
    public void ErrorForNumberOfOrders() throws TakeAwayBillException{
        
        
        for(int i = 0; i < 30; i++) {
            
            l.add(new MenuItem("Coppa Nafta",MenuItem.items.Gelato,3.50));
        }
     
        b.getOrderPrice(l, u);
    }
    @Test 
    public void TotalLower10CommissionTest() {
        l.add(new MenuItem("Coppa Nafta",MenuItem.items.Gelato,3.50));
        try {
            assertEquals(4.00,b.getOrderPrice(l,u),0.0);
        } catch (TakeAwayBillException e) {
            System.out.println("Errore");
        }
    }
    @Test
    public void GiftTest() {
        boolean a = false;
        for (int i = 0;i<1000;i++) {
            Bill b = new Bill(LocalTime.of(18,30),new User("Emma","Roveroni",8,i));
            if(b.getGifted()) {
                a = true;
            }
        }
        assertTrue(a);
    }
    @After
    public void emptyList() {
        l.clear();
    }
}

