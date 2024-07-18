package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AttemptStageTest {

    AttemptStage as;
    SituationPuzzle puzzle;

    @BeforeEach
    void runBefore() {
        as = new AttemptStage();
        puzzle = new SituationPuzzle(3);
    }

    @Test
    void testMinusOne() {
        assertEquals(2,as.minusOne(puzzle));
        assertEquals(1,as.minusOne(puzzle));
        assertEquals(0,as.minusOne(puzzle));

    }
}
