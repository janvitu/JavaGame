package logika;

import java.util.*;

public class VelkaVec {
    private String nazev;
    private boolean zamcena;
    private Set<Vec> seznamVeci;

    public VelkaVec(String nazev, boolean zamcena) {
        this.nazev = nazev;
        this.zamcena = zamcena;
        seznamVeci = new HashSet<>();
    }

    public void setSeznamVeci(Set<Vec> seznamVeci) {
        this.seznamVeci = seznamVeci;
    }

    public Set<Vec> getSeznamVeci() {
        return seznamVeci;
    }

    public void nullSeznamVeci(){
        seznamVeci.clear();
    }

    public void vlozVec(Vec vec) {
        seznamVeci.add(vec);
    }

    public String getNazev() {
        return nazev;
    }

    public boolean isZamcena() {
        return zamcena;
    }

    public boolean isEmpty() {
        return seznamVeci.isEmpty();
    }

    public void setZamcena(boolean zamcena) {
        this.zamcena = zamcena;
    }
}