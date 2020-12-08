////////////////////////////////////////////////////////////////////
// [Emma] [Roveroni] [1187275]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import it.unipd.tos.model.User;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalTime;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.Before;

public class BillRegisterTest {
    private List<Bill> b;
    private List<User> u;
    private BillRegister br;
    
    @Before
    public void Setup() {
        
        u = new ArrayList<User>();
        b = new ArrayList<Bill>();
        for (int i = 0;i<25;i++) {
        u.add(new User("Emma","Roveroni",i%2==0 ? 8 : 21,i));
        }
        for (int i = 0;i<25;i++){
        b.add(new Bill(i%2==0 ? LocalTime.of(18, 15) : LocalTime.of(19, 15),u.get(i)));
        }
        br = new BillRegister(b,u);
    }
    
    @Test
    public void giftCountTest(){
        
        assertEquals(0,br.getGiftCount());
    }
    
    @Test
    public void listBillTest(){
        assertEquals(b,br.getListBill());
    }
    
    @Test
    public void listUserTest(){
        assertEquals(u,br.getListUser());
    }
    
    @Test
    public void addBillTest(){
        Bill b = new Bill(LocalTime.of(12,0,0,0),new User("Emma","Roveroni",21,43));
        br.AddBill(b);
        assertEquals(b,br.getListBill().get(br.getListBill().size()-1));
    }
    
    @Test
    public void NoGiftAtAdultAtTheRightTimeTest(){
        br.AddBill(new Bill(LocalTime.of(18,40),new User("Emma","Roveroni",21,44)));
        assertFalse(br.gift());
    }
    
    @Test
    public void NoGiftAtUnderAgeChildAtTheWrongTimeTest(){
        br.AddBill(new Bill(LocalTime.of(19,40),new User("Emma","Roveroni",13,46)));
        assertFalse(br.gift());
    }
    
    @Test
    public void NoGiftAtAdultAtTheWrongTimeTest(){
        br.AddBill(new Bill(LocalTime.of(19,40),new User("Emma","Roveroni",21,47)));
        assertFalse(br.gift());
    }
    
    @Test
    public void SamePersonTest(){
        br.AddBill(new Bill(LocalTime.of(18,40),new User("Emma","Roveroni",8,10)));
        assertFalse(br.gift());
    }

    @Test
    public void GiftAtUnderAgeChildInTheRightTimeTest(){
        boolean a = false;
        boolean b = true;
        for(int i = 0;i < 1000;i++) {
            br.AddBill(new Bill(LocalTime.of(18,40),new User("Emma","Roveroni",10,i+25)));
            boolean g = br.gift();
            if(g) {
                a=g;
            }
            else b=g;
        }
        assertTrue(a && !b);
    }
}
