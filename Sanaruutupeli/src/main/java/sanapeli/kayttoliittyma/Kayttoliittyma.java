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

        JTextArea sanaKentta = new JTextArea("");
        sanaKentta.setPreferredSize(new Dimension(250, 50));
        alaosa.add(sanaKentta, BorderLayout.WEST);
        this.merkkiKuuntelija.setSanakentta(sanaKentta);
        this.toimintoKuuntelija.setSanakentta(sanaKentta);

        ToimintoNappi hyvaksy = luoToimintoNappi("Hyväksy");
        alaosa.add(hyvaksy, BorderLayout.CENTER);

        ToimintoNappi tyhjenna = luoToimintoNappi("Tyhjennä");
        alaosa.add(tyhjenna, BorderLayout.EAST);

        return alaosa;
    }

    private JPanel luoYlaosanKomponentit() {
        JPanel ylaosa = new JPanel(new GridLayout(koko, koko));
        ylaosa.setPreferredSize(new Dimension(500, 500));

        for (int i = 0; i < koko; i++) {
            for (int j = 0; j < koko; j++) {
                MerkkiNappi nappi = luoMerkkiNappi(i, j);
                ylaosa.add(nappi);
            }
        }
        return ylaosa;
    }
    
    private MerkkiNappi luoMerkkiNappi(int y, int x){
        MerkkiNappi nappi = new MerkkiNappi(y, x, ruudukko);
        nappi.setBackground(Color.LIGHT_GRAY);
        nappi.addActionListener(merkkiKuuntelija);
        
        return nappi;
    }
    
    private ToimintoNappi luoToimintoNappi(String toiminto){
        ToimintoNappi nappi = new ToimintoNappi(toiminto, ruudukko);
        nappi.setPreferredSize(new Dimension(125, 50));
        
        if (toiminto.equals("Tyhjennä")){
            nappi.setBackground(Color.red);
        } else {
            nappi.setBackground(Color.green);
        }
        
        nappi.addActionListener(toimintoKuuntelija);
        
        return nappi;
    }

}
