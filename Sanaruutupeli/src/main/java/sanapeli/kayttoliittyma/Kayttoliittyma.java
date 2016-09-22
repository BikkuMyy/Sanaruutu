
package sanapeli.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import sanapeli.logiikka.Peliruudukko;


public class Kayttoliittyma implements Runnable {
    private Peliruudukko ruudukko;
    private JFrame ikkuna;
    private int koko;
    private MerkkiNappienKuuntelija kuuntelija;

    public Kayttoliittyma(int koko, Peliruudukko ruudukko) {
        this.ruudukko = ruudukko;
        this.kuuntelija = new MerkkiNappienKuuntelija();
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
    
    private JPanel luoAlaosanKomponentit(){
        JPanel alaosa = new JPanel(new BorderLayout());
        alaosa.setPreferredSize(new Dimension(500, 50));
        
        JTextArea sanaKentta = new JTextArea("");
        sanaKentta.setPreferredSize(new Dimension(250, 50));
        alaosa.add(sanaKentta, BorderLayout.WEST);
        this.kuuntelija.setSanakentta(sanaKentta);
        
        JButton hyvaksy = new JButton("Hyväksy");
        hyvaksy.setPreferredSize(new Dimension(125, 50));
        alaosa.add(hyvaksy, BorderLayout.CENTER);
        
        JButton tyhjenna = new JButton("Tyhjennä");
        tyhjenna.setPreferredSize(new Dimension(125, 50));
        alaosa.add(tyhjenna, BorderLayout.EAST);
        
        return alaosa;
    }
    
    private JPanel luoYlaosanKomponentit(){
        JPanel ylaosa = new JPanel(new GridLayout(7,7));
        ylaosa.setPreferredSize(new Dimension(500,500));
        
        for (int i = 0; i < koko; i++) {
            for (int j = 0; j < koko; j++) {
                Nappi nappi = new Nappi(i, j, ruudukko);
                ylaosa.add(nappi);
                nappi.addActionListener(kuuntelija);
            }
        }
        return ylaosa;
    }
    
}
