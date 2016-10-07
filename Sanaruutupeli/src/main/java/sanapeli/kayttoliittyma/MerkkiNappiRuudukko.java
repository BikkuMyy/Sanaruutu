package sanapeli.kayttoliittyma;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import sanapeli.logiikka.Peliruudukko;

/**
 * Luokka luo ja säilyttää MerkkiNappi-olioita ja niiden koordinaatteja.
 * 
 */
public class MerkkiNappiRuudukko {

    private int koko;
    private ArrayList<MerkkiNappi> napit;
    private MerkkiNappienKuuntelija merkkiKuuntelija;
    private Peliruudukko sanapeli;

    /**
     * Konstrukstori.
     * @param koko ruudukon koko
     * @param kuuntelija MerkkiNappi-olioiden tapahtumakäsittelijä
     * @param sanapeli  Peliruudukko-rajapinnan ilmentymä
     */
    public MerkkiNappiRuudukko(int koko, MerkkiNappienKuuntelija kuuntelija,
            Peliruudukko sanapeli) {
        this.koko = koko;
        this.napit = new ArrayList();
        this.merkkiKuuntelija = kuuntelija;
        this.sanapeli = sanapeli;
    }

    /**
     * Metodi luo MerkkiNappiRuudukon, joka sisältää MerkkiNappi-olioita.
     *
     * @return MerkkiNappiRuudukko
     */
    public JPanel luoMerkkiNappiRuudukko() {
        JPanel merkkiRuudukko = new JPanel(new GridLayout(koko, koko));
        for (int y = 0; y < koko; y++) {
            for (int x = 0; x < koko; x++) {
                MerkkiNappi nappi = luoMerkkiNappi(y, x);
                napit.add(nappi);
                merkkiRuudukko.add(nappi);
            }
        }

        return merkkiRuudukko;
    }

    private MerkkiNappi luoMerkkiNappi(int y, int x) {
        MerkkiNappi nappi = new MerkkiNappi(y, x, sanapeli);
        nappi.setBackground(Color.LIGHT_GRAY);
        nappi.addActionListener(merkkiKuuntelija);

        return nappi;
    }

    /**
     * Metodi palauttaa y- ja x-koordinaatteja vastaavan MerkkiNappi-olion.
     *
     * @param y napin y-koordinaatti
     * @param x napin x-koordinaatti
     * @return MerkkiNappi sijainnissa y, x
     */
    public MerkkiNappi haeMerkkiNappi(int y, int x) {
        int indeksi = y * koko + x;
        return napit.get(indeksi);
    }

    public ArrayList<MerkkiNappi> getNapit() {
        return napit;
    }

}
