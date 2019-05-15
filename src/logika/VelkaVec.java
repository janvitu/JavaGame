package logika;

import java.util.*;
/**
 * Třída slouží pro popis velké věci
 *
 *@author     Jan Vítů
 *@version    pro LS 2018/2019
 */
public class VelkaVec {
    private String nazev;
    private boolean zamcena;
    private Set<Vec> seznamVeci;

    /**
     * Konstruktor třídy
     * @param nazev nazev predmetu
     * @param zamcena informace o tom zda je predmet zamceny
     */
    public VelkaVec(String nazev, boolean zamcena) {
        this.nazev = nazev;
        this.zamcena = zamcena;
        seznamVeci = new HashSet<>();
    }

    /**
     * Metoda získá seznam věcí ve velké věci
     * @return vrací seznam věcí jako HashSet
     */
    public Set<Vec> getSeznamVeci() {
        return seznamVeci;
    }

    /**
     * metoda vynuluje seznam věcí
     */
    public void nullSeznamVeci(){
        seznamVeci.clear();
    }

    /**
     * Metoda vkládá věc do vělké věci
     * @param vec - vkládaná věc
     */
    public void vlozVec(Vec vec) {
        seznamVeci.add(vec);
    }

    /**
     * Metoda získá název objektu
     * @return název velke veci
     */
    public String getNazev() {
        return nazev;
    }

    /**
     * Metoda zjistí zda je velká věc zamčená
     * @return vrací true nebo false v závislosti na tom zda je zamčená nebo není zamčená
     */
    public boolean isZamcena() {
        return zamcena;
    }

    /*
    public boolean isEmpty() {
        return seznamVeci.isEmpty();
    }

    public void setZamcena(boolean zamcena) {
        this.zamcena = zamcena;
    }
     */
}