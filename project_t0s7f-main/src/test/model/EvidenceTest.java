package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EvidenceTest {

    private Evidence evi;
    private Evidence evi1;
    private Evidence evi2;

    @BeforeEach
    void runBefore() {
        evi = new Evidence("inquiry","answer");
        evi1 = new Evidence("inquiry1", "answer1");
        evi2 = new Evidence("inquiry2","answer2");
    }


    @Test
    void testConstructor() {
        assertEquals("inquiry", evi.getInquiry());
        assertEquals("answer", evi.getAnswer());
        assertEquals("inquiry1",evi1.getInquiry());
        assertEquals("answer1",evi1.getAnswer());
        assertEquals("inquiry2",evi2.getInquiry());
        assertEquals("answer2",evi2.getAnswer());
    }

    @Test
    void testGetInquiry() {
        assertEquals("inquiry", evi.getInquiry());
        assertEquals("inquiry1",evi1.getInquiry());
        assertEquals("inquiry2",evi2.getInquiry());
    }

    @Test
    void testGetAnswer() {
        assertEquals("answer", evi.getAnswer());
        assertEquals("answer1",evi1.getAnswer());
        assertEquals("answer2",evi2.getAnswer());
    }







}
