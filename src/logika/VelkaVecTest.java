package logika;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class VelkaVecTest {
    public VelkaVec velkaVec1;
    public VelkaVec velkaVec2;
    public VelkaVec velkaVec3;
    public VelkaVec velkaVec4;

    public Vec vec1;
    public Vec vec2;
    public Vec vec3;

    public Set<Vec> seznamVeci1;
    public Set<Vec> seznamVeci2;

    @BeforeEach
    void setUp() {
        velkaVec1 = new VelkaVec("velkaVec1", false);
        velkaVec2 = new VelkaVec("velkaVec2", false);
        velkaVec3 = new VelkaVec("velkaVec3", false);
        velkaVec4 = new VelkaVec("velkaVec4", true);

        vec1 = new Vec("vec1", true, true, true);
        vec2 = new Vec("vec2", true, true, true);
        vec2 = new Vec("vec2", true, true, true);

        seznamVeci1 = new HashSet<>();
        seznamVeci2 = new HashSet<>();

        seznamVeci1.add(vec1);
        seznamVeci1.add(vec2);
        seznamVeci1.add(vec3);

        seznamVeci2.add(vec1);
    }

    @Test
    void getSeznamVeci() {
        velkaVec1.vlozVec(vec1);
        velkaVec1.vlozVec(vec2);
        velkaVec1.vlozVec(vec3);

        assertEquals(seznamVeci1, velkaVec1.getSeznamVeci());

    }

    @Test
    void nullSeznamVeci() {
        velkaVec1.vlozVec(vec1);
        velkaVec1.vlozVec(vec2);
        velkaVec1.vlozVec(vec3);

        velkaVec1.nullSeznamVeci();
        assertEquals(0, velkaVec1.getSeznamVeci().size());
    }

    @Test
    void vlozVec() {
        velkaVec2.vlozVec(vec1);
        assertEquals(seznamVeci2, velkaVec2.getSeznamVeci());
    }

    @Test
    void getNazev() {
        assertEquals("velkaVec1", velkaVec1.getNazev());
    }

    @Test
    void isZamcena() {
        assertFalse(velkaVec1.isZamcena());
        assertTrue(velkaVec4.isZamcena());
    }
}