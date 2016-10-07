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
    private Peliruudukko sanapeli;
    private MerkkiNappiRuudukko napit;
    
    /**
     * Konstruktori.
     * @param sanapeli  Peliruudukko-rajapinnan ilmentymä 
     */
    public ToimintoNappienKuuntelija(Peliruudukko sanapeli) {
        this.sanapeli = sanapeli;
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
        
        //sanakentta.setBackground(Color.WHITE);
        this.sanakentta.setText("");
        sanapeli.getValitut().clear();

    }

    /**
     * Metodi toteuttaa toiminnot, jotka tapahtuvat,
     * kun tyhjennä-nappia painetaan.
     */
    public void tyhjenna() {
        for (Ruutu ruutu : sanapeli.getValitut()) {
            MerkkiNappi nappi = napit.haeMerkkiNappi(ruutu.getY(), ruutu.getX());
            nappi.setEnabled(true);
            nappi.setBackground(Color.LIGHT_GRAY);
        }
    }
    /**
     * Metodi toteuttaa toiminnot, jotka tapahtuvat,
     * kun hyväksy-nappia painetaan.
     */
    public void hyvaksy() {
        if (sanapeli.tarkistaSana(sanakentta.getText())) {
            //sanakentta.setBackground(Color.GREEN);
            for (Ruutu ruutu : sanapeli.getValitut()) {
                MerkkiNappi nappi = napit.haeMerkkiNappi(ruutu.getY(), ruutu.getX());
                nappi.hyvaksy();
            }
            paivitaNapit();
            
        } else {
            // tapahtuu liian nopeasti, värinmuutosta ja tekstiä ei ehi nähä
//            sanakentta.setBackground(Color.RED);
//           this.sanakentta.setText("Ei ole sana!");
            tyhjenna();
        }

    }
    
    /**
     * Metodi päivittää pelialustan ruudukon ja sen perusteella merkkinapit.
     */
    public void paivitaNapit() {
        sanapeli.paivitaRuudukko();

        for (MerkkiNappi nappi : napit.getNapit()) {
            if (nappi.getMerkki().isEmpty()) {
                nappi.setMerkki();
            }
        }
    }

    public void setSanakentta(JTextArea sanakentta) {
        this.sanakentta = sanakentta;
    }

    public void setNapit(MerkkiNappiRuudukko napit) {
        this.napit = napit;
    }

}
