package logika;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostavaTest {
    public Vec predmet1;
    public Vec predmet2;
    public Vec predmet3;
    public Vec predmet4;
    public Postava postava1;
    public Postava postava2;
    public Postava postava3;
    public Postava postava4;

    @BeforeEach
    void setUp() {
        predmet1 = new Vec("predmet1", true, false, false);
        predmet2 = new Vec("predmet2", true, false, false);
        predmet3 = new Vec("predmet3", true, false, false);
        predmet4 = new Vec("predmet4", true, false, false);
        postava1 = new Postava("postava1", predmet1, "text postavy 1");
        postava2 = new Postava("postava2", predmet2, "text postavy 2");
        postava3 = new Postava("postava3", predmet3, "text postavy 3");
        postava4 = new Postava("postava4", null, "text postavy 4");
    }

    @Test
    void isZatceny() {
        assertFalse(postava1.isZatceny());
        postava2.setZatceny(true);
        assertTrue(postava2.isZatceny());
    }

    @Test
    void getJmeno() {
        assertEquals("postava1", postava1.getJmeno());
        assertEquals("postava2", postava2.getJmeno());
        assertEquals("postava3", postava3.getJmeno());
        assertEquals("postava4", postava4.getJmeno());
    }

    @Test
    void getTextPostavy() {
        assertEquals("text postavy 1", postava1.getTextPostavy());
        assertEquals("text postavy 2", postava2.getTextPostavy());
        assertEquals("text postavy 3", postava3.getTextPostavy());
        assertEquals("text postavy 4", postava4.getTextPostavy());
    }

    @Test
    void isAktivni() {
        assertFalse(postava1.isAktivni());
        postava2.setAktivni(true);
        assertTrue(postava2.isAktivni());
    }

    @Test
    void getPredmet() {
        assertEquals(predmet1, postava1.getPredmet());
        assertEquals(null, postava4.getPredmet());
    }

    @Test
    void setAktivni() {
    }

    @Test
    void setPredmet() {
    }

    @Test
    void setTextPostavy() {
    }

    @Test
    void setZatceny() {
    }

    @Test
    void odstranVec() {
    }
}