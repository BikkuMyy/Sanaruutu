package sanapeli.logiikka;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class PelialustaTest {

    private Pelialusta pelialusta;
    private Ruutu[][] ruudukko;

    public PelialustaTest() {
    }

    @Before
    public void setUp() {
        this.pelialusta = new Pelialusta();
        this.ruudukko = pelialusta.getRuudukko();
    }

    @Test
    public void parametritonKonstruktoriLuoTaulukonOiken() {
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

        for (int y = (ruudukko.length / 2 - 1); y <= (ruudukko.length / 2 + 1); y++) {
            for (int x = (ruudukko[y].length / 2 - 1); x <= (ruudukko[y].length / 2 + 1); x++) {
                assertTrue(ruudukko[y][x].getSisalto() != null);
            }
        }
    }

    @Test
    public void kokoAlkuTilanneLuodaanOikein() throws FileNotFoundException {
        pelialusta.luoAlkuTilanne();

        for (int y = (ruudukko.length / 2 - 1); y <= (ruudukko.length / 2 + 1); y++) {
            for (int x = (ruudukko[y].length / 2 - 1); x <= (ruudukko[y].length / 2 + 1); x++) {
                assertTrue("AEIOUYÄÖHJKLMNPRSTV".contains(ruudukko[y][x].toString()));
            }
        }
    }

    @Test
    public void ruudunHakuKoordinaateillaToimii() {
        assertEquals(ruudukko[1][1], pelialusta.getRuutu(1, 1));
    }

    @Test
    public void ruudukonSisaltoPaivitetaanOikein() {
        pelialusta.luoAlkuTilanne();
        ArrayList <Ruutu> valitut = pelialusta.getValitut();
        for (int y = 3; y <= 5; y++) {
            for (int x = 3; x <= 5; x++) {
                valitut.add(pelialusta.getRuutu(y, x));
            }
        }  
        
        pelialusta.paivitaRuudukko();
        for (int y = 3; y <= 5; y++) {
            for (int x = 3; x <= 5; x++) {
                assertTrue(ruudukko[y - 1][x].getSisalto() != null);
                assertTrue(ruudukko[y][x - 1].getSisalto() != null);
                assertTrue(ruudukko[y][x + 1].getSisalto() != null);
                assertTrue(ruudukko[y + 1][x].getSisalto() != null);
            }
        }
    }
    
//    @Test
//    public void ruudukonUlkopuolelleEiLisataMerkkeja(){
//        pelialusta.luoAlkuTilanne();
//        ArrayList <Ruutu> valitut = pelialusta.getValitut();
//        valitut.add(pelialusta.getRuutu(0, 0));
//        valitut.add(pelialusta.getRuutu(0, 1));
//        valitut.add(pelialusta.getRuutu(1, 0));
//        pelialusta.paivitaRuudukko();
//        
//    }

}
