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

    public Bill(LocalTime t){
        this.t = t;
    }

public double getOrderPrice(List<MenuItem> itemsOrdered, User user) throws TakeAwayBillException {
        
        double tot = 0;
        int icecreamcount = 0;
        double minprice = Double.MAX_VALUE;
        double ICandBcount = 0;
        if(itemsOrdered.size()>=30) {
            throw new TakeAwayBillException("Numero massimo elementi per ordinazione raggiunto");
        }
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
        return tot;
    }

}