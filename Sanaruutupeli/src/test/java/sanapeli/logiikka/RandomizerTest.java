package sanapeli.logiikka;



import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class RandomizerTest {
    
    private Randomizer randomizer;
    
    public RandomizerTest() {
    }
    
    @Before
    public void setUp() throws FileNotFoundException {
        this.randomizer = new Randomizer ("kirjaimet.txt");
    }
    
    @Test
    public void konstruktoriLukeeTiedoston(){
        assertTrue(randomizer.getRivit().size() > 0);
    }
    
    
    
}
