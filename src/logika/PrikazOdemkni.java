package logika;

import java.util.HashSet;
import java.util.Set;

public class PrikazOdemkni implements IPrikaz {
    private static final String NAZEV = "odemkni";
    private HerniPlan plan;
    private Prostor aktualniProstor;
    private Batoh batoh;
    private Vec klic;
    private Set<Prostor> vychody;

    public PrikazOdemkni(HerniPlan plan){
        this.plan = plan;
        vychody = new HashSet<>();
    }
    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            return "Co mám odemknout";
        } else if (parametry.length > 1) {
            return "Bylo zadáno příliš mnoho parametrů";
        }

        String prostor = parametry[0];

        aktualniProstor = plan.getAktualniProstor();
        vychody = aktualniProstor.getVychodySet();
        batoh = plan.getBatoh();
        if (!vychody.isEmpty()) {
            for (Prostor sousedniProstor : vychody) {
                String  sousedniMistnost = sousedniProstor.getNazev();
                if (sousedniMistnost.equals(prostor)) {
                    klic = sousedniProstor.getKlic();
                    if (klic != null) {
                        if (batoh.getVec(klic.getNazev()) != null || batoh.getVec("Klíče") != null) {
                            sousedniProstor.zamknout(false);
                            batoh.odeberVec(klic.getNazev());
                            return "Místnost " + sousedniProstor.getNazev() + " je teď odemčená.";
                        } else {
                            return "Bez klíče " + klic.getNazev() + " nemůžeš odemknout dveře";
                        }
                    } else {
                        return "Tuto místnost není možné odemknout.";
                    }
                }
            }
        }
        return "Odtud nelze odemknout místnost " + prostor;
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
