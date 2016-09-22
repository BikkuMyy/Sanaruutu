
package sanapeli.kayttoliittyma;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;


public class MerkkiNappienKuuntelija implements ActionListener {
    private JTextArea sanakentta;

    public MerkkiNappienKuuntelija() {
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
