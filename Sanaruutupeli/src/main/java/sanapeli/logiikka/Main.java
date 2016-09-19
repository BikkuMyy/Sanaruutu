package sanapeli.logiikka;

import java.io.FileNotFoundException;
import javax.swing.SwingUtilities;
import sanapeli.kayttoliittyma.Kayttoliittyma;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Sanapeli peli = new Sanapeli();
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma();
        SwingUtilities.invokeLater(kayttoliittyma);
        peli.kaynnista();

    }

}
