package sanapeli.logiikka;

import javax.swing.SwingUtilities;
import sanapeli.kayttoliittyma.Kayttoliittyma;

public class Main {

    /**
     * Main-metodi.
     *
     * @param args args
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Kayttoliittyma());

    }

}
