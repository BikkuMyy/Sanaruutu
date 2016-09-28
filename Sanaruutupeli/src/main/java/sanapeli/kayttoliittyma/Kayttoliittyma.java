package sanapeli.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import sanapeli.logiikka.Peliruudukko;

public class Kayttoliittyma implements Runnable {

    private Peliruudukko ruudukko;
    private JFrame ikkuna;
    private int koko;
    private MerkkiNappienKuuntelija merkkiKuuntelija;
    private ToimintoNappienKuuntelija toimintoKuuntelija; 

    public Kayttoliittyma(int koko, Peliruudukko ruudukko) {
        this.ruudukko = ruudukko;
        this.merkkiKuuntelija = new MerkkiNappienKuuntelija(ruudukko);
        this.toimintoKuuntelija = new ToimintoNappienKuuntelija(ruudukko);
        this.koko = koko;
    }

    public Kayttoliittyma(Peliruudukko ruutu) {
        this(7, ruutu);
    }

    @Override
    public void run() {
        ikkuna = new JFrame("Sanaruutupeli");
        ikkuna.setPreferredSize(new Dimension(500, 550));

        ikkuna.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(ikkuna.getContentPane());

        ikkuna.pack();
        ikkuna.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        container.add(luoYlaosanKomponentit());
        container.add(luoAlaosanKomponentit(), BorderLayout.SOUTH);
    }

    private JPanel luoAlaosanKomponentit() {
        JPanel alaosa = new JPanel(new BorderLayout());
        alaosa.setPreferredSize(new Dimension(500, 50));

        JTextArea sanaKentta = luoSanakentta();
        alaosa.add(sanaKentta, BorderLayout.WEST);
        
        ToimintoNappi hyvaksy = luoToimintoNappi("Hyväksy");
        alaosa.add(hyvaksy, BorderLayout.CENTER);

        ToimintoNappi tyhjenna = luoToimintoNappi("Tyhjennä");
        alaosa.add(tyhjenna, BorderLayout.EAST);

        return alaosa;
    }
    
    private JTextArea luoSanakentta(){
        JTextArea sanaKentta = new JTextArea("");
        sanaKentta.setPreferredSize(new Dimension(250, 50));
        this.merkkiKuuntelija.setSanakentta(sanaKentta);
        this.toimintoKuuntelija.setSanakentta(sanaKentta);
        
        return sanaKentta;
    }
    
    private ToimintoNappi luoToimintoNappi(String toiminto){
        ToimintoNappi nappi = new ToimintoNappi(toiminto);
        nappi.setPreferredSize(new Dimension(125, 50));
        
        if (toiminto.equals("Tyhjennä")){
            nappi.setBackground(Color.red);
        } else {
            nappi.setBackground(Color.green);
        }
        
        nappi.addActionListener(toimintoKuuntelija);
        
        return nappi;
    }
    
    private JPanel luoYlaosanKomponentit(){
        MerkkiNappiRuudukko merkkiNappiRuudukko = new MerkkiNappiRuudukko(koko, 
            merkkiKuuntelija, ruudukko);
        merkkiKuuntelija.setNapit(merkkiNappiRuudukko);
        toimintoKuuntelija.setNapit(merkkiNappiRuudukko);
        JPanel ylaosa = merkkiNappiRuudukko.luoMerkkiNappiRuudukko();
        ylaosa.setPreferredSize(new Dimension(500, 500));
        
        return ylaosa;
    }

}
