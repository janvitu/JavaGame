package logika;

/**
 *  Třída PrikazSeber - provádí příkaz seber
 *
 *@author     Jan Vítů
 *@version    LS 2019
 */
class PrikazSeber implements IPrikaz {
    private static final String NAZEV = "seber";
    private HerniPlan plan;
    private Prostor aktualniProstor;

    /**
     *  Konstruktor třídy
     *
     *  @param plan herní plán, ve kterém se bude ve hře "chodit" 
     */
    public PrikazSeber(HerniPlan plan) {
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
            return "Co mám sebrat?";
        } else if (parametry.length > 1) {
            return "Bylo zadáno příliš mnoho parametrů";
        }

        String objekt = parametry[0];

        aktualniProstor = plan.getAktualniProstor();
        Vec vec = aktualniProstor.odeberVec(objekt);
        
        if (vec == null) {
            return "Věc " + objekt + " se nenachází v aktuálním prostoru";
        }

        if (!vec.isPrenositelnost()) {
            return "Tuto věc neuneseš";
        }
        if (vec.getNazev().equals("Usvědčující_dopis")) {
            plan.getBatoh().vlozVec(vec);
            return "Věc " + objekt + " byla přidána do batohu. Tento dopis obsahuje materiál, který jasně prokazuje zahradníkovu vinnu.";
        }
        if (plan.getBatoh().vlozVec(vec)) {
            if (vec.getNazev().equals("Usvědčující_dopis")) {
                return "Věc " + objekt + " je důkazní materiál, který přímo usvědčuje zahradníka ze spáchání všech vražd.";
            } else {
                return "Věc " + objekt + " byla přidána do batohu.";
            }
        } else {
            return "Batoh je plný.";
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
