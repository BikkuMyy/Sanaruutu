package sanapeli.logiikka;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class SananTarkistajaTest {

    private SananTarkistaja tarkistaja;
    ByteArrayOutputStream tulosvirta;

    public SananTarkistajaTest() {
    }

    @Before
    public void setUp() {
        this.tarkistaja = new SananTarkistaja("sanalista.txt");
        tulosvirta = new ByteArrayOutputStream();
        System.setOut(new PrintStream(tulosvirta));
    }

    @Test
    public void konstruktoriLukeeTiedoston() {
        assertTrue(tarkistaja.getSanat().size() > 0);
    }

    @Test
    public void virheilmoitusTulostuuOikein() throws Exception {
        this.tarkistaja = new SananTarkistaja("sanat.txt");
        String tulos = tulosvirta.toString();
        assertTrue(tulos.contains("Tiedoston lukeminen epäonnistui."));
    }

    @Test
    public void lukijaEiLisaaValiviivoja() {
        assertTrue(!tarkistaja.getSanat().contains("-"));
    }
    
    @Test
    public void sananTarkastusToimiiOikeallaSanalla(){
        String sana = "sana";
        assertEquals(true, tarkistaja.tarkistaSana(sana));
    }
    
    @Test
    public void sananTarkastusToimiiVaarallaSanalla(){
        String sana = "sanat";
        assertEquals(false, tarkistaja.tarkistaSana(sana));
    
    }

}
