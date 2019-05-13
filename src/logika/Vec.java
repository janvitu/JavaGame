package logika;


/**
 * Třída slouží pro popis věci
 *
 *@author     Jan Vítů
 *@version    pro LS 2018/2019
 */

public class Vec {
    private String nazev;
    private boolean prenositelnost;
    private boolean opotrebovatelna;
    private boolean rozbitelna;

    /**
     * Konstruktor třídy
     *
     * @param nazev - nazev predmetu
     * @param prenositelnost - informace o prenositelnosti
     * @param opotrebovatelna - informace o moznosti opotrebeni
     * @param rozbitelna - informace o moznosti rozniti predmetu
     */
    public Vec(String nazev, boolean prenositelnost, boolean opotrebovatelna, boolean rozbitelna){
        this.nazev = nazev;
        this.prenositelnost = prenositelnost;
        this.opotrebovatelna = opotrebovatelna;
        this.rozbitelna = rozbitelna;
    }

    public String getNazev() {
        return nazev;
    }
    //lze vec prenest stul = false; kniha = true;
    public boolean isPrenositelnost() {
        return prenositelnost;
    }
    //je vec rozbitelna napr. paklic
    public boolean isRozbitelna() {
        return rozbitelna;
    }
    //je vec opotrebovatelna napr mec
    public boolean isOpotrebovatelna() {
        return opotrebovatelna;
    }

    public void setPrenositelnost(boolean stav) {
        this.prenositelnost = stav;
    }

    public void setOpotrebovatelna(boolean opotrebenovatelnost) {
        this.opotrebovatelna = opotrebenovatelnost;
    }

    public void setRozbitelna(boolean rozbitelnost) {
        this.rozbitelna = rozbitelnost;
    }
}