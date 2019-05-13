package logika;

/**
 * Třída PrikazRozhledni - vykonává příkaz rozhlednutí se
 *
 * @author    Jan Vítů
 * @version   LS 2019
 * */
class PrikazRozhledni implements IPrikaz{

    private static final String NAZEV = "rozhledni";
    private HerniPlan plan;

    /**
     *  Konstruktor třídy
     *
     *  @param plan herní plán, ve kterém se bude ve hře "chodit"
     */
    public PrikazRozhledni(HerniPlan plan) {
        this.plan = plan;
    }
    /**
     *  Provádí příkaz "rozhledni", který prohledá celou místnost a vrací seznam všech objektů z místnosti
     *
     *@return vrací popis celé místnosti
     */
    @Override
    public String provedPrikaz(String... parametry) {

        if (parametry.length > 0) {
            return "Bylo zadáno příliš mnoho parametrů.";
        }
        else {
            return plan.getAktualniProstor().dlouhyPopis();
        }
    }
    /**
     *  Provádí příkaz "batoh", který vrací seznam věcí v batohu
     *
     *@return obsah batohu
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }

}
