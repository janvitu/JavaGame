package logika;
/**
 * Třída PrikazMluv - vykonává příkaz mluv
 *
 * @author    Jan Vítů
 * @version   LS 2019
 * */
public class PrikazMluv implements IPrikaz {
    private static final String NAZEV = "mluv";
    private HerniPlan plan;
    private Prostor aktualniProstor;
    private Notes notes;

    /**
     *  Konstruktor třídy
     *
     *  @param plan herní plán, ve kterém se bude ve hře "chodit"
     */
    public PrikazMluv(HerniPlan plan) {
        this.plan = plan;
    }
    /**
     *  Provede příkaz pro konverzaci s postavou
     *
     *@param parametry - jako  parametr obsahuje jméno postavy se kterou chce hráč mluvit
     *@return zpráva, kterou vypíše hra hráči
     */
    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            return "S kým mám mluvit?";
        } else if (parametry.length > 1) {
            return "Bylo zadáno příliš mnoho parametrů";
        }

        String jmenoPostavy = parametry[0];
        notes = plan.getNotes();
        aktualniProstor = plan.getAktualniProstor();
        Postava postava = aktualniProstor.odeberPostavu(jmenoPostavy);

        if (postava == null) {
            return "Postava " + jmenoPostavy + " se nenachází v aktuálním prostoru.";
        } else {
            if (postava.isAktivni()) {
                aktualniProstor.vlozPostava(postava);
                return "S postavou " + jmenoPostavy + " jsi již mluvil.";
            } else {
                if (postava.getPredmet() != null) {
                    postava.setAktivni(true);
                    aktualniProstor.vlozVec(postava.getPredmet());
                    notes.addObsahNotesu(jmenoPostavy, postava.getTextPostavy());
                    aktualniProstor.vlozPostava(postava);
                    return postava.getTextPostavy() + "\nTady ti dávám " + postava.getPredmet().getNazev();
                } else {
                    postava.setAktivni(true);
                    notes.addObsahNotesu(jmenoPostavy, postava.getTextPostavy());
                    aktualniProstor.vlozPostava(postava);
                    return postava.getTextPostavy();
                }

            }
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
