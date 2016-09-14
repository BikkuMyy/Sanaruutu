

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import sanapeli.sanaruutupeli.Randomizer;


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
        assertEquals(43, randomizer.getRivit().size());
    }
    
    
    
}
