package logika;
import java.util.*;

/**
 * Třída PrikazProhledej - vykonává příkaz prohledej
 *
 * @author    Jan Vítů
 * @version   LS 2019
 * */
class PrikazProhledej implements IPrikaz{

    private static final String NAZEV = "prohledej";
    private HerniPlan plan;
    private Prostor aktualniProstor;
    private Set<Vec> setVeci;
    private String pridaneVeci;
    private VelkaVec velkaVec;
    /**
     *  Konstruktor třídy
     *
     *  @param plan herní plán, ve kterém se bude ve hře "chodit"
     */
    public PrikazProhledej(HerniPlan plan) {
        this.plan = plan;
        setVeci = new HashSet<>();
    }
    /**
     *  Provádí příkaz "prohledej", který prohledává velké věci. Pokud velká věc obsahuje předmět(y) "vyhodí" předměty do místnosti
     *
     *@param parametry - jako  parametr obsahuje název velké věci
     *@return seznam věcí, které jsou ve velké věci
     */
    @Override
    public String provedPrikaz(String... parametry) {

        if (parametry.length == 0){
            return "Co mám prohledat?";
        }

        if (parametry.length > 1){
            return "Bylo zadáno příliš mnoho parametrů.";
        }
        String objekt = parametry[0];
        aktualniProstor = plan.getAktualniProstor();

        velkaVec = aktualniProstor.odeberVelkaVec(objekt);

        pridaneVeci = "Veci: ";
        if (velkaVec != null) {
            setVeci = velkaVec.getSeznamVeci();
        }

        if (velkaVec == null){
            return "Věc " + objekt + " se nenachází v aktuálním prostoru";
        }
        else if ( setVeci == null || setVeci.isEmpty()){
            aktualniProstor.vlozVelkaVec(velkaVec);
            return "V této věci nic není";
        }
        else if (velkaVec.isZamcena()){
            aktualniProstor.vlozVelkaVec(velkaVec);
            return "Věc je potřeba odemknout, potřebuješ šperhák nebo klíč.";
        }
        else {
            for (Vec vec : setVeci) {
                if (vec.getNazev() != null) {
                    aktualniProstor.vlozVec(vec);
                    pridaneVeci += vec.getNazev() + ", ";
                }
            }
            velkaVec.nullSeznamVeci();
            aktualniProstor.vlozVelkaVec(velkaVec);
            return pridaneVeci;
        }
    }
    /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *
     *  @ return nazev prikazu
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }

}
