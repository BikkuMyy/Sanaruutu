package sanapeli.kayttoliittyma;

import javax.swing.JButton;
import sanapeli.logiikka.Peliruudukko;

public class MerkkiNappi extends JButton {

    private Peliruudukko ruudukko;
    private String merkki;
    private  int y;
    private int x;

    public MerkkiNappi(int y, int x, Peliruudukko ruudukko) {
        this.ruudukko = ruudukko;
        this.y = y;
        this.x = x;
        super.setText(this.merkki = haeNappiinMerkkiRuudusta());

    }

    public String getMerkki() {
        return this.merkki;
    }

    private String haeNappiinMerkkiRuudusta() {
        return ruudukko.getRuudukko()[y][x].toString();

    }

   
    public int haeX() {
        return this.x;
    }

    
    public int haeY() {
        return this.y;
    }
    
    

}
