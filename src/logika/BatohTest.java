package logika;

import static org.junit.jupiter.api.Assertions.*;

class BatohTest {

    private Vec vec1;
    private Vec vec2;
    private Vec vec3;
    private Vec vec4;
    private Vec vec5;
    private Vec vec6;
    private Vec vec7;
    private Batoh batoh1;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        vec1 = new Vec("vec1", true, true, false);
        vec2 = new Vec("vec2", true, true, false);
        vec3 = new Vec("vec3", true, true, false);
        vec4 = new Vec("vec4", true, true, false);
        vec5 = new Vec("vec5", true, true, false);
        vec6 = new Vec("vec6", true, true, false);
        vec7 = new Vec("vec7", true, true, false);
        batoh1 = new Batoh();
    }

    @org.junit.jupiter.api.Test
    void jeVolny() {
        batoh1.vlozVec(vec1);
        batoh1.vlozVec(vec2);
        assertTrue(batoh1.jeVolny());
        batoh1.vlozVec(vec3);
        batoh1.vlozVec(vec4);
        batoh1.vlozVec(vec5);
        batoh1.vlozVec(vec6);
        assertFalse(batoh1.jeVolny());
    }

    @org.junit.jupiter.api.Test
    void vlozVec() {
        assertTrue(batoh1.vlozVec(vec1));
        assertTrue(batoh1.vlozVec(vec2));
        assertTrue(batoh1.vlozVec(vec3));
        assertTrue(batoh1.vlozVec(vec4));
        assertTrue(batoh1.vlozVec(vec5));
        assertTrue(batoh1.vlozVec(vec6));
        assertFalse(batoh1.vlozVec(vec7));
    }

    @org.junit.jupiter.api.Test
    void odeberVec() {
        batoh1.vlozVec(vec1);
        batoh1.vlozVec(vec2);
        assertEquals(vec1, batoh1.odeberVec("vec1"));
    }

    @org.junit.jupiter.api.Test
    void getVec() {
        batoh1.vlozVec(vec1);
        assertEquals(vec1, batoh1.getVec("vec1"));
    }

    @org.junit.jupiter.api.Test
    void getObsah() {
    }
}