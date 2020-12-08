////////////////////////////////////////////////////////////////////
// [Emma] [Roveroni] [1187275]
////////////////////////////////////////////////////////////////////


package it.unipd.tos.business;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalTime;

import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.MenuItem.items;
import it.unipd.tos.model.User;

public class Bill implements TakeAwayBill {

    private LocalTime t;
    private User u;
    private boolean gifted;
    private static BillRegister br = new BillRegister();

    public Bill(LocalTime t, User user){
        this.t = t;
        this.u = user;
        br.AddBill(this);
        this.gifted = br.gift();
    }
    public LocalTime getLocalTime() {
        return t;
    }    
    
    public User getUser() {
        return u;
    }
    
    public boolean getGifted() {
        return gifted;
    }    
public double getOrderPrice(List<MenuItem> itemsOrdered, User user) throws TakeAwayBillException {
        
        double tot = 0;
        int icecreamcount = 0;
        double minprice = Double.MAX_VALUE;
        double ICandBcount = 0;
        if(itemsOrdered.size()>=30) {
            throw new TakeAwayBillException("Numero massimo elementi per ordinazione raggiunto");
        }
        if(!gifted) {
        for(MenuItem mi : itemsOrdered) {
            
            if(mi.getType() == items.Gelato) {
                icecreamcount ++;
                if(mi.getPrice() < minprice) {
                    minprice = mi.getPrice();
                }
            }
            if(mi.getType() != items.Bevanda) {
                ICandBcount += mi.getPrice();
            }
            tot += mi.getPrice();
        }
        if (icecreamcount >= 5){
            tot -= minprice/2;
        }
        if (ICandBcount >= 50){
            tot = tot*0.9;
        }
        if(tot < 10)
        {
            tot += 0.50;
        }
        }
        return tot;
    }
}