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

Ohjelmassa on kaksi pakkausta, sanapeli.logiikka ja sanapeli.kayttoliittyma. Pakkauksia yhdistää rajapinta Pelilogiikka, jonka toteuttaa logiikan puolella Pelinhallinta-luokka. Pelinhallinta luo pelialustan, graafisen käyttöliittymän ja sanantarkistajan. Pelialusta-luokka sisältää kaksiulotteisen taulukkomuotoisen pelialustan, johon tallennetaan Ruutu-olioita. Pelialusta sisältää myös listan pelissä yhdellä hetkellä valittuna olevia nappeja vastaavista Ruutu-olioista. Ruutu-luokan attribuutteja ovat sen x- ja y-koordinaatit sekä sisältö. Sisalto on abstrakti luokka, jonka Merkki-luokka perii. Merkki-luokka sisältää merkin ja siitä saatavat pisteet. Merkki arvotaan Satunnaistaja-olion avulla kirjaimet sisältävästä tiedostosta. SananTarkistaja-luokka lukee käytössä olevan sanalistan tiedostosta ja tarkistaa, onko sille annettu sana listalla.

Kayttoliittyma-luokka luo kaksi JFramea - AloitusValikon ja PeliIkkunan, niiden komponentit ja tapahtumienkuuntelijat. AloitusValikossa annetaan pelin ohjeet ja mahdollisuus valita ruudukon koko ja PeliIkkuna on varsinainen pelinäkymä. MerkkiNappiRuudukko luo nimensä mukaisesti MerkkiNappi-olioita sisältävän ruudukon. MerkkiNappi-oliot saavat tiedon sisältämästään merkistä logiikan puolelta Pelilogiikka-rajapinnan kautta. MerkkiNappienKuuntelija vaihtaa klikattujen nappien väriä, lisää niiden sisältämät merkit sanakenttään ja nappeja vastaavat ruudut Pelialustan valittujen listalle. ToimintoNappienKuuntelija vastaa ToimintoNappi-olioiden eli "hyväksy", "tyhjennä" ja "lopeta" -nappien klikkauksesta seuraavista tapahtumista. Se toimii yhteistyössä logiikan kanssa Pelilogiikka-rajapinnan kautta mm kun sana pitää tarkistaa ennen hyväksymistä ja uudet merkit päivittää pelialustalle hyväksymisen jälkeen.


##Luokkakaaviot

- Ensisijainen luokkakaavio, jossa logiikka- ja käyttöliittymäpakkaukset eritelty
![PakkausLuokkakaavio](/dokumentaatio/Luokkakaavio2.png "Pakkaus-luokkakaavio")

- Luokkakaavio, jossa myös kytkentärajoitukset
![Luokkakaavio](/dokumentaatio/YumlLuokkakaavio.png "YumlLuokkakaavio")

##Sekvenssikaaviot

- Sekvenssikaavio - merkkinapin klikkaaminen
![Sekvenssikaavio](/dokumentaatio/Sekvenssikaavio-merkkinappi2.png "MerkkiNappi-sekvenssikaavio")

- Sekvenssikaavio - tyhjennä-napin klikkaaminen
![Sekvenssikaavio](/dokumentaatio/Sekvenssikaavio-tyhjennaNappi2.png "TyhjennäNappi-sekvenssikaavio")

- Sekvenssikaavio - hyväksy-napin klikkaaminen
![Sekvenssikaavio](/dokumentaatio/Sekvenssikaavio-hyvaksyNappi2.png "HyväjsyNappi-sekvenssikaavio")

