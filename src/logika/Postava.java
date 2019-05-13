package logika;

/**
 * Třída Postava - popisuje popisuje postavu
 *
 * @author    Jan Vítů
 * @version   LS 2019
 * */
public class Postava{
    private String jmeno;
    private Vec predmet;
    private boolean zatceny;
    private String textPostavy;
    private boolean aktivni; //zjistíme co se zapíše do notesu

    /**
     * Konstruktor
     * @param jmeno jmeno postavy
     * @param predmet predmet, ktery postava po konverzaci upusti
     * @param textPostavy zobrazi se po prikazu mluv
     */
    public Postava(String jmeno, Vec predmet, String textPostavy) {
        this.jmeno = jmeno;
        this.predmet = predmet;
        this.textPostavy = textPostavy;
        zatceny = false;
        aktivni = false;
    }

    /**
     * Metoda vrací zda je osoba zatcena
     * @return zatceny (A/N)
     */
    public boolean isZatceny() {
        return zatceny;
    }

    /**
     * Metoda vrací jméno postavy
     * @return jmeno
     */
    public String getJmeno() {
        return jmeno;
    }

    /**
     * metoda vrací text postavy
     * @return textPostavy
     */
    public String getTextPostavy() {
        return textPostavy;
    }

    /**
     * metoda vrací stav konverzace zda bylo s postavou inreragováno či nikoli.
     * @return aktivni (A/N)
     */
    public boolean isAktivni() {
        return aktivni;
    }

    /**
     * Metoda vrací předmět, který postava má u sebe
     * @return predmet
     */
    public Vec getPredmet() {
        return predmet;
    }

    /**
     * Metoda nastaví aktivitu postavy
     * @param aktivni
     */
    public void setAktivni(boolean aktivni) {
        this.aktivni = aktivni;
    }

    /**
     * Metoda vloží předmět osobě do inventáře
     * @param predmet typu Vec je vložená věc do inventáře
     */
    public void setPredmet(Vec predmet) {
        this.predmet = predmet;
    }

    /**
     * Metoda nastavuje text postavy
     * @param textPostavy
     */
    public void setTextPostavy(String textPostavy) {
        this.textPostavy = textPostavy;
    }

    /**
     * Metoda nastavý zatčení postavy
     * @param zatceny
     */
    public void setZatceny(boolean zatceny) {
        this.zatceny = zatceny;
    }

    public void odstranVec() {
        predmet = null;
    }
}