package sanapeli.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import sanapeli.logiikka.Peliruudukko;

/**
 * Luokka vastaa ohjelman graafisen käyttöliittymän luomisesta ja ylläpidosta.
 *
 */
public class Kayttoliittyma implements Runnable {

    private Peliruudukko hallinta;
    private JFrame ikkuna;
    private int koko;
    private MerkkiNappienKuuntelija merkkiKuuntelija;
    private ToimintoNappienKuuntelija toimintoKuuntelija;

    /**
     * Konstruktori 1.
     * @param koko luotavan peliruudukon sivun pituus ruuduissa 
     * @param pelinhallinta Peliruudukko-rajapinnan ilmentymä
     */
    public Kayttoliittyma(int koko, Peliruudukko pelinhallinta) {
        this.hallinta = pelinhallinta;
        this.merkkiKuuntelija = new MerkkiNappienKuuntelija();
        this.toimintoKuuntelija = new ToimintoNappienKuuntelija(pelinhallinta);
        this.koko = koko;
    }

    /**
     * Konstrukrori 2, luo oletuskokoisen ruudukon.
     * @param sanapeli Peliruudukko-rajapinnan ilmentymä
     */
    public Kayttoliittyma(Peliruudukko sanapeli) {
        this(7, sanapeli);
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

    /**
     * Metodi luo ikkunan läyttöliittymäkomponentit ja lisää ne
     * Container-olioon.
     *
     * @param container
     */
    private void luoKomponentit(Container container) {
        container.add(luoYlaosanKomponentit());
        container.add(luoAlaosanKomponentit(), BorderLayout.SOUTH);
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
     * Metodi luo ikkunan yläosan komponentit.
     *
     * @return JPanel
     */
    private JPanel luoYlaosanKomponentit() {
        MerkkiNappiRuudukko merkkiNappiRuudukko = new MerkkiNappiRuudukko(koko,
                merkkiKuuntelija, hallinta);
        
        merkkiKuuntelija.setNapit(merkkiNappiRuudukko);
        toimintoKuuntelija.setNapit(merkkiNappiRuudukko);
        JPanel ylaosa = merkkiNappiRuudukko.luoMerkkiNappiRuudukko();
        ylaosa.setPreferredSize(new Dimension(500, 500));

        return ylaosa;
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
        this.merkkiKuuntelija.setSanakentta(sanaKentta);
        this.toimintoKuuntelija.setSanakentta(sanaKentta);

        return sanaKentta;
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

        if (toiminto.equals("Tyhjennä")) {
            nappi.setBackground(Color.red);
        } else {
            nappi.setBackground(Color.green);
        }

        nappi.addActionListener(toimintoKuuntelija);

        return nappi;
    }
}
