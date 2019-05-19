package logika;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.*;

/**
 * Trida Prostor - popisuje jednotlivé prostory (místnosti) hry
 *
 * Tato třída je součástí jednoduché textové hry.
 *
 * "Prostor" reprezentuje jedno místo (místnost, prostor, ..) ve scénáři hry.
 * Prostor může mít sousední prostory připojené přes východy. Pro každý východ
 * si prostor ukládá odkaz na sousedící prostor.
 *
 * @author Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova
 * @version pro školní rok 2016/2017
 */
public class Prostor {

    private String nazev;
    private String popis;
    private Set<Prostor> vychody;// obsahuje sousední místnosti
    private Map<String, Vec> seznamVeci;
    private Map<String, VelkaVec> seznamVelkychVeci;
    private Map<String, Postava> seznamPostav;
    private Vec klic;
    private boolean zamcena;

    /**
     * Vytvoření prostoru se zadaným popisem, např. "kuchyň", "hala", "trávník
     * před domem"
     *
     * @param nazev nazev prostoru, jednoznačný identifikátor, jedno slovo nebo
     * víceslovný název bez mezer.
     * @param popis Popis prostoru.
     */
    public Prostor(String nazev, String popis) {
        this.nazev = nazev;
        this.popis = popis;
        vychody = new HashSet<>();
        seznamVeci = new HashMap<>();
        seznamVelkychVeci = new HashMap<>();
        seznamPostav = new HashMap<>();
        zamcena = false;
        klic = null;
    }


    /**
     *  Zamyka mistnost
     *
     *  @param zamceno - na jakou hodnotu se ma nastavit mistnost, zamcena nebo odemcena?
     */
    public void zamknout(boolean zamceno) {
        zamcena = zamceno;
    }

    public boolean isZamcena() {
        return zamcena;
    }

    /**
     * Definuje východ z prostoru (sousední/vedlejsi prostor). Vzhledem k tomu,
     * že je použit Set pro uložení východů, může být sousední prostor uveden
     * pouze jednou (tj. nelze mít dvoje dveře do stejné sousední místnosti).
     * Druhé zadání stejného prostoru tiše přepíše předchozí zadání (neobjeví se
     * žádné chybové hlášení). Lze zadat též cestu ze do sebe sama.
     *
     * @param vedlejsi prostor, který sousedi s aktualnim prostorem.
     *
     */
    public void setVychod(Prostor vedlejsi) {
        vychody.add(vedlejsi);
    }


    public void vlozVec(Vec vec) {
        seznamVeci.put(vec.getNazev(), vec);
    }

    public Vec odeberVec(String nazev) {
            if (seznamVeci.containsKey(nazev)) {
                return seznamVeci.remove(nazev);
            } else {
                return null;
            }
    }

    public String vratSeznamVeci() {
        String text = "";
        for (String key : seznamVeci.keySet()) {
            text += key + " ";
        }
        if (text == ""){
            return text + "\033[0m";
        } else {
            return "\033[1;32m" + text + "\033[0m";
        }
    }


    public void vlozVelkaVec(VelkaVec velkaVec){
        seznamVelkychVeci.put(velkaVec.getNazev(), velkaVec);
    }

    /**
     * odebrání postavy z prostoru
     * @param jmeno jmeno postavy
     * @return vrací postavu pokud tato postava je v prostoru pokud není vrací null
     */
    public Postava odeberPostavu(String jmeno) {
        if (seznamPostav.containsKey(jmeno)) {
            return seznamPostav.remove(jmeno);
        } else {
            return null;
        }
    }

    /**
     * Vrací seznam postav v prostoru
     * @return text se jmeny postav
     */
    public String vratSeznamPostav() {
        String text = "";
        for (String key : seznamPostav.keySet()) {
            text += key + " ";
        }
        if (text == "") {
            return text + "\033[0m";
        } else {
            return "\033[1;32m" + text + "\033[0m";
        }

    }

    /**
     * Vkládá postavu do prostoru
     * @param postava vkládání objektu typu Postava
     */
    public void vlozPostava(Postava postava) {
        seznamPostav.put(postava.getJmeno(), postava);
    }

    /**
     * metoda odebira velkou vec z prostoru
     * @param nazev – nazev veci
     * @return pokud velka vec existuje je odebrana jinak je vraceno null
     */
    public VelkaVec odeberVelkaVec(String nazev){
            if (seznamVelkychVeci.containsKey(nazev)) {
                return seznamVelkychVeci.remove(nazev);
            } else {
                return null;
            }

    }

    public String vratSeznamVelkychVeci() {
        String text = "";
        for (String key : seznamVelkychVeci.keySet()) {
            text += key + " ";
        }
        if (text == "") {
            return text + "\033[0m";
        } else {
            return "\033[1;32m" + text + "\033[0m";
        }
    }

