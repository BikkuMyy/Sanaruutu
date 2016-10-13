package sanapeli.logiikka;

import java.util.ArrayList;

/**
 * Luokka edustaa taulukkomuotoista pelialustaa, johon voi tallentaa
 * Ruutu-olioita.
 *
 */
public class Pelialusta {

    private Ruutu[][] ruudukko;
    private ArrayList<Ruutu> valitut;

    /**
     * Konstruktori 1.
     * @param koko luotavan peliruudukon sivun pituus ruuduissa
     */
    public Pelialusta(int koko) {
        this.ruudukko = new Ruutu[koko][koko];
        this.valitut = new ArrayList();
    }

    /**
     * Konstruktori 2, luo oletuskokoisen ruudukon.
     */
    public Pelialusta() {
        this(7);
    }

    /**
     * Metodi luo pelin alkutilanteen, jossa pelialustan keskellä on 9 merkkiä
     * näkyvissä.
     *
     */
    public void luoAlkuTilanne() {
        lisaaAlustaanRuudut();
        lisaaAlkuMerkit();
    }

    /**
     * Metodi lisää pelialustan taulukon kuhunkin sijaintiin Ruutu-olion.
     *
     */
    public void lisaaAlustaanRuudut() {
        for (int y = 0; y < (this.ruudukko.length); y++) {
            for (int x = 0; x < (this.ruudukko[y].length); x++) {
                this.ruudukko[y][x] = new Ruutu(y, x);
            }
        }
    }

    /**
     * Metodi lisää pelialustan taulukon keskustan Ruutu-olioihin Merkki-olion.
     *
     */
    public void lisaaAlkuMerkit() {
        for (int y = (ruudukko.length / 2 - 1); y <= (this.ruudukko.length / 2 + 1); y++) {
            for (int x = (this.ruudukko[y].length / 2 - 1); x <= (this.ruudukko[y].length / 2 + 1); x++) {
                ruudukko[y][x].lisaaRuutuunSisalto();
            }
        }
    }
    
    /**
     * Metodi lisää valittujen ruutujen viereisiin Ruutu-olioihin sisällön,
     * jos niillä ei sitä vielä ole.
     */
    public void paivitaRuudukko() {
        for (Ruutu ruutu : this.valitut) {
            int y = ruutu.getY();
            int x = ruutu.getX();

            //yläpuolella
            if (y - 1 >= 0 && getRuutu(y - 1, x).getSisalto() == null) {
                ruudukko[y - 1][x].lisaaRuutuunSisalto();
            }
            //oikealla
            if (x + 1 < ruudukko.length && getRuutu(y, x + 1).getSisalto() == null) {
                ruudukko[y][x + 1].lisaaRuutuunSisalto();
            }
            //alapuolella
            if (y + 1 < ruudukko.length && getRuutu(y + 1, x).getSisalto() == null) {
                ruudukko[y + 1][x].lisaaRuutuunSisalto();
            }
            //vasemmalla
            if (x - 1 >= 0 && getRuutu(y, x - 1).getSisalto() == null) {
                ruudukko[y][x - 1].lisaaRuutuunSisalto();
            }
        }
    }

    public Ruutu[][] getRuudukko() {
        return ruudukko;
    }

    /**
     * Metodi palauttaa sijainnissa (y, x) olevan Ruutu-olion.
     * @param y haettavan ruudun y-koordinaatti
     * @param x haettavan ruudun x-koordinaatti
     * @return Ruutu-olio sijainnissa (y, x)
     */
    public Ruutu getRuutu(int y, int x) {
        return ruudukko[y][x];
    }

    public ArrayList<Ruutu> getValitut() {
        return valitut;
    }
    
    public int laskeValittujenPisteet(){
        int summa = 0;
        for (Ruutu ruutu : valitut){
            summa += ruutu.getSisalto().getPisteet();
        }
        return summa*valitut.size();
    }


}
