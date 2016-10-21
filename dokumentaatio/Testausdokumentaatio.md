#Testausdokumentaatio

##Automaattinen testaus
Kaikki merkittävät luokat logiikkapuolella on testattu automaattisesti, toisin sanoen kaikki paitsi PelinHallinta ja Main. SananTarkistaja- ja Satunnaistaja-luokissa ei tiedoston lukemisen epäonnistumisesta johtuvan virheilmoituksen tai Scanner-olion close()-metodin toimintaa ole testattu, koska ne eivät mielestäni olleet oleellisia ohjelman toiminnan testauksen kannata. Virheilmoitukselle oli olemassa testit, mutta tiedostojen esittely InputStreameina File-muodon sijaan, jota toimiva jar-tiedosto vaati, "rikkoi" ne.  Lisäksi Satunnaistaja-luokan satunnainenMerkki()-metodissa oleva Collections.shuffle()-metodin toimintaa ei ole erikseen testattu, koska se vaatisi suhteellisen paljon työtä merkittävyyteensä nähden. Pelin toiminnasta voi nähdä, että esiintyvät merkit ovat satunnaisia.


