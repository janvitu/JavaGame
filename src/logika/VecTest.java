package logika;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VecTest {
    public Vec vec1;
    public Vec vec2;
    public Vec vec3;

    @BeforeEach
    void setUp() {
        vec1 = new Vec("vec1", true, true,true);
        vec2 = new Vec("vec2", true, true,true);
        vec3 = new Vec("vec3", false, false,false);
    }

    @Test
    void getNazev() {
        assertEquals("vec1", vec1.getNazev());
        assertEquals("vec2", vec2.getNazev());
        assertEquals("vec3", vec3.getNazev());
    }

    @Test
    void isPrenositelnost() {
        assertTrue(vec1.isPrenositelnost());
        assertTrue(vec2.isPrenositelnost());
        assertFalse(vec3.isPrenositelnost());
    }

    @Test
    void isRozbitelna() {
        assertTrue(vec1.isRozbitelna());
        assertFalse(vec3.isRozbitelna());
    }

    @Test
    void isOpotrebovatelna() {
        assertTrue(vec1.isOpotrebovatelna());
        assertFalse(vec3.isOpotrebovatelna());
    }

    @Test
    void setPrenositelnost() {
        vec1.setPrenositelnost(false);
        assertFalse(vec1.isPrenositelnost());
    }

    @Test
    void setOpotrebovatelna() {
        vec1.setOpotrebovatelna(false);
        assertFalse(vec1.isOpotrebovatelna());
    }

    @Test
    void setRozbitelna() {
        vec1.setRozbitelna(false);
        assertFalse(vec1.isRozbitelna());
    }
}