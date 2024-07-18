package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EvidenceInputOperationTest {

    EvidenceInputOperation eio;

    @BeforeEach
    void runBefore() {
        eio = new EvidenceInputOperation();

    }


    @Test
    void testOperateCDEvidenceEnter() {
        assertEquals("Yes",eio.operateCDEvidenceEnter("Suicide?"));
        assertEquals("No",eio.operateCDEvidenceEnter("Murder?"));
        assertEquals("Yes",eio.operateCDEvidenceEnter("Secondary injury?"));
        assertEquals("Yes",eio.operateCDEvidenceEnter("Strangled?"));
        assertEquals("No",eio.operateCDEvidenceEnter("Stab?"));
        assertEquals("No",eio.operateCDEvidenceEnter("Collaborative murder?"));
        assertEquals(null,eio.operateCDEvidenceEnter("lalala"));
    }

    @Test
    void testOperateCREvidenceEnter1() {
        assertEquals("Yes",eio.operateCREvidenceEnter1("Biological mother?"));
        assertEquals("No",eio.operateCREvidenceEnter1("Biological father?"));
        assertEquals("No",eio.operateCREvidenceEnter1("Woman pregnant?"));
        assertEquals("Yes",eio.operateCREvidenceEnter1("Boy is around 5 years old?"));
        assertEquals("Yes",eio.operateCREvidenceEnter1("Woman is alive?"));
        assertEquals("Yes",eio.operateCREvidenceEnter1("Boy is alive?"));
        assertEquals(null,eio.operateCREvidenceEnter1("lalala"));
    }

    @Test
    void testOperateCREvidenceenter2() {
        assertEquals("Yes",eio.operateCREvidenceEnter2("Neighbour is alive?"));
        assertEquals("No",eio.operateCREvidenceEnter2("Neighbour appeared during quarrel?"));
        assertEquals("Yes",eio.operateCREvidenceEnter2("Neighbour appeared after quarrel?"));
        assertEquals("No",eio.operateCREvidenceEnter2("Does neighbour has disability?"));
        assertEquals(null,eio.operateCREvidenceEnter2("lalala"));
    }

    @Test
    void testOperateCSEvidenceEnter1() {
        assertEquals("Yes",eio.operateCSEvidenceEnter1("Bloody?"));
        assertEquals("No",eio.operateCSEvidenceEnter1("Dead during quarrel?"));
        assertEquals("No",eio.operateCSEvidenceEnter1("Neighbour changed the scene?"));
        assertEquals("Yes",eio.operateCSEvidenceEnter1("Boy changed the scene?"));
        assertEquals(null,eio.operateCSEvidenceEnter1("lalala"));
    }

    @Test
    void testOperateCSEvidenceEnter2() {
        assertEquals("No",eio.operateCSEvidenceEnter2("Woman changed the scene?"));
        assertEquals("No",eio.operateCSEvidenceEnter2("Is the crime accidental?"));
        assertEquals("No",eio.operateCSEvidenceEnter2("Is the crime planned?"));
        assertEquals("Yes",eio.operateCSEvidenceEnter2("Is the boy still at the crime scene?"));
        assertEquals("No",eio.operateCSEvidenceEnter2("Is the woman still at the crime scene?"));
        assertEquals("Yes",eio.operateCSEvidenceEnter2("Did the boy put on dress for his father?"));
        assertEquals("Yes",eio.operateCSEvidenceEnter2("Is the corpse cut up?"));
        assertEquals(null,eio.operateCSEvidenceEnter2("lalala"));
    }

}

