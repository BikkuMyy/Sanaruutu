
package sanapeli.kayttoliittyma;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


public class KlikkaustenKuuntelija implements ActionListener {
    private JButton nappi;

    public KlikkaustenKuuntelija(JButton nappi) {
        this.nappi = nappi;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        this.nappi.setBackground(Color.CYAN);
        
    }
    
}
