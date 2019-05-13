/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package logika;
/**
 * Třída PrikazOdhod implementuje pro hru příkaz odhod.
 * Tato třída je součástí jednoduché textové hry.
 *
 * @author    Jan Vítů
 * @version   LS rok 2019
 */
public class PrikazOdhod implements IPrikaz {
    private static final String NAZEV = "odhod";
    private HerniPlan plan;

    /**
     *  Konstruktor
     */
    public PrikazOdhod(HerniPlan plan)
    {
        this.plan = plan;
    }

    /**
     *  Provádí příkaz "odhod". Příkaz se snaží odebrat věc z batohu a vložit ji do prostoru.
     *  Může nastat situace, kdy věc v batohu není
     *
     *@param parametry - název věci, kterou chceme odebrat z batohu a dám do aktuální místnosti
     *@return informační zpráva
     */
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            return "Co mám zahodit?";
        }

        if (parametry.length > 1) {
            return "Bylo zadáno příliš mnoho parametrů.";
        }
        String objekt = parametry[0];
        Vec vec = plan.getBatoh().odeberVec(objekt);
        if (vec == null) {
            return "tuto věc v batohu nemáš";
        } else {
            plan.getAktualniProstor().vlozVec(vec);
            return "Vec " + vec.getNazev() + " byla vloženaproh do prostoru.";
        }

    }

    /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *
     *  @ return nazev prikazu
     */
    public String getNazev() {
        return NAZEV;
    }
    //== Nesoukromé metody (instancí i třídy) ======================================


    //== Soukromé metody (instancí i třídy) ========================================

}
