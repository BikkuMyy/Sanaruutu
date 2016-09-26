
package sanapeli.kayttoliittyma;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import sanapeli.logiikka.Peliruudukko;


public class MerkkiNappienKuuntelija implements ActionListener {
    private JTextArea sanakentta;
    private Peliruudukko ruudukko;

    public MerkkiNappienKuuntelija(Peliruudukko ruudukko) {
        this.ruudukko = ruudukko;
    }

    public void setSanakentta(JTextArea sanakentta) {
        this.sanakentta = sanakentta;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        MerkkiNappi nappi = (MerkkiNappi) e.getSource();
        nappi.setBackground(Color.CYAN);
        System.out.println(nappi.getY());
        System.out.println(nappi.getX());
        //ruudukko.getValitut().add(ruudukko.getRuutu(nappi.getY(), nappi.getX()));
        sanakentta.setText(sanakentta.getText() + nappi.getMerkki());
        
    }
    
}
