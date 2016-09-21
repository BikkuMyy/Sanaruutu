
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



public class Kayttoliittyma implements Runnable {
    
    private JFrame ruudukko;
    private int koko;

    public Kayttoliittyma(int koko) {
        this.koko = koko;
    }

    public Kayttoliittyma() {
        this.koko = 7;
    }
    

    @Override
    public void run() {
        ruudukko = new JFrame("Sanaruutupeli");
        ruudukko.setPreferredSize(new Dimension(500,500));
        
        ruudukko.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(ruudukko.getContentPane());

        ruudukko.pack();
        ruudukko.setVisible(true);
    }
    
    private void luoKomponentit(Container container) {
        container.setLayout(new GridLayout(koko, koko));
        
        
        for (int i = 0; i < koko; i++) {
            for (int j = 0; j < koko; j++) {
                Nappi nappi = new Nappi(i, j);
                KlikkaustenKuuntelija kuuntelija = new KlikkaustenKuuntelija(nappi);
                container.add(nappi);
                nappi.addActionListener(kuuntelija);
                
            }
            
        }
        
        //container.add(luoAlaosanKomponentit(), BorderLayout.SOUTH);
        
        
    }
    
    private JPanel luoAlaosanKomponentit(){
        JPanel alaosa = new JPanel(new GridLayout(1, 3));
        JTextArea sanaKentta = new JTextArea("");
        alaosa.add(sanaKentta);
        alaosa.add(new JButton("Hyväksy"));
        alaosa.add(new JButton("Poista"));
        
        return alaosa;
    }
    
    
}
