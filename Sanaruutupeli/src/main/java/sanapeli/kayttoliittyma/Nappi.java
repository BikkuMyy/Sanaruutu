package sanapeli.kayttoliittyma;

import javax.swing.JButton;
import sanapeli.logiikka.Sanaruutu;

public class Nappi extends JButton {

    private Sanaruutu sanaruutu;
    private String merkki;
    private int y;
    private int x;

    public Nappi(int y, int x, Sanaruutu ruutu) {
        this.sanaruutu = ruutu;
        this.y = y;
        this.x = x;
//        super.setText(this.merkki = ":D");
        super.setText(this.merkki = haeNappiinMerkkiRuudusta());
        
    }
    
    public String getMerkki(){
        return this.merkki;
    }

    private String haeNappiinMerkkiRuudusta() {
        return sanaruutu.getRuudukko()[y][x].toString();

    }

}
