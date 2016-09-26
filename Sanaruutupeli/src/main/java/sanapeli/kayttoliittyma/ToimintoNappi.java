
package sanapeli.kayttoliittyma;

import javax.swing.JButton;
import sanapeli.logiikka.Peliruudukko;


public class ToimintoNappi extends JButton{
    private Peliruudukko ruudukko;
    private String toiminto;

    public ToimintoNappi(String toiminto, Peliruudukko ruudukko) {
        super.setText(this.toiminto = toiminto);
        this.ruudukko = ruudukko;
    }

    public String getToiminto() {
        return toiminto;
    }
    
    
}
