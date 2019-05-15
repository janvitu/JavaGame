package logika;

import java.util.HashMap;
import java.util.Map;

/**
 *  Třída příkaz notes implementuje příkaz notes tak, aby vypsala všchny konverzace.
 *
 *@author     Jan Vírů
 *@version    LS 2018/2019
 */
class PrikazNotes implements IPrikaz {
    private static final String NAZEV = "notes";
    private HerniPlan plan;
    private Notes notes;
    private HashMap<String, String> obsahNotesu;
    private String text;

    /**
     *  Konstruktor třídy
     *
     *  @param plan herní plán
     *
     */
    public PrikazNotes(HerniPlan plan) {
        this.plan = plan;
        notes = plan.getNotes();

    }
    /**
     * Vrací všechny texty postav se kterými hráč mluvil
     *
     *@return zprávy, kterou vypíše hra hráči (z notesu)
     */
    @Override
    public String provedPrikaz(String... parametry) {
        text = "";
        if (parametry.length > 0) {
            return "Bylo zadáno příliš mnoho parametrů";
        }
        if (notes.getObsahNotesu().isEmpty()) {
            return "Notes neobsahuje záznamy";
        } else {
            obsahNotesu = notes.getObsahNotesu();
            for (Map.Entry<String, String> entry : obsahNotesu.entrySet()) {
                text += entry.getKey() + ": ";
                text += entry.getValue() + "\n";
            }
            return text;
        }
    }

    /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *
     *  @return nazev prikazu
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }

}
