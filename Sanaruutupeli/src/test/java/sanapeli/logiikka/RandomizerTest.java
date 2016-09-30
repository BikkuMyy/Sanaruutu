package sanapeli.logiikka;



import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class RandomizerTest {
    
    private Randomizer randomizer;
    ByteArrayOutputStream tulosvirta;
    
    public RandomizerTest() {
    }
    
    @Before
    public void setUp() throws FileNotFoundException {
        this.randomizer = new Randomizer ("kirjaimet.txt");
        tulosvirta = new ByteArrayOutputStream();
        System.setOut(new PrintStream(tulosvirta));
    }
    
    @Test
    public void konstruktoriLukeeTiedoston(){
        assertTrue(randomizer.getRivit().size() > 0);
    }
    
    @Test
    public void virheilmoitusTulostuuOikein() throws Exception{
        this.randomizer = new Randomizer("tiedosto.txt");
        String tulos = tulosvirta.toString();
        assertTrue(tulos.contains("Tiedoston lukeminen epäonnistui."));
        
    }
    
}
