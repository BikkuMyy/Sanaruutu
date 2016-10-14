package sanapeli.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 * Tapahtumienkuuntelija aloitusvalikolle, keskeneräinen.
 *
 */
public class DialoginKuuntelija implements ActionListener {

    private JButton aloitaNappi;
    private int maara;
    
    /**
     * Konstruktori.
     * @param aloita aloitusnappi 
     */
    public DialoginKuuntelija(JButton aloita) {
        this.maara = 0;
        this.aloitaNappi = aloita;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    public int getMaara() {
        return maara;
    }

}
