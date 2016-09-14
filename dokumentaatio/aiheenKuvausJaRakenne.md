##Aihemäärittely

**Aihe:** Sanaruudukkopeli

Toteutetaan sanapeli, jossa pelaajan tavoite on tyhjentää ruudukko kirjaimista muodostamalla niistä sanoja.

Pelialustana toimii ruudukko, jonka jokaiseen ruutuun liittyy sattumanvarainen kirjain. Kirjamista kuitenkin noin puolet on vokaaleja ja puolet konsonantteja ja epätavallisia kirjaimia (kuten b, c, g, f, q, w, x, z) esiintyy harvemmin. Alussa muutama kirjain ruudun keskellä tulee näkyviin. Yhden ruudukossa olevan kirjaimen voi käyttää muodostettavassa sanassa vain kerran. Kirjainta klikatessa se vaihtaa väriä ja sen sisältämä kirjain lisätään sanaehdotuksen jatkoksi. Sanaehdotus siis näyttää sillä hetkellä valitut kirjaimet valintajärjestyksessä. 

Oikeat sanat tarkistetaan jonkinlaisesta sanakirjasta. Jos valituista kirjaimista muodostunut sana on olemassa, pelaaja voi "valmis"-nappia painamalla hyväksyä sanan. Tällöin valitut kirjaimet poistuvat ruudukosta ja poistuneiden kirjainruutujen viereen ilmestyy uusia sattumanvaraisia kirjaimia. Jos sanaa ei ole olemassa, "valmis"-nappia ei voi painaa. "X"-nappi tyhjentää valitut kirjamet ja niitä voi jälleen klikata ruudukossa. Peli jatkuu kunnes ruudukko on tyhjennetty kirjaimista tai jäljellä olevista kirjaimista ei enää voi muodostaa järkevää sanaa.

Peliä voisi laajentaa lisäämällä pistelaskuominaisuus, jolloin pitkistä sanoista ja/tai vaikeammista kirjaimista saa enemmän pisteistä. Voidaan myös lisätä ajastettu pelityyppi, jossa tietyssä ajassa yritetään saada mahdollisimman paljon pisteitä. Vaihtelun tai haasteen vuoksi pelin voisi myös kääntää englanniksi tai jollekin muulle kielelle.

**Käyttäjät:** Pelaaja

**Pelaajan toiminnot:**
- Pelin aloittaminen
- Kirjaimien valinta
- Valittujen kirjaimien tyhjentäminen
- Sanan hyväksyminen

##Luokkakaavio

![Luokkakaavio](/dokumentaatio/Luokkakaavio.png "Luokkakaavio")

