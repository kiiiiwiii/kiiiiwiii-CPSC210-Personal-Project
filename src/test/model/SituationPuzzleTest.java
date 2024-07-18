package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SituationPuzzleTest {

    SituationPuzzle sp;

    @BeforeEach
    void runBefore() {
        sp = new SituationPuzzle(4);
    }

    @Test
    void testConstructor() {
        assertEquals(4, sp.getAttempts());

    }

    @Test
    void testGetInit() {
        assertEquals("\nA family of three had a quarrel. "
                + "\nThe neighbour found the man dead in his home the next day, "
                + "\nbound with hemp rope and dressed in maternity clothes. "
                + "\nThe neighbour did not call the police. Why?", sp.getInit());
    }

    @Test
    void testGetEnd() {
        assertEquals("\nduring a quarrel, the hostess revealed that "
                + "\nthe boy's biological father was not the man, "
                + "\nand the man hanged himself. "
                + "\nThe boy witnessed his father’s death. "
                + "\nHe loved the family so much that he wished he was the his child. "
                + "\nSo he dressed his father's corpse in maternity clothes, "
                + "\ncut open his father's stomach and dug out all his internal organs, "
                + "\nput himself into his father’s stomach, then bound themselves together with hemp rope to "
                + "\nsatisfy himself. The neighbour was scared so she did not call the police.", sp.getEnd());
    }



    @Test
    void testGetAttempt() {
        assertEquals(4,sp.getAttempts());
        sp.setAttempts(5);
        assertEquals(5,sp.getAttempts());
    }

    @Test
    void testSetAttempts() {
        sp.setAttempts(10);
        assertEquals(10,sp.getAttempts());
        sp.setAttempts(0);
        assertEquals(0,sp.getAttempts());
    }


}
