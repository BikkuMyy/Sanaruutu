
package sanapeli.logiikka;

import org.junit.Before;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mari
 */
public class ValitutRuudutTest {
    
    ValitutRuudut valitut;
    
    public ValitutRuudutTest() {
    }
    
    @Before
    public void setUp() {
        this.valitut = new ValitutRuudut();
    }
    
    @Test
    public void konstruktoriLuoTyhjanListan(){
        assertEquals(0, this.valitut.getValitut().size());
    }
}
