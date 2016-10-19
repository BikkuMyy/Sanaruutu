package sanapeli.kayttoliittyma;

import sanapeli.logiikka.Pelilogiikka;
import sanapeli.logiikka.Pelinhallinta;

/**
 * Luokka vastaa ohjelman graafisen käyttöliittymän luomisesta ja ylläpidosta.
 *
 */
public class Kayttoliittyma implements Runnable {

    private Pelilogiikka logiikka;
    private AloitusValikko aloitus;
    private PeliIkkuna peli;
    private int koko;

    /**
     * Konstruktori.
     *
     */
    public Kayttoliittyma() {
        this.koko = 7;
        this.aloitus = new AloitusValikko(this);
    }

    @Override
    public void run() {
    }
    
    /**
     * Metodi totetuttaa pelin aloittamisen vaatimat toiminnot.
     */
    public void aloitaPeli() {
        Pelinhallinta hallinta = new Pelinhallinta(koko);
        this.logiikka = hallinta;
        aloitus.setVisible(false);
        logiikka.kaynnista();
        this.peli = new PeliIkkuna(this, koko);
    }
    
    /**
     * Metodi toteuttaa pelin lopettamisen vaatimat toiminnot.
     */
    public void lopeta() {
        peli.dispose();
        aloitus.setVisible(true);
    }

    public void setKoko(int koko) {
        this.koko = koko;
    }

    public Pelilogiikka getLogiikka() {
        return logiikka;
    }
}
