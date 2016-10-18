package sanapeli.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 * Tapahtumienkuuntelija aloitusvalikolle,
 * mahdollistaa ruudukon koon valinnan ja pelin aloittamisen.
 *
 */
public class DialoginKuuntelija implements ActionListener {

    private JButton aloitaNappi;
    private Kayttoliittyma kayttis;
    
    /**
     * Konstruktori.
     * @param aloita aloitusnappi
     * @param kayttis viittaus Kayttoliittymaan
     */
    public DialoginKuuntelija(JButton aloita, Kayttoliittyma kayttis) {
        this.aloitaNappi = aloita;
        this.kayttis = kayttis;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(aloitaNappi)){
            kayttis.aloitaPeli();
        } else{
            kayttis.setKoko(Integer.parseInt(e.getActionCommand()));
        } 
    }
    
}
