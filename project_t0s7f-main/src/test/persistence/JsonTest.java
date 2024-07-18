package persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;
import model.Evidence;

public class JsonTest {

    protected void checkEvidence(String inquiry, String answer, Evidence evidence) {
        assertEquals(inquiry, evidence.getInquiry());
        assertEquals(answer, evidence.getAnswer());
    }
}
