package model;

// represents the puzzle story in this solving game.
public class SituationPuzzle {

    private int attempts;


    // EFFECTS: construct a situation puzzle with limited attempts
    public SituationPuzzle(int attempts) {
        this.attempts = attempts;


    }

    // EFFECTS: provide initial story condition to player
    public String getInit() {
        return "\nA family of three had a quarrel. "
                + "\nThe neighbour found the man dead in his home the next day, "
                + "\nbound with hemp rope and dressed in maternity clothes. "
                + "\nThe neighbour did not call the police. Why?";
    }


    // EFFECTS: provide story ending to player
    public String getEnd() {
        return "\nduring a quarrel, the hostess revealed that "
                + "\nthe boy's biological father was not the man, "
                + "\nand the man hanged himself. "
                + "\nThe boy witnessed his father’s death. "
                + "\nHe loved the family so much that he wished he was the his child. "
                + "\nSo he dressed his father's corpse in maternity clothes, "
                + "\ncut open his father's stomach and dug out all his internal organs, "
                + "\nput himself into his father’s stomach, then bound themselves together with hemp rope to "
                + "\nsatisfy himself. The neighbour was scared so she did not call the police.";
    }


    // EFFECTS: provide number of attempts to player
    public int getAttempts() {
        return attempts;
    }

    // MODIFIES: this
    // EFFECTS: set number of attempt to the given integer
    public void setAttempts(int i) {
        attempts = i;
    }


}
