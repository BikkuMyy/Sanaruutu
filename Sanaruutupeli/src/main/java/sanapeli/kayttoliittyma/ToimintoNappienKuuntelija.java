
package sanapeli.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import sanapeli.logiikka.Peliruudukko;
import sanapeli.logiikka.Ruutu;

public class ToimintoNappienKuuntelija implements ActionListener{
    private  JTextArea sanakentta;
    private Peliruudukko ruudukko;
    

    public ToimintoNappienKuuntelija(Peliruudukko ruudukko) {
        this.ruudukko = ruudukko;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ToimintoNappi nappi = (ToimintoNappi) e.getSource();
        if (nappi.getToiminto().equals("Tyhjennä")){
            for (Ruutu ruutu : ruudukko.getValitut()){
                // ruudun koordinaatteja vastaavilta napei
            }
            
        }
        this.sanakentta.setText("");
    }

    public void setSanakentta(JTextArea sanakentta) {
        this.sanakentta = sanakentta;
        
    }
    
    
    
    
    
}
