package sanapeli.logiikka;

import java.util.ArrayList;

/**
 * Luokka tallentaa käyttöliittymässä klikatut ruudut.
 *
 * @author mari
 */
public class ValitutRuudut {

    private ArrayList<Ruutu> valitut;

    public ValitutRuudut() {
        this.valitut = new ArrayList();
    }

    public ArrayList<Ruutu> getValitut() {
        return valitut;
    }

}
