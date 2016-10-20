package sanapeli.logiikka;

import java.io.FileNotFoundException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class SatunnaistajaTest {
    
    private Satunnaistaja satunnaistaja;
    
    public SatunnaistajaTest() {
    }
    
    @Before
    public void setUp() throws FileNotFoundException {
        this.satunnaistaja = new Satunnaistaja ("kirjaimet.txt");
    }
    
    @Test
    public void konstruktoriLukeeTiedoston(){
        assertTrue(satunnaistaja.getMerkit().size() > 0);
    }
    
    @Test
    public void merkitLisataanListaanIlmanTiedostoa() {
        satunnaistaja.getMerkit().clear();
        satunnaistaja.lisaaListaanMerkit();
        assertTrue(!satunnaistaja.getMerkit().isEmpty());

    }
}
