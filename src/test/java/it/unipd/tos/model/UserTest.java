////////////////////////////////////////////////////////////////////
// [Emma] [Roveroni] [1187275]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.model;

import it.unipd.tos.model.User;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import org.junit.Before;

public class UserTest {

    User user;

    @Before
    public void setUp() {
        user = new User("Emma", "Roveroni", 21, 0);
    }
    @Test
    public void getNameTest(){	
        assertEquals("Emma", user.getName());
    }	
    @Test
    public void getSurnameTest(){	
        assertEquals("Roveroni", user.getSurname());
    }
    @Test
    public void getAge(){	
        assertEquals(21, user.getAge());
    }
    @Test
    public void isUnderAge(){
        assertFalse(user.isUnderAge());
    }	
    @Test
    public void getId(){
        assertEquals(0, user.getId());
    }
}
