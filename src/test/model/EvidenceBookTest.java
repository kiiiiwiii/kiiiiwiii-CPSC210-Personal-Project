package model;

import model.Evidence;
import model.EvidenceBook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EvidenceBookTest {
    private EvidenceBook evib;
    private Evidence evi;
    private Evidence evi1;
    private ArrayList<Evidence> evidences;

    @BeforeEach
    void runBefore() {
        evib = new EvidenceBook();
        evi = new Evidence("inquiry","answer");
        evi1 = new Evidence("inquiry1","answer1");
        evidences = new ArrayList<>();
    }

    @Test
    void testGetEvidenceBook() {
        evib.addEvidence(evi);
        evib.addEvidence(evi1);
        evidences.add(evi);
        evidences.add(evi1);
        assertEquals(evidences, evib.getEvidenceBook());
    }

    @Test
    void testConstructor() {
        assertEquals(0,evib.length());
        evib.addEvidence(evi);
        assertEquals(1,evib.length());
    }

    @Test
    void testaddEvidence() {
        evib.addEvidence(evi);
        assertEquals(1,evib.length());
        evib.addEvidence(evi1);
        assertEquals(2,evib.length());
    }


    @Test
    void testLength() {
        evib.addEvidence(evi);
        assertEquals(1,evib.length());
    }

    @Test
    void testCompleteBook() {
        evib.completeBook();
        assertEquals(27,evib.length());
    }

    @Test
    void testClearEvidence() {
        evib.completeBook();
        evib.clearEvidence();
        assertEquals(0,evib.length());
    }

}
