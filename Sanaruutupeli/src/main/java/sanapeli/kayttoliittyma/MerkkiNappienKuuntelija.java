package sanapeli.kayttoliittyma;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import sanapeli.logiikka.Pelilogiikka;

/**
 * Luokka vastaa MerkkiNappi-olioiden tapahtumienkäsittelystä.
 *
 */
public class MerkkiNappienKuuntelija implements ActionListener {

    private JTextArea sanakentta;
    private MerkkiNappiRuudukko napit;

    /**
     * Konstruktori.
     */
    public MerkkiNappienKuuntelija() {
    }

    public void setSanakentta(JTextArea sanakentta) {
        this.sanakentta = sanakentta;
    }

    public void setNapit(MerkkiNappiRuudukko napit) {
        this.napit = napit;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (MerkkiNappi nappi : napit.getNapit()) {
            if (nappi == e.getSource()) {
                valitse(nappi);
                sanakentta.setText(sanakentta.getText() + nappi.getMerkki());

            }
        }
    }

    private void valitse(MerkkiNappi nappi) {
        nappi.setBackground(Color.CYAN);
        nappi.setEnabled(false);
        Pelilogiikka logiikka = nappi.getLogiikka();
        logiikka.getValitut().add(logiikka.getRuutu(nappi.haeY(), nappi.haeX())); 
    }

}
