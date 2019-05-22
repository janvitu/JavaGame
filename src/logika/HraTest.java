package logika;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HraTest {
    private Hra hra1;
    private Vec vec1;
    private Vec vec2;

    @BeforeEach
    void setUp() {
        hra1 = new Hra();
        vec1 = new Vec("vec1", true,true,true);
        vec2 = new Vec("vec2", true,true,true);
    }

    @Test
    void vyhratelnost() {
        hra1.zpracujPrikaz("zatkni Zahradník");
    }

}