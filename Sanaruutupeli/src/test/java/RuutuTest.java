/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileNotFoundException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import sanapeli.sanaruutupeli.Ruutu;

/**
 *
 * @author mari
 */
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
        assertEquals(2, this.ruutu.getSijainti().getX());
        assertEquals(1, this.ruutu.getSijainti().getY());
    }
    
    @Test
    public void ruudunTyhjennysPoistaaSisallon(){
        this.ruutu.tyhjennaRuudunSisalto();
        assertEquals(null, this.ruutu.getSisalto());
    
    }
    
    @Test
    public void ruudunTyhjennysEiPoistaSijaintia(){
        this.ruutu.tyhjennaRuudunSisalto();
        assertEquals(2, this.ruutu.getSijainti().getX());
        assertEquals(1, this.ruutu.getSijainti().getY());
    }


}
