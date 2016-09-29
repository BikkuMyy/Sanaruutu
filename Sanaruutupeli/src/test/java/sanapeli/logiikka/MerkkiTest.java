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
    public void tulostusToimiiOikein(){
        assertTrue("AEIOUYÄÖHJKLMNPRSTV".contains(merkki.toString()));
    }

}
