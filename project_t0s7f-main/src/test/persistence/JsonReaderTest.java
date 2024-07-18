package persistence;

import model.Evidence;
import model.EvidenceBook;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            EvidenceBook eb = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyEvidenceBook() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyEvidenceBook.json");
        try {
            EvidenceBook eb = reader.read();
            assertEquals(0, eb.length());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralEvidenceBook() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralEvidenceBook.json");
        try {
            EvidenceBook eb = reader.read();
            List<Evidence> evidences = eb.getEvidenceBook();
            assertEquals(2, evidences.size());
            checkEvidence("inquiry0", "answer0", evidences.get(0));
            checkEvidence("inquiry1", "answer1", evidences.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
