package sanapeli.logiikka;

// tarvii paremman nimen!
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

/**
 * Luokka lukee saamansa tiedoston listaksi merkkijonoja.
 *
 */
public class Randomizer {

    private File tiedosto;
    private List<String> rivit;

    public Randomizer(String tiedostonNimi) {
        this.tiedosto = new File(tiedostonNimi);
        this.rivit = new ArrayList<>();
        lueTiedostoListaan();
        //pitäis olla erillinen luokka tiedoston lukemiselle ja randomizingille..?
    }

    /**
     * Metodi lukee tiedoston listaan. 
     */
    private void lueTiedostoListaan() {

        Scanner lukija = null;

        try {
            lukija = new Scanner(tiedosto, "UTF-8");
        } catch (Exception e) {
            System.out.println("Tiedoston lukeminen epäonnistui. Virhe: " + e.getMessage());
            return;
        }

        while (lukija.hasNextLine()) {
            this.rivit.add(lukija.nextLine());
        }

        lukija.close();
    }
    
    /** 
     * Metodi sekoittaa listan ja palauttaa merkin sen ensimmäisestä indeksistä.
     * 
     * @return satunnainen merkki
     */

    public String satunnainenMerkki() {
        Collections.shuffle(rivit);
        return rivit.get(0);
    }

    public List<String> getRivit() {
        return rivit;
    }

}
