package sanapeli.logiikka;


import java.io.FileNotFoundException;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;


public class PelialustaTest {
    
    private Pelialusta pelialusta;
    
    public PelialustaTest() {
    }
    
    @Before
    public void setUp (){
        this.pelialusta = new Pelialusta();
    }
   
    @Test
    public void parametritonKonstruktoriLuoTaulukonOiken(){
        Object [][] ruudukko = pelialusta.getRuudukko();
        assertEquals(7, ruudukko.length);
    }
    
    @Test
    public void parametrillinenKonstruktoriLuoTaulukonOiken(){
        this.pelialusta = new Pelialusta(9);
        assertEquals(9, pelialusta.getRuudukko().length);
    }
    
//    @Test
//    public void sisallonLisaaminenRuutuuToimii() throws FileNotFoundException{
//        this.pelialusta.lisaaRuutuunSisalto(1, 2);
//        assertTrue("AEIOUYÄÖHJKLMNPRSTV".contains(this.pelialusta.getRuudukko()[1][2].toString()));
//    }
    
    @Test
    public void pelinAlkutilanneLuodaanOikein() throws FileNotFoundException{
        this.pelialusta = new Pelialusta();
        pelialusta.luoAlkuTilanne();
        Ruutu [][] ruudukko = pelialusta.getRuudukko();
        
        for (int y = (ruudukko.length / 2 - 1); y <= (ruudukko.length / 2 + 1); y++) {
            for (int x = (ruudukko[y].length / 2 - 1); x <= (ruudukko[y].length / 2 + 1); x++) {
                Ruutu ruutu = ruudukko[y][x];
                assertTrue("AEIOUYÄÖHJKLMNPRSTV".contains(ruutu.toString()));
            }
        }
    }
    
    

    
}
