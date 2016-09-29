
package sanapeli.kayttoliittyma;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import sanapeli.logiikka.Peliruudukko;

/**
 * Luokka luo ja säilyttää MerkkiNappi-olioita ja niiden koordinaatteja.
 * @author mari
 */


public class MerkkiNappiRuudukko {
    private int koko;
    private ArrayList<MerkkiNappi> napit;
    private MerkkiNappienKuuntelija merkkiKuuntelija;
    private Peliruudukko ruudukko;

    
    public MerkkiNappiRuudukko(int koko, MerkkiNappienKuuntelija kuuntelija,
            Peliruudukko ruudukko) {
        this.koko = koko;
        this.napit = new ArrayList();
        this.merkkiKuuntelija = kuuntelija;
        this.ruudukko = ruudukko;
    }
    
    public JPanel luoMerkkiNappiRuudukko(){
        JPanel merkkiRuudukko = new JPanel(new GridLayout(koko, koko));
        for (int i = 0; i < koko; i++) {
            for (int j = 0; j < koko; j++) {
                MerkkiNappi nappi = luoMerkkiNappi(i, j);
                napit.add(nappi);
                merkkiRuudukko.add(nappi);
            }
        }
        
        return merkkiRuudukko;
    }
    
    private MerkkiNappi luoMerkkiNappi(int y, int x){
        MerkkiNappi nappi = new MerkkiNappi(y, x, ruudukko);
        nappi.setBackground(Color.LIGHT_GRAY);
        nappi.addActionListener(merkkiKuuntelija);
        
        return nappi;
    }
    
    public MerkkiNappi haeMerkkiNappi(int y, int x){
        int indeksi = y * koko + x;
        return napit.get(indeksi);
    }
    
    public void poistaMerkkiNappi(int y, int x){
        MerkkiNappi nappi = haeMerkkiNappi(y, x);
        nappi.setText("");
        nappi.setBackground(Color.MAGENTA);
        nappi.setEnabled(false);
        ruudukko.getRuutu(y, x).tyhjennaRuudunSisalto();
        napit.remove(nappi);
    }

    public ArrayList<MerkkiNappi> getNapit() {
        return napit;
    }
   
    
    
}