    public void setKlic(Vec klic) {
        this.klic = klic;
    }

    public Vec getKlic() {
        return klic;
    }

    /**
     * Metoda equals pro porovnání dvou prostorů. Překrývá se metoda equals ze
     * třídy Object. Dva prostory jsou shodné, pokud mají stejný název. Tato
     * metoda je důležitá z hlediska správného fungování seznamu východů (Set).
     *
     * Bližší popis metody equals je u třídy Object.
     *
     * @param o object, který se má porovnávat s aktuálním
     * @return hodnotu true, pokud má zadaný prostor stejný název, jinak false
     */  
      @Override
    public boolean equals(Object o) {
        // porovnáváme zda se nejedná o dva odkazy na stejnou instanci
        if (this == o) {
            return true;
        }
        // porovnáváme jakého typu je parametr 
        if (!(o instanceof Prostor)) {
            return false;    // pokud parametr není typu Prostor, vrátíme false
        }
        // přetypujeme parametr na typ Prostor 
        Prostor druhy = (Prostor) o;

        //metoda equals třídy java.util.Objects porovná hodnoty obou názvů. 
        //Vrátí true pro stejné názvy a i v případě, že jsou oba názvy null,
        //jinak vrátí false.

       return (java.util.Objects.equals(this.nazev, druhy.nazev));       
    }

    /**
     * metoda hashCode vraci ciselny identifikator instance, ktery se pouziva
     * pro optimalizaci ukladani v dynamickych datovych strukturach. Pri
     * prekryti metody equals je potreba prekryt i metodu hashCode. Podrobny
     * popis pravidel pro vytvareni metody hashCode je u metody hashCode ve
     * tride Object
     */
    @Override
    public int hashCode() {
        int vysledek = 3;
        int hashNazvu = java.util.Objects.hashCode(this.nazev);
        vysledek = 37 * vysledek + hashNazvu;
        return vysledek;
    }
      

    /**
     * Vrací název prostoru (byl zadán při vytváření prostoru jako parametr
     * konstruktoru)
     *
     * @return název prostoru
     */
    public String getNazev() {
        return nazev;       
    }

    /**
     * Vrací "dlouhý" popis prostoru, který může vypadat následovně: Jsi v
     * mistnosti/prostoru vstupni hala budovy VSE na Jiznim meste. vychody:
     * chodba bufet ucebna
     *
     * @return Dlouhý popis prostoru
     */
    public String dlouhyPopis() {
        return "Jsi v mistnosti/prostoru " + "\033[1;33m" + popis + "\033[0m" + "\n"
                + "Můžeš jít do:" + popisVychodu() +"\n"
                + "Místnost obsahuje tyto velké věci: " + vratSeznamVelkychVeci() + "\n"
                + "Věci v místnosti: " + vratSeznamVeci() +"\n"
                + "Postavy v místnosti: " + vratSeznamPostav();
    }

    /**
     * Vrací textový řetězec, který popisuje sousední východy, například:
     * "vychody: nádvoří "
     *
     * @return Popis východů - názvů sousedních prostorů
     */
    private String popisVychodu() {
        String vracenyText = "";
        for (Prostor sousedni : vychody) {
            vracenyText += " " + sousedni.getNazev();
        }
        return "\033[1;32m" + vracenyText + "\033[0m";
    }

    /**
     * Vrací prostor, který sousedí s aktuálním prostorem a jehož název je zadán
     * jako parametr. Pokud prostor s udaným jménem nesousedí s aktuálním
     * prostorem, vrací se hodnota null.
     *
     * @param nazevSouseda Jméno sousedního prostoru (východu)
     * @return Prostor, který se nachází za příslušným východem, nebo hodnota
     * null, pokud prostor zadaného jména není sousedem.
     */
    public Prostor vratSousedniProstor(String nazevSouseda) {
        List<Prostor>hledaneProstory = 
            vychody.stream()
                   .filter(sousedni -> sousedni.getNazev().equals(nazevSouseda))
                   .collect(Collectors.toList());
        if(hledaneProstory.isEmpty()){
            return null;
        }
        else {
            return hledaneProstory.get(0);
        }
    }

    /**
     * Vrací kolekci obsahující prostory, se kterými tento prostor sousedí.
     * Takto získaný seznam sousedních prostor nelze upravovat (přidávat,
     * odebírat východy) protože z hlediska správného návrhu je to plně
     * záležitostí třídy Prostor.
     *
     * @return Nemodifikovatelná kolekce prostorů (východů), se kterými tento
     * prostor sousedí.
     */
    public Collection<Prostor> getVychody() {
        return Collections.unmodifiableCollection(vychody);
    }

    public Set<Prostor> getVychodySet() {
        return vychody;
    }

}
