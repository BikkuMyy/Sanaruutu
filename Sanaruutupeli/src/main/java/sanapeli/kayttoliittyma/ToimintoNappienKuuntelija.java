
package sanapeli.kayttoliittyma;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import sanapeli.logiikka.Peliruudukko;
import sanapeli.logiikka.Ruutu;

public class ToimintoNappienKuuntelija implements ActionListener{
    private  JTextArea sanakentta;
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
        if (nappi.getToiminto().equals("Tyhjennä")){
            for (Ruutu ruutu : ruudukko.getValitut()){
                napit.haeMerkkiNappi(ruutu.getY(), ruutu.getX()).setBackground(Color.LIGHT_GRAY);
            }
        }
        //hyväksy-napin toiminto tähän
        this.sanakentta.setText("");
    }

    public void setSanakentta(JTextArea sanakentta) {
        this.sanakentta = sanakentta;
        
    }
    
    
    
    
    
}
