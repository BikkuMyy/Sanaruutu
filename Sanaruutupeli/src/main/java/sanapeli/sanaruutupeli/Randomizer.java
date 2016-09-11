package sanapeli.sanaruutupeli;

// tarvii paremman nimen!
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

public class Randomizer {

    private File tiedosto;
    private List<String> rivit;

    public Randomizer(String tiedostonNimi) throws FileNotFoundException {
        this.tiedosto = new File(tiedostonNimi);
        this.rivit = new ArrayList<>();
        lueTiedostoListaan();
    }
    
    private void lueTiedostoListaan() throws FileNotFoundException {
        Scanner lukija = new Scanner(tiedosto);
        while (lukija.hasNextLine()) {
            this.rivit.add(lukija.nextLine());
        }
    }
    
    public String satunnainenMerkki() {
        Collections.shuffle(rivit);
        return rivit.get(0);
    }

    public List<String> getRivit() {
        return rivit;
    }
    
    
    
}