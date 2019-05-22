package logika;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProstorTest {
    public Prostor prostor1;
    public Prostor prostor2;
    public Prostor prostor3;
    public Prostor prostor4;
    public Prostor prostor5;

    public Vec vec1;
    public Vec vec2;
    public Vec vec3; //nastavime jako klic

    public VelkaVec velkaVec1;
    public VelkaVec velkaVec2;

    public Postava postava1;
    public Postava postava2;

    @BeforeEach
    void setUp() {
        prostor1 = new Prostor("prostor1", "popis prostoru1");
        prostor2 = new Prostor("prostor2", "popis prostoru2");
        prostor3 = new Prostor("prostor3", "popis prostoru3");
        prostor4 = new Prostor("prostor4", "popis prostoru4");
        prostor5 = new Prostor("prostor5", "popis prostoru5");

        vec1 = new Vec("vec1", true, false, false);
        vec2 = new Vec("vec2", true, false, false);
        vec3 = new Vec("vec3_klic", true, false, false);

        velkaVec1 = new VelkaVec("velkaVec1", false);
        velkaVec2 = new VelkaVec("velkaVec2", false);

        postava1 = new Postava("postava1", null,"text postavy 1");
        postava2 = new Postava("postava2", null,"text postavy 2");
    }

    @Test
    void zamknout() {

    }

    @Test
    void isZamcena() {
        prostor1.zamknout(true);
        assertTrue(prostor1.isZamcena());
        assertFalse(prostor2.isZamcena());
    }

    @Test
    void setVychod() {
    }

    @Test
    void vlozVec() {
    }

    @Test
    void odeberVec() {
    }

    @Test
    void vratSeznamVeci() {
    }

    @Test
    void vlozVelkaVec() {
    }

    @Test
    void odeberPostavu() {
    }

    @Test
    void vratSeznamPostav() {
    }

    @Test
    void vlozPostava() {
    }

    @Test
    void odeberVelkaVec() {
    }

    @Test
    void vratSeznamVelkychVeci() {
    }

    @Test
    void setKlic() {
    }

    @Test
    void getKlic() {
    }

    @Test
    void getNazev() {
    }

    @Test
    void dlouhyPopis() {
    }

    @Test
    void vratSousedniProstor() {
    }

    @Test
    void getVychody() {
    }

    @Test
    void getVychodySet() {
    }
}