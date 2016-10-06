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
    private Peliruudukko ruudukko;
    private MerkkiNappiRuudukko napit;

    public ToimintoNappienKuuntelija(Peliruudukko ruudukko) {
        this.ruudukko = ruudukko;
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
        ruudukko.getValitut().clear();

    }

    public void tyhjenna() {
        for (Ruutu ruutu : ruudukko.getValitut()) {
            MerkkiNappi nappi = napit.haeMerkkiNappi(ruutu.getY(), ruutu.getX());
            nappi.setEnabled(true);
            nappi.setBackground(Color.LIGHT_GRAY);
        }
    }

    public void hyvaksy() {
        if (ruudukko.tarkistaSana(sanakentta.getText())) {
            //sanakentta.setBackground(Color.GREEN);
            for (Ruutu ruutu : ruudukko.getValitut()) {
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

    public void paivitaNapit() {
        ruudukko.paivitaRuudukko();

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
