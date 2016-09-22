package sanapeli.kayttoliittyma;

import javax.swing.JButton;
import sanapeli.logiikka.Peliruudukko;

public class Nappi extends JButton {

    private Peliruudukko ruudukko;
    private String merkki;
    private int y;
    private int x;

    public Nappi(int y, int x, Peliruudukko ruudukko) {
        this.ruudukko = ruudukko;
        this.y = y;
        this.x = x;
        super.setText(this.merkki = haeNappiinMerkkiRuudusta());
        
    }
    
    public String getMerkki(){
        return this.merkki;
    }

    private String haeNappiinMerkkiRuudusta() {
        return ruudukko.getRuudukko()[y][x].toString();

    }

}
