package sanapeli.kayttoliittyma;

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
    }

    public String getToiminto() {
        return toiminto;
    }

}
