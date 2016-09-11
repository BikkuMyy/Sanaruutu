
import java.io.FileNotFoundException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import sanapeli.sanaruutupeli.Kirjain;


public class KirjainTest {
    
    private Kirjain kirjain;
    
    public KirjainTest() {
    }
    
    @Before
    public void setUp() throws FileNotFoundException {
        this.kirjain = new Kirjain();
    }
    
    
}
