package sanapeli.kayttoliittyma;

import javax.swing.JButton;
import sanapeli.logiikka.Sanaruutu;

public class Nappi extends JButton {

    private Sanaruutu sanaruutu;
    private String merkki;
    private int y;
    private int x;

    public Nappi(int y, int x) {
        this.y = y;
        this.x = x;
        super.setText(this.merkki = ":D");
        
    }

//    private String haeNappiinMerkkiRuudusta() {
//        return sanaruutu.getRuudukko()[y][x].getSisalto().toString();
//
//    }

}
