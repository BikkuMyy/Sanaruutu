package sanapeli.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import sanapeli.logiikka.Pelilogiikka;

/**
 * Luokka vastaa ohjelman graafisen käyttöliittymän luomisesta ja ylläpidosta.
 *
 */
public class Kayttoliittyma implements Runnable {

    private Pelilogiikka hallinta;
    private JFrame ikkuna;
    private int koko;
    private MerkkiNappienKuuntelija merkkiKuuntelija;
    private ToimintoNappienKuuntelija toimintoKuuntelija;

    /**
     * Konstruktori 1.
     *
     * @param koko luotavan peliruudukon sivun pituus ruuduissa
     * @param pelinhallinta Peliruudukko-rajapinnan ilmentymä
     */
    public Kayttoliittyma(int koko, Pelilogiikka pelinhallinta) {
        this.hallinta = pelinhallinta;
        this.merkkiKuuntelija = new MerkkiNappienKuuntelija();
        this.toimintoKuuntelija = new ToimintoNappienKuuntelija(pelinhallinta);
        this.koko = koko;
    }

    /**
     * Konstrukrori 2, luo oletuskokoisen ruudukon.
     *
     * @param hallinta Peliruudukko-rajapinnan ilmentymä
     */
    public Kayttoliittyma(Pelilogiikka hallinta) {
        this(7, hallinta);
    }

    @Override
    public void run() {
        JOptionPane aloitusikkuna = new JOptionPane("Aloitus");
        aloitusikkuna.setVisible(true);
        ikkuna = new JFrame("Sanaruutupeli");
        ikkuna.setPreferredSize(new Dimension(500, 600));
        ikkuna.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(ikkuna.getContentPane());

        ikkuna.pack();
        ikkuna.setVisible(false);
    }

    /**
     * Metodi luo ikkunan läyttöliittymäkomponentit ja lisää ne
     * Container-olioon.
     *
     * @param container
     */
    private void luoKomponentit(Container container) {
        container.add(luoYlaosanKomponentit(), BorderLayout.NORTH);
        container.add(luoRuudukkoKomponentti());
        container.add(luoAlaosanKomponentit(), BorderLayout.SOUTH);
    }
    
    /**
     * Metodi luo ikkunan yläosan komponentit.
     * 
     * @return JPanel
     */
    private JPanel luoYlaosanKomponentit() {
        JPanel ylaosa = new JPanel(new BorderLayout());
        ylaosa.setPreferredSize(new Dimension(500, 50));
        
        ylaosa.add(luoPistekentta(), BorderLayout.WEST);
        ylaosa.add(luoToimintoNappi("Lopeta"), BorderLayout.EAST);
        
        return ylaosa;
    }
    
     /**
     * Metodi luo ikkunan ruudukkokomponentin.
     *
     * @return JPanel
     */
    private JPanel luoRuudukkoKomponentti() {
        MerkkiNappiRuudukko merkkiNappiRuudukko = new MerkkiNappiRuudukko(koko,
                merkkiKuuntelija, hallinta);

        merkkiKuuntelija.setNapit(merkkiNappiRuudukko);
        toimintoKuuntelija.setNapit(merkkiNappiRuudukko);
        JPanel ruudukko = merkkiNappiRuudukko.luoMerkkiNappiRuudukko();
        ruudukko.setPreferredSize(new Dimension(500, 500));

        return ruudukko;
    }

    /**
     * Metodi luo ikkunan alaosan komponentit.
     *
     * @return JPanel
     */
    private JPanel luoAlaosanKomponentit() {
        JPanel alaosa = new JPanel(new BorderLayout());
        alaosa.setPreferredSize(new Dimension(500, 50));

        alaosa.add(luoSanakentta(), BorderLayout.WEST);
        alaosa.add(luoToimintoNappi("Hyväksy"), BorderLayout.CENTER);
        alaosa.add(luoToimintoNappi("Tyhjennä"), BorderLayout.EAST);

        return alaosa;
    }

    /**
     * Metodi luo JTextArea-tyyppisen kentän ja lisää sen
     * tapahtumienkäsittelijöille.
     *
     * @return JTextArea
     */
    private JTextArea luoSanakentta() {
        JTextArea sanaKentta = new JTextArea("");
        sanaKentta.setPreferredSize(new Dimension(250, 50));
        sanaKentta.setEditable(false);
        sanaKentta.setFont(new Font("Monospaced", Font.PLAIN, 20));
        this.merkkiKuuntelija.setSanakentta(sanaKentta);
        this.toimintoKuuntelija.setSanakentta(sanaKentta);

        return sanaKentta;
    }
    
    private JTextArea luoPistekentta() {
        JTextArea pisteKentta = new JTextArea("");
        pisteKentta.setPreferredSize(new Dimension(250, 50));
        pisteKentta.setEditable(false);
        pisteKentta.setText("0");
        pisteKentta.setFont(new Font("Monospaced", Font.PLAIN, 20));
        this.toimintoKuuntelija.setPistekentta(pisteKentta);
        

        return pisteKentta;
    }

    /**
     * Metodi luo parametrinaan saamaansa toimintoa vastaavan napin ja lisää
     * sille tapahtumankäsittelijän.
     *
     * @param toiminto
     *
     * @return ToimintoNappi
     */
    private ToimintoNappi luoToimintoNappi(String toiminto) {
        ToimintoNappi nappi = new ToimintoNappi(toiminto);
        nappi.setPreferredSize(new Dimension(125, 50));

        if (toiminto.equals("Hyväksy")) {
            nappi.setBackground(Color.green);
        } else {
            nappi.setBackground(Color.red);
        }

        nappi.addActionListener(toimintoKuuntelija);

        return nappi;
    }

    
}
