package logika;
import java.util.*;
/**
 * Třída Batoh - popisuje obsah hráčova batohu
 *
 * @author    Jan Vítů
 * @version   LS 2019
 * */

public class Batoh {

    private static final int VELIKOST = 6;
    private Map<String, Vec> seznam;

    public Batoh(){
        seznam = new HashMap<>();
    }

    /**
     * Metoda kontroluje zda je v batohu volno
     *
     * @return true pokud je v batohu místo
     */
    public boolean jeVolny(){
        return (seznam.size() <= VELIKOST);
    }

    /**
     * Metoda vkládá věc do batohu
     * @param vec instance veci, která je přidána do batohu
     * @return vrací true pokud je v batohu místo a věc je přidána; vrací false pokud je batoh plný a věc nelze přidat
     */
    public boolean vlozVec(Vec vec){
        if (jeVolny()){
            seznam.put(vec.getNazev(), vec);
            return true;
        } else {
            //return "Nedostatek místa v batohu";
            return false;
        }
    }

    /**
     * Metoda odebírá věci z batohu
     * @param nazev – nazev veci, která se odebere
     * @return pokud je jakákoli věc odebrána vrátí true v opačném případě pokud věc není v batohu vrací false
     */
    public Vec odeberVec(String nazev){
        Vec odebranaVec = null;
        if (seznam.containsKey(nazev)){
            odebranaVec = seznam.get(nazev);
            seznam.remove(nazev);
        }
        return odebranaVec;
    }

    /**
     * Metoda vrací věc z batohu
     * @param nazev – nazev veci, která je v batohu
     * @return pokud věc není v batohu vrací false jinak vrací true
     */
    public Vec getVec(String nazev){
        Vec vec = null;
        if (seznam.containsKey(nazev)){
            vec = seznam.get(nazev);
        }
        return vec;
    }

    /**
     * Metoda vrací celý obsah batohu
     *
     * @return vrací seznam věcí v batohu
     */
    public String getObsah(){
        String text = "Batoh obsahuje: \n";
        for(String nazev : seznam.keySet()){
            text += nazev + "\n";
        }
        return text;
    }

}