package sanapeli.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

/**
 * Luokka luo pelin sisältävän ikkunan.
 * @author mari
 */
public class PeliIkkuna extends JFrame {

    private Kayttoliittyma kayttis;
    private MerkkiNappienKuuntelija merkkiKuuntelija;
    private ToimintoNappienKuuntelija toimintoKuuntelija;
    private int koko;

    /**
     * Konstruktori.
     * @param kayttis viittaus käyttöliittymään
     * @param koko peliruudukon koko
     */
    public PeliIkkuna(Kayttoliittyma kayttis, int koko) {
        this.kayttis = kayttis;
        this.koko = koko;
        this.merkkiKuuntelija = new MerkkiNappienKuuntelija();
        this.toimintoKuuntelija = new ToimintoNappienKuuntelija(this.kayttis);
        luoJaNaytaPeliIkkuna();
    }

    private void luoJaNaytaPeliIkkuna() {
        super.setPreferredSize(new Dimension(500, 600));
        super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(super.getContentPane());

        super.pack();
        super.setVisible(true);
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
                merkkiKuuntelija, kayttis.getLogiikka());

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
