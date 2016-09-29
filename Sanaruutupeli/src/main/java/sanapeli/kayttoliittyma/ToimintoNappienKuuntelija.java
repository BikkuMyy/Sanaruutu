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
 * @author mari
 */
public class ToimintoNappienKuuntelija implements ActionListener {

    private JTextArea sanakentta;
    private Peliruudukko ruudukko;
    private MerkkiNappiRuudukko napit;

    public ToimintoNappienKuuntelija(Peliruudukko ruudukko) {
        this.ruudukko = ruudukko;
    }

    public void setNapit(MerkkiNappiRuudukko napit) {
        this.napit = napit;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ToimintoNappi nappi = (ToimintoNappi) e.getSource();
        
        if (nappi.getToiminto().equals("Tyhjennä")) {
            for (Ruutu ruutu : ruudukko.getValitut()) {
                
                napit.haeMerkkiNappi(ruutu.getY(), ruutu.getX()).setEnabled(true);
                napit.haeMerkkiNappi(ruutu.getY(), ruutu.getX()).setBackground(Color.LIGHT_GRAY);
            }
            
        }
        //ei toimi vileä kunnolla    
        if (nappi.getToiminto().equals("Hyväksy")) {
            for (Ruutu ruutu : ruudukko.getValitut()) {
                System.out.println(ruutu.toString());
                napit.poistaMerkkiNappi(ruutu.getY(), ruutu.getX());
            }

        }
        this.sanakentta.setText("");
        ruudukko.getValitut().clear();

    }

    public void setSanakentta(JTextArea sanakentta) {
        this.sanakentta = sanakentta;

    }

}
