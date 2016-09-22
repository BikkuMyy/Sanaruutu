package sanapeli.logiikka;

import java.io.FileNotFoundException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RuutuTest {
    
    private Ruutu ruutu;
    
    public RuutuTest() {
    }
    
    @Before
    public void setUp() throws FileNotFoundException {
        this.ruutu = new Ruutu(1, 2);
    }
    
    @Test
    public void konstruktoriAsettaaSijainninOikein(){
        assertEquals(2, this.ruutu.getX());
        assertEquals(1, this.ruutu.getY());
    }
    
    @Test
    public void ruudunTyhjennysPoistaaSisallon(){
        this.ruutu.tyhjennaRuudunSisalto();
        assertEquals(null, this.ruutu.getSisalto());
    
    }
    
    @Test
    public void ruudunTyhjennysEiPoistaSijaintia(){
        this.ruutu.tyhjennaRuudunSisalto();
        assertEquals(2, this.ruutu.getX());
        assertEquals(1, this.ruutu.getY());
    }
    
    @Test
    public void tulostusToimiiOikein(){
        assertTrue("AEIOUYÄÖHJKLMNPRSTV".contains(this.ruutu.toString()));
    }


}
