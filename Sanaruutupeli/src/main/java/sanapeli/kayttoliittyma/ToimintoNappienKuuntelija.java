package sanapeli.kayttoliittyma;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import sanapeli.logiikka.Ruutu;
import sanapeli.logiikka.Pelilogiikka;

/**
 * Luokka vastaa ToimintoNappi-olioiden tapahtumienkäsittelystä.
 *
 */
public class ToimintoNappienKuuntelija implements ActionListener {

    private JTextArea sanakentta;
    private JTextArea pistekentta;
    private Pelilogiikka logiikka;
    private Kayttoliittyma kayttis;
    private MerkkiNappiRuudukko napit;

    /**
     * Konstruktori.
     *
     * @param kayttis viittaus Kayttoliittymaan
     */
    public ToimintoNappienKuuntelija(Kayttoliittyma kayttis) {
        this.kayttis = kayttis;
        this.logiikka = kayttis.getLogiikka();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ToimintoNappi toiminto = (ToimintoNappi) e.getSource();

        if (toiminto.getToiminto().equals("Lopeta")) {
            kayttis.lopeta();
        }

        if (toiminto.getToiminto().equals("Tyhjennä")) {
            tyhjenna();
        }

        if (toiminto.getToiminto().equals("Hyväksy")) {
            hyvaksy();
        }

        this.sanakentta.setText("");
        logiikka.getValitut().clear();

    }

    /**
     * Metodi toteuttaa toiminnot, jotka tapahtuvat, kun tyhjennä-nappia
     * painetaan.
     */
    public void tyhjenna() {
        for (Ruutu ruutu : logiikka.getValitut()) {
            MerkkiNappi nappi = napit.haeMerkkiNappi(ruutu.getY(), ruutu.getX());
            nappi.setEnabled(true);
            nappi.setBackground(Color.LIGHT_GRAY);
        }
    }

    /**
     * Metodi toteuttaa hyväksy-nappia painettaessa tapahtuvat toiminnot ja
     * antaa lopetuskäskyn jos ruudukko on tyhjä.
     */
    public void hyvaksy() {
        if (logiikka.tarkistaSana(sanakentta.getText())) {
            int pisteet = Integer.parseInt(pistekentta.getText()) + logiikka.laskePisteet();
            pistekentta.setText("" + pisteet);
            paivitaNapit();
        } else {
            tyhjenna();
        }

        if (napit.kaikkiInaktiivisia()) {
            kayttis.lopeta();
        }
    }

    /**
     * Metodi päivittää pelialustan ruudukon ja sen perusteella merkkinapit.
     */
    public void paivitaNapit() {
        logiikka.paivitaRuudukko();
        napit.paivita();
    }

    public void setSanakentta(JTextArea sanakentta) {
        this.sanakentta = sanakentta;
    }

    public void setPistekentta(JTextArea pistekentta) {
        this.pistekentta = pistekentta;
    }

    public void setNapit(MerkkiNappiRuudukko napit) {
        this.napit = napit;
    }

}
