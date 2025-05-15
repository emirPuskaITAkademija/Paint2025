## Zadatak - Paint App

Kreirati Java App za crtanje 2D oblika. Funkcionalnosti aplikacije su sljedeće.
Omogućit ćemo korisniku da trajno sačuva sliku koju je nacrtao u datoteci
u XML formatu.

Mi treba da osmislimo format tog XML dokumenta ili fajla.

DODATNO: Omogućiti korisniku da otvori prethodno sačuvane slike.


## Implementacija

Hoćemo kreirati GUI app koja će čuvati informacije o slici upravo u XML fajlu.
Imamo 2 oblika tačkica:
1. ellipse
2. rectangle


Ponudićemo korisniku opciju da odabere boju tačkica:
1. crvena 
2. plava





### Digresija
Imamo dvije vrste grafike:
1. rasterska - jpg, png, gif
2. vektorska .svg  

Razlika između rasterske i vektorske grafike
- Rasterska grafika se sastoji od pikselâ – svaki piksel ima svoju boju i poziciju. Kada uvećaš sliku, povećavaš i piksele, što dovodi do "zamućenosti" ili efekta kockica.
- SVG (Scalable Vector Graphics) koristi matematičke objekte (linije, krivulje, geometrijske oblike). Umjesto piksela, SVG čuva koordinate i matematičke formule koje crtaju sliku.

Zašto se pikseli vide u rasterskoj grafici, a ne u SVG-u?
- Povećanje slike- Kod rasterske grafike, svaki piksel se povećava, pa postaje vidljiv.
- Kod SVG-a, slika se ponovo izračunava pomoću formula, pa ostaje glatka bez gubitka kvaliteta.

- Detalji slike- Rasterske slike su poput mozaika – što više piksela, to bolja rezolucija.
- SVG ne zavisi od rezolucije, već od matematičkog opisa slike.

- Primjena- Rasterske slike su bolje za fotografije jer sadrže složene boje i sjene.
- SVG je idealan za logotipe, ikone, ilustracije, jer ostaju oštri pri svim veličinama.



