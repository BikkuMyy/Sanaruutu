
package sanapeli.logiikka;

import java.util.ArrayList;


public interface Peliruudukko {
    
    Ruutu [][] getRuudukko();
    
    Ruutu getRuutu(int y, int x);
    
    ArrayList<Ruutu> getValitut();
//    Sisalto getSisalto();
    
//    void tyhjennaRuudunSisalto();

}
