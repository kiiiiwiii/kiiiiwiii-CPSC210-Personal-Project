package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuTest {

    Menu menu;

    @BeforeEach
    void runBefore() {
        menu = new Menu();
    }


    @Test
    void testShowGeneralMenu() {
        assertEquals("\nWelcome to Situation Puzzle Game, detective\n"
                + "\tEnter 'e' for evidence\n"
                + "\tEnter 'h' to review evidence history\n"
                + "\tEnter 'a' to begin your attempts\n"
                + "\tEnter 'q' to quit game and resume later\n"
                + "\tEnter 'l' to reload evidence history from file\n"
                + "\tEnter 'end game' to end game and show original story\n", menu.showGeneralMenu());
    }

    @Test
    void testDisplayEvidenceSelectionMenu() {
        assertEquals("\nEnter 'cd' for cause of death\n"
                + "\nEnter 're' for character's relationship\n"
                + "\nEnter 'cs' for crime scene\n", menu.displayEvidenceSelectionMenu());
    }


    @Test
    void testShowCauseOfDeathMenu() {
        assertEquals("\n1.Suicide?\n"
                + "\n2.Murder?\n"
                + "\n3.Secondary injury?\n"
                + "\n4.Strangled?\n"
                + "\n5.Stab?\n"
                + "\n6.Collaborative murder?\n", menu.showCauseOfDeathMenu());

    }

    @Test
    void testShowCharactersRelationMenu() {
        assertEquals("\n1.Biological mother?\n"
                + "\n2.Biological father?\n"
                + "\n3.Woman pregnant?\n"
                + "\n4.Boy is around 5 years old?\n"
                + "\n5.Woman is alive?\n"
                + "\n6.Boy is alive?\n"
                + "\n7.Neighbour is alive?\n"
                + "\n8.Neighbour appeared during quarrel?\n"
                + "\n9.Neighbour appeared after quarrel?\n"
                + "\n10.Does neighbour has disability?\n", menu.showCharactersRelationMenu());

    }

    @Test
    void testShowCrimeSceneMenu() {
        assertEquals("\n1.Bloody?\n"
                + "\n2.Dead during quarrel?\n"
                + "\n3.Neighbour changed the scene?\n"
                + "\n4.Boy changed the scene?\n"
                + "\n5.Woman changed the scene?\n"
                + "\n6.Is the crime accidental?\n"
                + "\n7.Is the crime planned?\n"
                + "\n8.Is the boy still at the crime scene?\n"
                + "\n9.Is the woman still at the crime scene?\n"
                + "\n10.Did the boy put on dress for his father?\n"
                + "\n11.Is the corpse cut up?\n", menu.showCrimeSceneMenu());

    }


    @Test
    void testDisplayAttemptSelectionMenu() {
        assertEquals("\tEnter 'woman' to select the women\n"
                + "\tEnter 'boy' to select the boy\n"
                + "\tEnter 'neighbour' to select the neighbour\n"
                + "\tEnter 'man' to select the man", menu.displayAttemptSelectionMenu());

    }

    @Test
    void testDisplaySaveMenu() {
        assertEquals("\tEnter 's' to save your evidence history.\n"
                + "\tEnter 'no' to directly quit game.\n", menu.displaySaveMenu());
    }
}
