package sanapeli.logiikka;

import java.io.FileNotFoundException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MerkkiTest {

    private Merkki merkki;

    public MerkkiTest() {
    }

    @Before
    public void setUp() throws FileNotFoundException {
        this.merkki = new Merkki();
    }

    @Test
    public void konstruktoriAsettaaOikeanSisallonMerkille() {
        assertTrue("AEIOUYÄÖHJKLMNPRSTV".contains(merkki.toString()));
    }
    
    @Test
    public void konstruktoriAsettaaPisteetMerkille() {
        assertTrue("1234".contains(""+merkki.getPisteet()));
    }
    
    @Test
    public void merkinPisteetAsetetaanOikein(){
        if ("AEINST".contains(merkki.toString())){
            assertEquals(1, merkki.getPisteet());
        } else if ("UOÄKLM".contains(merkki.toString())){
            assertEquals(2, merkki.getPisteet());
        } else if ("PRHJYV".contains(merkki.toString())){
            assertEquals(3, merkki.getPisteet());
        } else {
            assertEquals(4, merkki.getPisteet());
        }
    }

    @Test
    public void tulostusToimiiOikein(){
        assertTrue("AEIOUYÄÖHJKLMNPRSTV".contains(merkki.toString()));
    }

}
