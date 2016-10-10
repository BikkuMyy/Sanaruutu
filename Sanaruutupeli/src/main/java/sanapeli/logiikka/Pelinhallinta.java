package sanapeli.logiikka;
import java.util.ArrayList;
import javax.swing.SwingUtilities;
import sanapeli.kayttoliittyma.Kayttoliittyma;

/**
 * Luokka vastaa Pelialustan ja Kayttoliittyman luomisesta sekä pelin
 * käynnistämisestä.
 */

public class Pelinhallinta implements Peliruudukko {

    private Pelialusta pelialusta;
    private SananTarkistaja tarkistaja;

    /**
     * Konstruktori.
     */
    public Pelinhallinta() {
        this.pelialusta = new Pelialusta();
        this.tarkistaja  = new SananTarkistaja("sanalista.txt");
    }

    /**
     * Metodi luo ohjelman käyttöliittymän ja pelialustan alkutilanteen.
     */
    public void kaynnista() {
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(this);
        SwingUtilities.invokeLater(kayttoliittyma);
        pelialusta.luoAlkuTilanne();
    }
    
    @Override
    public void lopeta(){
        System.exit(0);
    }

    @Override
    public Ruutu[][] getRuudukko() {
        return pelialusta.getRuudukko();
    }

    @Override
    public Ruutu getRuutu(int y, int x) {
        return pelialusta.getRuutu(y, x);
    }

    @Override
    public ArrayList<Ruutu> getValitut() {
        return pelialusta.getValitut();
    }

    @Override
    public boolean tarkistaSana(String sana) {
        return tarkistaja.tarkistaSana(sana);
    }

    @Override
    public void paivitaRuudukko() {
        pelialusta.paivitaRuudukko();
    }

    
    
}
