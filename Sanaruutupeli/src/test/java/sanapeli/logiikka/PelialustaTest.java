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
    public void parametritonKonstruktoriLuoTaulukonOiken() {
        Object [][] ruudukko = pelialusta.getRuudukko();
        assertEquals(7, ruudukko.length);
    }
    
    @Test
    public void parametrillinenKonstruktoriLuoTaulukonOiken() {
        this.pelialusta = new Pelialusta(9);
        assertEquals(9, pelialusta.getRuudukko().length);
    }
    
    @Test
    public void ruutujenLisaaminenAlustaanToimii() throws FileNotFoundException {
        pelialusta.lisaaAlustaanRuudut();
        Ruutu [][] ruudukko = pelialusta.getRuudukko();
        
        for (int y = 0; y < ruudukko.length; y++) {
            for (int x = 0; x < ruudukko[y].length; x++) {
                Ruutu ruutu = ruudukko[y][x];
                assertTrue(ruutu != null);
            }
        }
    }
    
    @Test
    public void alkuMerkitLisataanOikein() throws FileNotFoundException {
        pelialusta.lisaaAlustaanRuudut();
        pelialusta.lisaaAlkuMerkit();
        Ruutu [][] ruudukko = pelialusta.getRuudukko();
        
        for (int y = (ruudukko.length / 2 - 1); y <= (ruudukko.length / 2 + 1); y++) {
            for (int x = (ruudukko[y].length / 2 - 1); x <= (ruudukko[y].length / 2 + 1); x++) {
                assertTrue("AEIOUYÄÖHJKLMNPRSTV".contains(ruudukko[y][x].toString()));
            }
        }
    }
    
    @Test
    public void kokoAlkuTilanneLuodaanOikein() throws FileNotFoundException {
        pelialusta.luoAlkuTilanne();
        Ruutu [][] ruudukko = pelialusta.getRuudukko();
        
        for (int y = (ruudukko.length / 2 - 1); y <= (ruudukko.length / 2 + 1); y++) {
            for (int x = (ruudukko[y].length / 2 - 1); x <= (ruudukko[y].length / 2 + 1); x++) {
                assertTrue("AEIOUYÄÖHJKLMNPRSTV".contains(ruudukko[y][x].toString()));
            }
        }
        
    }
    
    

    
}
