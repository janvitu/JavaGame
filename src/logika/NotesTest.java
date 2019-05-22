package logika;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class NotesTest {

    public String jmeno;
    public String text;
    public Notes notes1;
    public HashMap<String, String> obsahNotesu;

    @BeforeEach
    void setUp() {
        notes1 = new Notes();
        notes1.addObsahNotesu("Jan", "text dialogu");
        jmeno = "Petr";
        text = "dialog";
        obsahNotesu = new HashMap<>();
        obsahNotesu.put("Jan", "text dialogu");
    }

    @Test
    void getObsahNotesu() {
        assertEquals(obsahNotesu, notes1.getObsahNotesu());
    }

    @Test
    void addObsahNotesu() {
        obsahNotesu.put(jmeno, text);
        notes1.addObsahNotesu(jmeno, text);
        assertEquals(obsahNotesu, notes1.getObsahNotesu());
    }
}