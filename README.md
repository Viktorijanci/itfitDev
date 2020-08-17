# itfitDev
## PITANJA KOJA ZNAM DA ĆE TEPAVAC DA PITA (AKO I) KADA BUDE POČEO DA RADI
### TERMINOLOGIJA (OBAVEZNO PROČITATI!!!!!!!!!)
- `Context` - tip podatka koji u suštini možeš skontati svrhu preko imena. Mi ga koristimo za čitanje i pisanje u bazi. On se može dobiti preko `Activity.getApplicationContext()` (globalan kontekst) i `View.getContext()` ili  `this` (lokalan kontekst). Globalan kontekst koristimo ukoliko nam treba nešto što je vezano za čitavu aplikaciju, a lokalan ukoliko nam treba nešto što je vezano samo za jedan deo aplikacije.
- `String` - ovo neću da objašnjavam
- `Activity` - jedan prozor u Androidu. Sve se u aplikaciji prikazuje preko Activitya (uprostio sam - nemojte uzeti ovo kao 100% precizno).
- `Method` - funkcija
### ERORI AAAAAAAAAAAAAAAAAAAAAAAAAAAAA UPOMOĆ
Alt+Enter i import class
### OVDE NEMA SVE????
Mrzelo me je više da pišem. Napisaću ako neko bude tražio i kada mi se bude dalo.
### Komentarisanje koda
Mrzelo me je da komentarišem. Ukoliko implementacija neke metode nije jasna, mogu da unesem komentare koji objašnjavaju kako radi metoda. Takođe mogu i da nacrtam blok dijagram.
### Baza podataka
Nešto važno što moram napomenuti pre nego što objasnim funkcionisanje baze: imamo 2 baze zapravo. Aplikaciona i lokalna. Aplikaciona je ono što delimo i ona je u globalnom kontekstu. Lokalna je svojstvena.

Baza podataka je pisana u [JSONu](https://www.tutorialspoint.com/json/index.htm) zbog toga što je potekla iz JS i lako je koristiti. U linku je kratko objašnjen JSON sa nekim primerima primene i sintakse. U Javi se on koristi na sledeći način:
#### KORIŠĆENJE
U Javi JSON ima mnogo tipova podataka, ali mi koristimo 2 najbitnija:
- JSONObject
- JSONArray

Ime im otkriva svrhu. JSONObject je opšti oblik Objecta u JSONu, a JSONArray je niz JSONObjecta.
Kada imamo JSONObject, on ima 2 glavne metode koje ćemo mi koristiti da manipuliramo njime.
- get(String)
- put(String, Object)

Kada imamo JSONArray, on isto ima 2 glavne metode koje ćemo koristiti:
- get(int)
- put(JSONObject)
#### ČITANJE
Što se tiče samog čitanja fajla imamo `String readFromFileJSON(Context context, String ime)` metodu. Ona prihvata 2 parametre: `Context` i `String`. `Context` mora biti globalan (tehnički ne mora biti globalan, ali baza podataka aplikacije je u globalnom kontekstu) ukoliko želimo izvući nešto iz baze aplikacije. Može biti lokalan ukoliko želimo nešto u svom delu da čuvamo. `String` samo označava ime fajla kojem želimo da pristupimo. U sekciji *Terminologija* ima objašnjenje za Context i String u slučaju da si samo preskočio (a znam da jesi).
Nažalost, zbog implementacije ove metode (čitaj: moje lenjosti), mi od ove metode dobijemo `String`, a ne `JSONObject`. Kako bismo sada izvlačili podatke iz baze???
Ovako:
`JSONObject jsonObject = new JSONObject(readFromFileJSON(getApplicationContext(),"nešto"))`
Ovo definiše novi `JSONObject` kojeg možemo sad koristiti.
