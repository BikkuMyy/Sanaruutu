
package sanapeli.kayttoliittyma;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;


public class KlikkaustenKuuntelija implements ActionListener {
    private JTextArea sanakentta;

    public KlikkaustenKuuntelija() {
    }

    public void setSanakentta(JTextArea sanakentta) {
        this.sanakentta = sanakentta;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Nappi nappi = (Nappi) e.getSource();
        nappi.setBackground(Color.CYAN);
        sanakentta.setText(sanakentta.getText() + nappi.getMerkki());
        
    }
    
}
