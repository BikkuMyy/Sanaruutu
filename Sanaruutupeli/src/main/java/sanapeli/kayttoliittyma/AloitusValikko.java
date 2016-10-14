package sanapeli.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

/**
 * Aloitusvalikko, keskeneräinen.
 *
 */
//-> cardLayout
public class AloitusValikko extends JDialog {

    private ButtonGroup vaihtoehdot;
    private JButton aloitaNappi;
    private DialoginKuuntelija kuuntelija;

    /**
     * Konstruktori.
     * @param ikkuna JFrame
     * @param modaalisuus true / false
     */
    
    public AloitusValikko(JFrame ikkuna, boolean modaalisuus) {
        super(ikkuna, modaalisuus);
        this.kuuntelija = new DialoginKuuntelija(aloitaNappi);
        this.aloitaNappi = new JButton("Aloita peli");
        luoJaNaytaAloitusDialogi();
    }

    private void luoJaNaytaAloitusDialogi() {
        setPreferredSize(new Dimension(100, 200));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(getContentPane());
        pack();
        setVisible(true);
    }

    private void luoKomponentit(Container container) {
        container.add(ohjeet(), BorderLayout.NORTH);
        container.add(new JLabel("Valitse ruudukon koko: "), BorderLayout.WEST);
        container.add(luoVaihtoehdot(), BorderLayout.EAST);
        container.add(aloitaNappi, BorderLayout.SOUTH);
    }

    private JPanel luoVaihtoehdot() {
        JPanel nappipaneeli = new JPanel();

        JRadioButton ve5 = new JRadioButton("5");
        JRadioButton ve7 = new JRadioButton("7");
        JRadioButton ve9 = new JRadioButton("9");
        JRadioButton ve11 = new JRadioButton("11");

        vaihtoehdot.add(ve5);
        vaihtoehdot.add(ve7);
        vaihtoehdot.add(ve9);
        vaihtoehdot.add(ve11);

        ve5.addActionListener(kuuntelija);
        ve7.addActionListener(kuuntelija);
        ve9.addActionListener(kuuntelija);
        ve11.addActionListener(kuuntelija);

        return nappipaneeli;
    }

    private JLabel ohjeet() {
        return new JLabel("Muodosta sanoja käyttämällä ruudukossa näkyviä kirjaimia. "
                + "Sana alkaa muodostua sitä mukaa sanakenttään. "
                + "Paina Hyväksy-nappia kun sana on valmis.  "
                + "Vain perusmuotoiset sanat kelpaavat. \n"
                + "Tyhjennä-nappi tyhjentää sanakentän ja napit ovat jälleen käytettävissä."
                + "Pistelasku: \n "
                + "Jokaisesta kirjaimesta saa 1-4 pistettä sen harviaisuuden mukaan."
                + "Mitä pitempiä sanoja teet, sitä enemmän pisteitä saat. \n"
                + "Peli loppuu kun ruudukko on tyhjä tai jäljellä olevista merkeistä ei voi enää muodostaa sanaa.");
    }
}
