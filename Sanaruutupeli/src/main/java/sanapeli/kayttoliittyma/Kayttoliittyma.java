
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
import sanapeli.logiikka.Sanaruutu;



public class Kayttoliittyma implements Runnable {
    private Sanaruutu sanaruutu;
    private JFrame ruudukko;
    private int koko;
    private KlikkaustenKuuntelija kuuntelija;

    public Kayttoliittyma(int koko, Sanaruutu ruutu) {
        this.sanaruutu = ruutu;
        this.kuuntelija = new KlikkaustenKuuntelija();
        this.koko = koko;
    }

    public Kayttoliittyma(Sanaruutu ruutu) {
        this(7, ruutu);
    }
    

    @Override
    public void run() {
        ruudukko = new JFrame("Sanaruutupeli");
        ruudukko.setPreferredSize(new Dimension(500, 550));
        
        ruudukko.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(ruudukko.getContentPane());

        ruudukko.pack();
        ruudukko.setVisible(true);
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
        
        JButton poista = new JButton("Poista");
        poista.setPreferredSize(new Dimension(125, 50));
        alaosa.add(poista, BorderLayout.EAST);
        
        return alaosa;
    }
    
    private JPanel luoYlaosanKomponentit(){
        JPanel ylaosa = new JPanel(new GridLayout(7,7));
        ylaosa.setPreferredSize(new Dimension(500,500));
        
        for (int i = 0; i < koko; i++) {
            for (int j = 0; j < koko; j++) {
                Nappi nappi = new Nappi(i, j, sanaruutu);
                ylaosa.add(nappi);
                nappi.addActionListener(kuuntelija);
                
            }
            
        }
        return ylaosa;
    }
    
}
