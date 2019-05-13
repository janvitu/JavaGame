package logika;

import java.util.HashMap;

/**
 * Třída Notes - popisuje všechny konverzace
 *
 * @author    Jan Vítů
 * @version   LS 2019
 * */
public class Notes {
    private HashMap<String, String> obsahNotesu;

    /**
     * Konstruktor
     */
    Notes() {
        obsahNotesu = new HashMap<>();
    }

    /**
     * Metoda vraci obsah notesu
     *
     * @return obsahNotesu
     */
    HashMap<String, String> getObsahNotesu() {
        return obsahNotesu;
    }

    /**
     * Metoda vklada zaznamy do notesu
     *
     * @param jmeno jmeno postavy
     * @param text  text postavy
     */
    public void addObsahNotesu(String jmeno, String text) {
        obsahNotesu.put(jmeno, text);
    }
}
