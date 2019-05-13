package logika;

/**
 *  Třída PrikazSeber - provádí příkaz seber
 *
 *@author     Jan Vítů
 *@version    LS 2019
 */
class PrikazZatkni implements IPrikaz {
    private static final String NAZEV = "zatkni";
    private Prostor aktualniProstor;
    private HerniPlan plan;

    /**
     *  Konstruktor třídy
     *
     *  @param plan herní plán, ve kterém se bude ve hře "chodit"
     */
    public PrikazZatkni(HerniPlan plan) {
        this.plan = plan;
    }

    /**
     *
     *
     *@param parametry - jako parametr obsahuje věc v prostoru, kterou hráč chce sebrat
     *@return vrací informace o stavu vložení věci
     */
    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            return "Koho mám zatknout?";
        } else if (parametry.length > 1) {
            return "Bylo zadáno příliš mnoho parametrů";
        }

        String subjekt = parametry[0];
        aktualniProstor = plan.getAktualniProstor();
        Postava postava = aktualniProstor.odeberPostavu(subjekt);

        if (postava == null) {
            return "Postava " + postava + " se nenachází v současné místnosti;";
        } else if (postava.getJmeno().equals("Zahradník")) {
            plan.setVyhral();
            return "VÍTĚZSTVÍ! GRATULUJI!";
        } else {
            plan.setProhral();
            return "KONEC HRY!";
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
