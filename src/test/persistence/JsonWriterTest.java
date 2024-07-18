package persistence;

import model.Evidence;
import model.EvidenceBook;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest extends JsonTest{

    @Test
    void testWriterInvalidFile() {
        try {
            EvidenceBook eb = new EvidenceBook();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyEvidenceBook() {
        try {
            EvidenceBook eb = new EvidenceBook();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyEvidenceBook.json");
            writer.open();
            writer.write(eb);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyEvidenceBook.json");
            eb = reader.read();
            assertEquals(0, eb.length());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralEvidenceBook() {
        try {
            EvidenceBook eb = new EvidenceBook();
            eb.addEvidence(new Evidence("inquiry0", "answer0"));
            eb.addEvidence(new Evidence("inquiry1","answer1"));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralEvidenceBook.json");
            writer.open();
            writer.write(eb);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralEvidenceBook.json");
            eb = reader.read();
            List<Evidence> evidences = eb.getEvidenceBook();
            assertEquals(2, evidences.size());
            checkEvidence("inquiry0", "answer0", evidences.get(0));
            checkEvidence("inquiry1", "answer1", evidences.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}

