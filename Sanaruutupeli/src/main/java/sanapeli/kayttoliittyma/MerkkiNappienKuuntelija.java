
package sanapeli.kayttoliittyma;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import sanapeli.logiikka.Peliruudukko;


public class MerkkiNappienKuuntelija implements ActionListener {
    private JTextArea sanakentta;
    private Peliruudukko ruudukko;
    private MerkkiNappiRuudukko napit;

    public MerkkiNappienKuuntelija(Peliruudukko ruudukko) {
        this.ruudukko = ruudukko;
    }

    public void setSanakentta(JTextArea sanakentta) {
        this.sanakentta = sanakentta;
    }

    public void setNapit(MerkkiNappiRuudukko napit) {
        this.napit = napit;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        for (MerkkiNappi nappi : napit.getNapit()){
            if (nappi == e.getSource()){
                nappi.setBackground(Color.CYAN);
                sanakentta.setText(sanakentta.getText() + nappi.getMerkki());
                ruudukko.getValitut().add(ruudukko.getRuutu(nappi.haeY(), nappi.haeX()));
            }
        }
        
//        MerkkiNappi nappi = (MerkkiNappi) e.getSource();
//        nappi.setBackground(Color.CYAN);
//        ruudukko.getValitut().add(ruudukko.getRuutu(nappi.getY(), nappi.getX()));
//        sanakentta.setText(sanakentta.getText() + nappi.getMerkki());
        
    }
    
}
