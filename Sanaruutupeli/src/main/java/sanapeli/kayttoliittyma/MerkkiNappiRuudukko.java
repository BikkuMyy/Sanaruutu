package sanapeli.kayttoliittyma;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import sanapeli.logiikka.Ruutu;
import sanapeli.logiikka.Pelilogiikka;

/**
 * Luokka luo ja säilyttää MerkkiNappi-olioita ja niiden koordinaatteja.
 *
 */
public class MerkkiNappiRuudukko {

    private int koko;
    private ArrayList<MerkkiNappi> napit;
    private MerkkiNappienKuuntelija merkkiKuuntelija;
    private Pelilogiikka logiikka;

    /**
     * Konstrukstori.
     *
     * @param koko ruudukon koko
     * @param kuuntelija MerkkiNappi-olioiden tapahtumakäsittelijä
     * @param hallinta Pelilogiikka-rajapinnan ilmentymä
     */
    public MerkkiNappiRuudukko(int koko, MerkkiNappienKuuntelija kuuntelija,
            Pelilogiikka hallinta) {
        this.koko = koko;
        this.napit = new ArrayList();
        this.merkkiKuuntelija = kuuntelija;
        this.logiikka = hallinta;
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
        MerkkiNappi nappi = new MerkkiNappi(y, x, logiikka, koko);
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

    /**
     * Metodi päivittää nappeihin merkit, kun edellinen sanan on hyväksytty ja
     * uusia merkkejä tulee käyttöön.
     */
    public void paivita() {
        for (Ruutu ruutu : logiikka.getValitut()) {
            MerkkiNappi nappi = haeMerkkiNappi(ruutu.getY(), ruutu.getX());
            nappi.hyvaksy();
        }

        for (MerkkiNappi nappi : napit) {
            if (nappi.getMerkki().isEmpty()) {
                nappi.setMerkki();
            }
        }
    }

    public ArrayList<MerkkiNappi> getNapit() {
        return napit;
    }

    /**
     * Metodi tarkistaa, onko kaikki ruudukon napit inaktiivisia.
     *
     * @return True, jos kaikki on inaktiivisia ja false jos yksikin ei ole
     */
    public boolean kaikkiInaktiivisia() {
        for (MerkkiNappi nappi : napit) {
            if (nappi.isEnabled()) {
                return false;
            }
        }
        return true;
    }
}
