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
    private Peliruudukko ruudukko;

    public MerkkiNappiRuudukko(int koko, MerkkiNappienKuuntelija kuuntelija,
            Peliruudukko ruudukko) {
        this.koko = koko;
        this.napit = new ArrayList();
        this.merkkiKuuntelija = kuuntelija;
        this.ruudukko = ruudukko;
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
        MerkkiNappi nappi = new MerkkiNappi(y, x, ruudukko);
        nappi.setBackground(Color.LIGHT_GRAY);
        nappi.addActionListener(merkkiKuuntelija);

        return nappi;
    }

    /**
     * Metodi palauttaa y- ja x-koordinaatteja vastaavan MerkkiNappi-olion.
     *
     * @param y
     * @param x
     *
     * @return MerkkiNappi sijainnissa y, x
     */
    public MerkkiNappi haeMerkkiNappi(int y, int x) {
        int indeksi = y * koko + x;
        return napit.get(indeksi);
    }

    /**
     * Metodi poistaa y- ja x-koordinaatteja vastaavan MerkkiNappi-olion.
     *
     * @param y
     * @param x
     */
    public void poistaMerkkiNappi(int y, int x) {
        MerkkiNappi nappi = haeMerkkiNappi(y, x);
        nappi.setText("");
        nappi.setBackground(Color.MAGENTA);
        nappi.setEnabled(false);
        ruudukko.getRuutu(y, x).tyhjennaRuudunSisalto();
        napit.remove(nappi);
    }

    public ArrayList<MerkkiNappi> getNapit() {
        return napit;
    }

}
