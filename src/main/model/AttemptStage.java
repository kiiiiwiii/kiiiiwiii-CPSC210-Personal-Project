package model;

// attempt stage that minus one attempt everytime player enter a wrong answer
public class AttemptStage {


    public AttemptStage() {
    }


    // MODIFIES: this
    // EFFECTS: subtract one from the current number of chance
    public int minusOne(SituationPuzzle puzzle) {
        puzzle.setAttempts(puzzle.getAttempts() - 1);
        return puzzle.getAttempts();

    }


}
