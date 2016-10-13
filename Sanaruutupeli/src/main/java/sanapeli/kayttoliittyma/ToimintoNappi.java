package sanapeli.kayttoliittyma;

import java.awt.Font;
import javax.swing.JButton;

/**
 * Luokka sisältää nappinsa toiminnon.
 *
 */
public class ToimintoNappi extends JButton {

    private String toiminto;
    
    /**
     * Konstruktori.
     * @param toiminto  napin saama toiminto
     */
    public ToimintoNappi(String toiminto) {
        super.setText(this.toiminto = toiminto);
        super.setFont(new Font("Monospaced", Font.BOLD, 15));
    }

    public String getToiminto() {
        return toiminto;
    }

}
