package sanapeli.logiikka;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

/**
 * Luokka lukee saamansa tiedoston listaksi merkkijonoja.
 *
 */
public class Satunnaistaja {

    private InputStream tiedosto;
    private List<String> merkit;

    /**
     * Konstruktori.
     *
     * @param tiedostonNimi luettavan tiedoston nimi
     */
    public Satunnaistaja(String tiedostonNimi) {
        this.tiedosto = getClass().getResourceAsStream(tiedostonNimi);
        this.merkit = new ArrayList<>();
        lueTiedostoListaan();
    }

    /**
     * Metodi lukee tiedoston listaan tai tulostaa virheilmoituksen ja kutsuu
     * lisaaListanMerkit() -metodia jos lukeminen ei onnistu.
     */
    private void lueTiedostoListaan() {

        Scanner lukija = null;

        try {
            lukija = new Scanner(tiedosto, "UTF-8");
        } catch (Exception e) {
            lisaaListaanMerkit();
            System.out.println("Tiedoston lukeminen epäonnistui. Virhe: " + e.getMessage());
            return;
        }

        while (lukija.hasNextLine()) {
            this.merkit.add(lukija.nextLine());
        }

        lukija.close();
    }

    /**
     * Metodi sekoittaa listan ja palauttaa merkin sen ensimmäisestä indeksistä.
     *
     * @return satunnainen merkki
     */
    public String satunnainenMerkki() {
        Collections.shuffle(merkit);
        return merkit.get(0);
    }

    public List<String> getMerkit() {
        return merkit;
    }

    /**
     * Metodi lisää merkkijonon merkit listaan.
     */
    public void lisaaListaanMerkit() {
        String kirjaimet = "AAAAAAAAAAAAEEEEEEEEIIIIIIIIIIOOOOOUUUUUÄÄÄÄÄYYÖHHJJKKKKKLLLLLLMMMMNNNNNNNNPPRRRSSSSSSSSTTTTTTTTTVVDÖ";
        for (int i = 0; i < kirjaimet.length(); i++) {
            merkit.add("" + kirjaimet.charAt(i));

        }
    }

}
