package sanapeli.logiikka;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Pelialusta implements Peliruudukko {

    private Ruutu[][] ruudukko;
    private ValitutRuudut valitut;

    public Pelialusta(int koko) {
        this.ruudukko = new Ruutu[koko][koko];
        this.valitut = new ValitutRuudut();
    }

    public Pelialusta() {
        this(7);
    }

    public void luoAlkuTilanne() throws FileNotFoundException {
        lisaaAlustaanRuudut();
        lisaaAlkuMerkit();
    }

    public void lisaaAlustaanRuudut() throws FileNotFoundException {
        for (int y = 0; y < (this.ruudukko.length); y++) {
            for (int x = 0; x < (this.ruudukko[y].length); x++) {
                this.ruudukko[y][x] = new Ruutu(y, x);
            }
        }
    }

    public void lisaaAlkuMerkit() throws FileNotFoundException {
        for (int y = (ruudukko.length / 2 - 1); y <= (this.ruudukko.length / 2 + 1); y++) {
            for (int x = (this.ruudukko[y].length / 2 - 1); x <= (this.ruudukko[y].length / 2 + 1); x++) {
                ruudukko[y][x].lisaaRuutuunSisalto();
            }
        }
    }

//    public void tulostaTilanne() {
//        for (int y = 0; y < (this.ruudukko.length); y++) {
//            for (int x = 0; x < (this.ruudukko[y].length); x++) {
//                Ruutu ruutu = ruudukko[y][x];
//                
//                if (ruutu.getSisalto() == null) {
//                    System.out.print("*");
//                } else {
//                    System.out.print(ruutu.toString());
//                }
//            }
//            System.out.println("");
//        }
//    }
    @Override
    public Ruutu[][] getRuudukko() {
        return ruudukko;
    }
    
    @Override
    public Ruutu getRuutu(int y, int x){
        return ruudukko[y][x];
    }

    @Override
    public ArrayList<Ruutu> getValitut() {
        return valitut.getValitut();
    }


}
