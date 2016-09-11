
import java.io.FileNotFoundException;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import sanapeli.sanaruutupeli.Pelialusta;


public class PelialustaTest {
    
    private Pelialusta pelialusta;
    
    public PelialustaTest() {
    }
    
    @Before
    public void setUp (){
        this.pelialusta = new Pelialusta();
    }
   
    @Test
    public void parametritonKonstruktoriLuoTaulukonOiken(){
        Object [][] ruudukko = pelialusta.getRuudukko();
        assertEquals(7, ruudukko.length);
    }
    
    @Test
    public void parametrillinenKonstruktoriLuoTaulukonOiken(){
        this.pelialusta = new Pelialusta(9);
        assertEquals(9, pelialusta.getRuudukko().length);
    }
    
    @Test
    public void sisallonLisaaminenRuutuuToimii() throws FileNotFoundException{
        this.pelialusta.lisaaRuutuunSisalto(1, 2);
        //Randomin testauksen ongelma
    }
    
    @Test
    public void pelinAlkutilanneLuodaanOikein(){
        this.pelialusta = new Pelialusta();
        Object [][] ruudukko = pelialusta.getRuudukko();
    }

    
}
