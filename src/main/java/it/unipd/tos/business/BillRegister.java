////////////////////////////////////////////////////////////////////
// [Emma] [Roveroni] [1187275]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import it.unipd.tos.model.User;
import java.util.List;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;

public class BillRegister {
    private List<Bill> lb;
    private List<User> lu;
    private LocalTime start = LocalTime.of(18, 00);
    private LocalTime end = LocalTime.of(19, 00);
    private int giftCount = 0;
    
    BillRegister(){
        lb = new ArrayList<Bill>();
        lu = new ArrayList<User>();
    }
    
    BillRegister(List<Bill> alb,List<User> alu){
        lb = alb;
        lu = alu; 
    }
    public int getGiftCount(){
        
        return giftCount;
    }
    public List<Bill> getListBill(){
        return lb;
    }

    public List<User> getListUser(){
        return lu;
    }
    
    public void AddBill(Bill b){
        lb.add(b);
        lu.add(b.getUser());
    }

    public boolean gift(){
        if(!(lb.get(lb.size()-1).getLocalTime().isAfter(start) && lb.get(lb.size()-1).getLocalTime().isBefore(end)) || (!lu.get(lu.size()-1).isUnderAge())){ 
            return false;
        }
        for(int i = 0;i <= lu.size()-2;i++) {
          if(lu.get(i).getId()== (lu.get(lu.size()-1).getId())){
            if(lu.get(i).getName()== (lu.get(lu.size()-1).getName())) {
              if(lu.get(i).getSurname()== (lu.get(lu.size()-1).getSurname())) {
                if(lu.get(i).getAge()== (lu.get(lu.size()-1).getAge())) {
                    return false;
                }
              }
            }
          }
        }
        if(new Random().nextInt()%2==1 && giftCount<10){ 
            giftCount++;
            return true;
        }
        return false;
    }
}