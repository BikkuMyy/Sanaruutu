
package sanapeli.kayttoliittyma;

import javax.swing.JButton;


public class ToimintoNappi extends JButton{
    private String toiminto;

    public ToimintoNappi(String toiminto) {
        super.setText(this.toiminto = toiminto);
    }

    public String getToiminto() {
        return toiminto;
    }
    
    
}
