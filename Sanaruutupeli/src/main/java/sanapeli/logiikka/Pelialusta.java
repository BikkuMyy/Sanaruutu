package sanapeli.logiikka;

import java.util.ArrayList;

/**
 * Luokka edustaa taulukkomuotoista pelialustaa, johon voi tallentaa
 * Ruutu-olioita.
 *
 */
public class Pelialusta implements Peliruudukko {

    private Ruutu[][] ruudukko;
    private ValitutRuudut valitut;

    public Pelialusta(int koko) {
        this.ruudukko = new Ruutu[koko][koko];
        this.valitut = new ValitutRuudut();
    }

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

    //metodi, joka pävittää tilanteen kun merkkejä on käytetty
    @Override
    public Ruutu[][] getRuudukko() {
        return ruudukko;
    }

    @Override
    public Ruutu getRuutu(int y, int x) {
        return ruudukko[y][x];
    }

    @Override
    public ArrayList<Ruutu> getValitut() {
        return valitut.getValitut();
    }

}
