##Aihemäärittely

**Aihe:** Sanaruudukkopeli

Toteutetaan sanapeli, jossa pelaajan tavoite on tyhjentää ruudukko kirjaimista muodostamalla niistä sanoja. Tavoitteena voi myös olla mahdollisimman korkea pistemäärä.

Pelialustana toimii ruudukko, jonka jokaiseen ruutuun liittyy sattumanvarainen kirjain. Kirjamia esiintyy niiden frekvenssien mukaisesti. Alussa muutama kirjain ruudun keskellä tulee näkyviin. Yhden ruudukossa olevan kirjaimen voi käyttää muodostettavassa sanassa vain kerran. Kirjainta klikatessa se vaihtaa väriä ja sen sisältämä kirjain lisätään sanaehdotuksen jatkoksi. Sanaehdotus näyttää sillä hetkellä valitut kirjaimet valintajärjestyksessä. 

Oikeat sanat tarkistetaan sanalistasta. Jos valituista kirjaimista muodostunut sana on olemassa, pelaaja voi "hyväksy"-nappia painamalla hyväksyä sanan. Tällöin valitut kirjaimet poistuvat ruudukosta ja poistuneiden kirjainruutujen viereen ilmestyy uusia sattumanvaraisia kirjaimia. Hyväksytyn sanan pisteet lasketaan kirjainten yleisyyden perusteella niin, että yleisimmistä saa vähemmän pisteitä ja harvinaisemmista enemmän. Kokonaispisteet saadaan vielä kertomalla summa sanan pituudella. Jos sanaa ei ole olemassa, "hyväksy"-nappia painettaessa valitut kirjaimet poistuvat sanaehdotuksesta ja ovat jälleen käytettävissä. "Tyhjennä"-nappi tyhjentää valitut kirjamet ja niitä voi jälleen klikata ruudukossa. Peli jatkuu kunnes ruudukko on tyhjennetty kirjaimista tai jäljellä olevista kirjaimista ei enää voi muodostaa järkevää sanaa. "Lopeta" -nappi lopettaa pelin millon tahansa.

Peliruudukko on oletuskooltaa 7x7, mutta pelaajalle voisi antaa mahdollisuuden ennen pelin alkua valita ruudukon koko. Voidaan myös lisätä ajastettu pelityyppi, jossa sanan löytäminen lisää peliaikaa. Vaihtelun tai haasteen vuoksi pelin voisi myös kääntää englanniksi tai jollekin muulle kielelle.

**Käyttäjät:** Pelaaja

**Pelaajan toiminnot:**
- Pelin aloittaminen
- Kirjaimien valinta
- Valittujen kirjaimien tyhjentäminen
- Sanan hyväksyminen
- Pelin lopettaminen

##Rakennekuvaus

Ohjelmassa on kaksi pakkausta, sanapeli.logiikka ja sanapeli.kayttoliittyma. Pakkauksia yhdistää rajapinta Pelilogiikka, jonka toteuttaa logiikan puolella Pelinhallinta-luokka. Pelinhallinta luo pelialustan, graafisen käyttöliittymän ja sanantarkistajan. Pelialusta-luokka sisältää taulukkomuotoisen pelialustan, johon tallennetaan Ruutu-olioita.

##Luokkakaaviot

- Ensisijainen luokkakaavio, jossa logiikka- ja käyttöliittymäpakkaukset eritelty
![PakkausLuokkakaavio](/dokumentaatio/Luokkakaavio.png "Pakkaus-luokkakaavio")

- Luokkakaavio, jossa myös kytkentärajoitukset
![Luokkakaavio](/dokumentaatio/YumlLuokkakaavio.png "YumlLuokkakaavio")

##Sekvenssikaaviot

- Sekvenssikaavio - merkkinapin klikkaaminen
![Sekvenssikaavio](/dokumentaatio/Sekvenssikaavio-merkkinappi.png "MerkkiNappi-sekvenssikaavio")

- Sekvenssikaavio - tyhjennä-napin klikkaaminen
![Sekvenssikaavio](/dokumentaatio/Sekvenssikaavio-tyhjennaNappi.png "TyhjennäNappi-sekvenssikaavio")

- Sekvenssikaavio - hyväksy-napin klikkaaminen
![Sekvenssikaavio](/dokumentaatio/Sekvenssikaavio-hyvaksyNappi.png "HyväjsyNappi-sekvenssikaavio")

