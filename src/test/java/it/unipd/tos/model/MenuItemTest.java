////////////////////////////////////////////////////////////////////
// [Emma] [Roveroni] [1187275]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.model;

import it.unipd.tos.model.MenuItem;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;

public class MenuItemTest {
    MenuItem item;
    @Before
    public void setUp() {
        item = new MenuItem("Coppa Nafta", MenuItem.items.Gelato, 3.50);
    }
    @Test
    public void getNameTest() {
        assertEquals("Coppa Nafta", item.getName());
    }	
    @Test
    public void getTypeTest() {	
        assertEquals(MenuItem.items.Gelato, item.getType());
    }
    @Test
    public void getPrice() {	
        assertEquals(3.50, item.getPrice(), 0.0);
    }
}
