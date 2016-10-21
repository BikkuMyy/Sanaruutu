package sanapeli.logiikka;

import java.util.ArrayList;

/**
 * Luokka vastaa Pelialustan ja Kayttoliittyman luomisesta sekä pelin
 * käynnistämisestä.
 */
public class Pelinhallinta implements Pelilogiikka {

    private Pelialusta pelialusta;
    private SananTarkistaja tarkistaja;
    private int pisteet;
    private int koko;

    /**
     * Konstruktori.
     * @param koko peliruudukon koko
     */
    public Pelinhallinta(int koko) {
        this.tarkistaja = new SananTarkistaja("sanalista.txt");
        this.pisteet = 0;
        this.koko = koko;
    }
    
    @Override
    public void kaynnista() {
        this.pelialusta = new Pelialusta(koko);
        pelialusta.luoAlkuTilanne();
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

    @Override
    public int laskePisteet() {
        return pelialusta.laskeValittujenPisteet();
    }

}
