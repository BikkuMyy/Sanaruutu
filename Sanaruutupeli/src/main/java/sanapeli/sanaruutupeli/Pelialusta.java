package sanapeli.sanaruutupeli;

import java.io.FileNotFoundException;

public class Pelialusta {

    private Ruutu [][] ruudukko;

    public Pelialusta() {
        this.ruudukko = new Ruutu[7][7];
    }

    public Pelialusta(int koko) {
        this.ruudukko = new Ruutu[koko][koko];
    }

    public void luoAlkuTilanne() throws FileNotFoundException {
        for (int y = (ruudukko.length / 2 - 1); y <= (this.ruudukko.length / 2 + 1); y++) {
            for (int x = (this.ruudukko[y].length / 2 - 1); x <= (this.ruudukko[y].length / 2 + 1); x++) {
                lisaaRuutuunSisalto(y, x);
            }
        }
    }

    public void lisaaRuutuunSisalto(int y, int x) throws FileNotFoundException {
        this.ruudukko[y][x] = new Ruutu(y, x);
    }
    
    public void tulostaTilanne(){
        for (int y = 0; y < (this.ruudukko.length); y++) {
            for (int x = 0; x < (this.ruudukko[y].length); x++) {
                Object ruutu = ruudukko[y][x];
                
                if (ruutu == null){
                    System.out.print("X");
                } else {
                    System.out.print(ruutu.toString());
                }
            }
            System.out.println("");
        }
    }

    public Object[][] getRuudukko() {
        return ruudukko;
    }
    
    

}
