package logika;


/**
 * Třída PrikazBatoh - vykonává příkaz batoh
 *
 * @author    Jan Vítů
 * @version   LS 2019
 * */
class PrikazBatoh implements IPrikaz{

    private static final String NAZEV = "batoh";
    private HerniPlan plan;
    private String seznamVeci;
    private Batoh batoh;
    /**
     *  Konstruktor třídy
     *
     *  @param plan herní plán, ve kterém se bude ve hře "chodit"
     */
    public PrikazBatoh(HerniPlan plan) {
        this.plan = plan;
        batoh = plan.getBatoh();
    }
    /**
     *  Provádí příkaz "batoh", který vrací seznam věcí v batohu
     *
     *@return obsah batohu
     */
    @Override
    public String provedPrikaz(String... parametry) {

        if (parametry.length > 0){
            return "Bylo zadáno příliš mnoho parametrů.";
        }
        else {
            seznamVeci = batoh.getObsah();
            return seznamVeci;
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
