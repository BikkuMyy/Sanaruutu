package sanapeli.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

/**
 * Aloitusvalikko, keskeneräinen.
 *
 */
public class AloitusValikko extends JFrame {

    private ButtonGroup vaihtoehdot;
    private JButton aloitaNappi;
    private DialoginKuuntelija kuuntelija;
    private Kayttoliittyma kayttis;

    /**
     * Konstruktori.
     * @param kayttis Viittaus Kayttoliittyma-luokkaan
     */
    public AloitusValikko(Kayttoliittyma kayttis) {
        this.kayttis = kayttis;
        this.vaihtoehdot = new ButtonGroup();
        this.aloitaNappi = new JButton("Aloita peli");
        this.kuuntelija = new DialoginKuuntelija(aloitaNappi, this.kayttis);
        luoJaNaytaAloitusValikko();
    }

    private void luoJaNaytaAloitusValikko() {
        super.setPreferredSize(new Dimension(500, 300));
        super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(super.getContentPane());
        super.pack();
        super.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        
        container.add(ohjeet(), BorderLayout.NORTH);
        container.add(new JLabel("Valitse ruudukon koko: "), BorderLayout.WEST);
        container.add(luoVaihtoehdot(), BorderLayout.CENTER);
        aloitaNappi.addActionListener(kuuntelija);
        container.add(aloitaNappi, BorderLayout.SOUTH);
    }

    private JPanel luoVaihtoehdot() {
        JPanel nappipaneeli = new JPanel(new GridLayout(0, 1));

        JRadioButton ve5 = new JRadioButton("5");
        ve5.setActionCommand("5");
        JRadioButton ve7 = new JRadioButton("7");
        ve7.setActionCommand("7");
        ve7.setSelected(true);
        JRadioButton ve9 = new JRadioButton("9");
        ve9.setActionCommand("9");
        JRadioButton ve11 = new JRadioButton("11");
        ve11.setActionCommand("11");

        vaihtoehdot.add(ve5);
        vaihtoehdot.add(ve7);
        vaihtoehdot.add(ve9);
        vaihtoehdot.add(ve11);

        ve5.addActionListener(kuuntelija);
        ve7.addActionListener(kuuntelija);
        ve9.addActionListener(kuuntelija);
        ve11.addActionListener(kuuntelija);
        
        nappipaneeli.add(ve5);
        nappipaneeli.add(ve7);
        nappipaneeli.add(ve9);
        nappipaneeli.add(ve11);

        return nappipaneeli;
    }

    private JTextArea ohjeet() {
        JTextArea ohjeet = new JTextArea("Muodosta sanoja käyttämällä ruudukossa näkyviä kirjaimia. \n"
                + "Paina Hyväksy-nappia kun sana on valmis. "
                + "Vain perusmuotoiset sanat kelpaavat! \n"
                + "Tyhjennä-nappi tyhjentää sanakentän ja napit ovat jälleen käytettävissä. \n"
                + "Pistelasku: \n"
                + "- Jokaisesta kirjaimesta saa 1-4 pistettä sen harviaisuuden mukaan.\n"
                + "- Mitä pitempiä sanoja teet, sitä enemmän pisteitä saat. \n"
                + "Peli loppuu kun ruudukko on tyhjä tai jäljellä olevista merkeistä ei voi enää muodostaa sanaa.");
        ohjeet.setPreferredSize(new Dimension(200, 150));
        ohjeet.setWrapStyleWord(true);
        ohjeet.setLineWrap(true);
        ohjeet.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
        
        return ohjeet;
    }
}
