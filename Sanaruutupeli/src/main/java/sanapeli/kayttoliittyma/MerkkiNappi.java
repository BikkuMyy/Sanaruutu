package sanapeli.kayttoliittyma;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JButton;
import sanapeli.logiikka.Pelilogiikka;

/**
 * Luokka sisältää yhteen nappiin liittyvät tiedot ja metodit niiden
 * käsittelemiseen.
 *
 */
public class MerkkiNappi extends JButton {

    private Pelilogiikka logiikka;
    private String merkki;
    private int y;
    private int x;
    private int koko;

    /**
     * Konstruktori.
     *
     * @param y napin y-koordinaatti
     * @param x napin x-koordinaatti
     * @param logiikka Pelilogiikka-rajapinnan ilmentymä
     * @param koko ruudukon koko
     */
    public MerkkiNappi(int y, int x, Pelilogiikka logiikka, int koko) {
        this.logiikka = logiikka;
        this.y = y;
        this.x = x;
        this.koko = koko;
        setMerkki();
    }

    /**
     * Metodi hakee merkki-muuttujaan sisällön napin koordinaatteja vastaavasta
     * ruudusta ja asettaa sen JButtonissa näkyväksi tekstiksi.
     *
     */
    public void setMerkki() {
        super.setText(this.merkki = haeNappiinMerkkiRuudusta());
        super.setMargin(new Insets(1, 1, 1, 1));
        super.setFont(new Font("SansSerif", Font.BOLD, 25 - koko));

        tarkistaAktiivisuus();
    }

    private String haeNappiinMerkkiRuudusta() {
        return logiikka.getRuudukko()[y][x].toString();
    }

    /**
     * Metodi palauttaa napin x-koordinaatin.
     *
     * @return MerkkiNappi-olion x
     */
    public int haeX() {
        return this.x;
    }

    /**
     * Metodi palauttaa napin y-koordinaatin.
     *
     * @return MerkkiNappi-olion y
     */
    public int haeY() {
        return this.y;
    }

    public Pelilogiikka getLogiikka() {
        return logiikka;
    }

    /**
     * Metodi toteuttaa napissa tapahtuvat muutokset, kun hyväksy-nappia
     * painetaan.
     *
     */
    public void hyvaksy() {
        setText("");
        setBackground(Color.MAGENTA);
        setEnabled(false);
    }

    private void tarkistaAktiivisuus() {
        if (this.merkki.isEmpty()) {
            setEnabled(false);
        } else {
            setEnabled(true);
        }
    }

    public String getMerkki() {
        return this.merkki;
    }

}
