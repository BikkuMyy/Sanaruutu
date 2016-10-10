package sanapeli.kayttoliittyma;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import sanapeli.logiikka.Peliruudukko;
import sanapeli.logiikka.Ruutu;

/**
 * Luokka vastaa ToimintoNappi-olioiden tapahtumienkäsittelystä.
 *
 */
public class ToimintoNappienKuuntelija implements ActionListener {

    private JTextArea sanakentta;
    private Peliruudukko pelinhallinta;
    private MerkkiNappiRuudukko napit;

    /**
     * Konstruktori.
     *
     * @param hallinta Peliruudukko-rajapinnan ilmentymä
     */
    public ToimintoNappienKuuntelija(Peliruudukko hallinta) {
        this.pelinhallinta = hallinta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ToimintoNappi toiminto = (ToimintoNappi) e.getSource();

        if (toiminto.getToiminto().equals("Tyhjennä")) {
            tyhjenna();
        }

        if (toiminto.getToiminto().equals("Hyväksy")) {
            hyvaksy();
        }
        
        this.sanakentta.setText("");
        pelinhallinta.getValitut().clear();

    }

    /**
     * Metodi toteuttaa toiminnot, jotka tapahtuvat, kun tyhjennä-nappia
     * painetaan.
     */
    public void tyhjenna() {
        for (Ruutu ruutu : pelinhallinta.getValitut()) {
            MerkkiNappi nappi = napit.haeMerkkiNappi(ruutu.getY(), ruutu.getX());
            nappi.setEnabled(true);
            nappi.setBackground(Color.LIGHT_GRAY);
        }
    }

    /**
     * Metodi toteuttaa toiminnot, jotka tapahtuvat, kun hyväksy-nappia
     * painetaan.
     */
    public void hyvaksy() {
        if (pelinhallinta.tarkistaSana(sanakentta.getText())) {
            paivitaNapit();
        } else {
            tyhjenna();
        }
        
        if (onkoRuudukkoTyhja()){
            pelinhallinta.lopeta();
        } 

    }

    /**
     * Metodi päivittää pelialustan ruudukon ja sen perusteella merkkinapit.
     */
    public void paivitaNapit() {
        pelinhallinta.paivitaRuudukko();
        napit.paivita();
    }

    public void setSanakentta(JTextArea sanakentta) {
        this.sanakentta = sanakentta;
    }

    public void setNapit(MerkkiNappiRuudukko napit) {
        this.napit = napit;
    }
    
    /**
     * Metodi tarkistaa, loppuiko peli eli onko ruudukko tyhjä.
     * @return True, jos ruudukko on tyhjä
     */

    private boolean onkoRuudukkoTyhja() {
        if(napit.kaikkiInaktiivisia()){
            return true;
        }
        return false;
    }

}
