package sanapeli.logiikka;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class SananTarkistajaTest {

    private SananTarkistaja tarkistaja;
    
    public SananTarkistajaTest() {
    }

    @Before
    public void setUp() {
        this.tarkistaja = new SananTarkistaja("sanalista.txt");
    }

    @Test
    public void konstruktoriLukeeTiedoston() {
        assertTrue(tarkistaja.getSanat().size() > 0);
    }

    @Test
    public void lukijaEiLisaaValiviivoja() {
        assertTrue(!tarkistaja.getSanat().contains("-"));
    }
    
    @Test
    public void sananTarkastusToimiiOikeallaSanalla(){
        assertTrue(tarkistaja.tarkistaSana("sana"));
    }
    
    @Test
    public void sananTarkastusToimiiVaarallaSanalla(){
        assertTrue(!tarkistaja.tarkistaSana("sanat"));
    
    }
    
    @Test
    public void sananTarkastusToimiiKunSanalistaTyhja(){
        tarkistaja.getSanat().clear();
        assertTrue(tarkistaja.tarkistaSana("sana"));
    }
    
    @Test
    public void yhdenKirjaimetSanatEiToimiKunSanalistaTyhja(){
        tarkistaja.getSanat().clear();
        assertTrue(!tarkistaja.tarkistaSana("s"));
    }

}
