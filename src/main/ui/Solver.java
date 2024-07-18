package ui;

import model.*;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static model.Evidence.*;

// Situation Puzzle game application
public class Solver {

    private Scanner input;
    private SituationPuzzle puzzle;
    private AttemptStage atp;
    private EvidenceBook myevidence;
    private Menu menus;
    private EvidenceInputOperation eio;
    private EvidenceBook evidenceBook;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    public static final String JSON_STORE = "./data/EvidenceBook.json";


    public Solver() {
        //runSolver();
    }

    //EFFECTS: operate player input until player end game or has no attempts left
    private void runSolver() {
        boolean continuing = true;
        String enter = null;

        beginGame();

        while (continuing) {
            enter = input.next();

            if (enter.equals("end game")) {
                giveSolution();
                continuing = false;
            } else if (puzzle.getAttempts() == 0) {
                continuing = false;
                System.out.println("When you have eliminated the impossible, whatever remains, however"
                        + "improbable, must be the truth.");
            } else if (enter.equals("no")) {
                System.out.println("Thank you for your help detective, see you later.");
                continuing = false;
            } else if (enter.equals("s")) {
                saveEvidenceHistory();
                continuing = false;
            } else {
                operateEnter(enter);

            }

        }

    }

    // EFFECTS: begin the game with initial state of story,
    //          evidence, and evidence collection
    private void beginGame() {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        evidenceBook = new EvidenceBook();
        completeEvidenceBook1(evidenceBook);
        eio = new EvidenceInputOperation();
        menus = new Menu();
        puzzle = new SituationPuzzle(3);
        myevidence = new EvidenceBook();
        atp = new AttemptStage();
        input = new Scanner(System.in);
        System.out.println(puzzle.getInit());
        showGeneralMenu();
        input.useDelimiter("\n");

    }

    // MODIFIES: this
    // EFFECTS: add all available evidences to evidenceBook
    public void completeEvidenceBook1(EvidenceBook whole) {
        for (Evidence evidence : Arrays.asList(suicide,murder, si, strangled, stab, clm, bm, bf,
                                               wp, bage, wa, ba, na, nappd, nappa, dis,
                                               blo, ddq, ncs, bcs, wcs, acc, pla, batcs,
                                               watcs, bdr, corpse)) {
            whole.addEvidence(evidence);
        }
    }

    // EFFECTS: processes the string player enters
    private void operateEnter(String enter) {
        if (enter.equals("e")) {
            giveEvidence();
        } else if (enter.equals("h")) {
            checkEvidenceBook(myevidence);
        } else if (enter.equals("a")) {
            beginAttempts(puzzle);
            System.out.println(menus.displayAttemptSelectionMenu());
        } else if (enter.equals("q")) {
            System.out.println(menus.displaySaveMenu());
        } else if (enter.equals("l")) {
            reloadEvidenceHistory();
        } else if (enter.equals("woman") || enter.equals("boy") || enter.equals("man") || enter.equals("neighbour")) {
            checkAttemptEnter(enter,puzzle,atp);
        } else if (enter.equals("cd") || enter.equals("re") || enter.equals("cs")) {
            checkEvidenceEnter(enter);
        } else {
            operateEvidenceEnter(enter, eio);
        }
    }

    // EFFECTS: produce the corresponding answer to evidence inquiry entered, and
    //          if an answer is found, add it to myevidence for history
    public String operateEvidenceEnter(String enter, EvidenceInputOperation eioo) {
        String a = new String();
        if (eioo.operateCDEvidenceEnter(enter) != null) {
            a = (eioo.operateCDEvidenceEnter(enter));
            //addEvidenceTo(enter, myevidence, evidenceBook);
            return a;
        } else if (eioo.operateCREvidenceEnter1(enter) != null) {
            a = (eioo.operateCREvidenceEnter1(enter));
            //addEvidenceTo(enter, myevidence, evidenceBook);
            return a;
        } else if (eioo.operateCREvidenceEnter2(enter) != null) {
            a = (eioo.operateCREvidenceEnter2(enter));
            //addEvidenceTo(enter, myevidence, evidenceBook);
            return a;
        } else if (eioo.operateCSEvidenceEnter1(enter) != null) {
            a = (eioo.operateCSEvidenceEnter1(enter));
            //addEvidenceTo(enter, myevidence, evidenceBook);
            return a;
        } else if (eioo.operateCSEvidenceEnter2(enter) != null) {
            a = (eioo.operateCSEvidenceEnter2(enter));
            //addEvidenceTo(enter, myevidence, evidenceBook);
            return a;
        }
        return null;

    }

    // MODIFIES: myevidence
    // EFFECTS: check for the searched evidence in evidenceBook, return the evidence and
    //          add it to myevidence as history
    public void addEvidenceTo(String enter, EvidenceBook eb, EvidenceBook whole) {
        for (Evidence evi : Arrays.asList(suicide,murder, si, strangled, stab, clm, bm, bf,
                wp, bage, wa, ba, na, nappd, nappa, dis,
                blo, ddq, ncs, bcs, wcs, acc, pla, batcs,
                watcs, bdr, corpse)) {
            if (enter.equals(evi.getInquiry())) {
                eb.addEvidence(evi);
            }
        }

    }

    // EFFECTS: start checking answers for correctness
    public void beginAttempts(SituationPuzzle puzzle) {
        System.out.println("Looks like you already know the truth, tell me, who did this."
                + "\nYou have" + " " + puzzle.getAttempts() + " " + "chances, good luck.\n");

    }


    // EFFECTS: check if the answer player typed is correct
    public String checkAttemptEnter(String enter, SituationPuzzle puzzle, AttemptStage atp) {
        String a = new String();
        if (enter.equals("woman")) {
            a = "Oh, really... I don't think so."
                    + "\nYou have" + " " + atp.minusOne(puzzle) + " " + "chances left";
            return a;
        } else if (enter.equals("boy")) {
            a = "That's...astonishing... "
                    + "End the game now, come to my office and tell me why."
                    + "\nThank you for your help, you can end the game now.";
            return a;
        } else if (enter.equals("neighbour")) {
            a = "Well, I think the neighbour is fine."
                    + "\nYou have" + " " + atp.minusOne(puzzle) + " " + "chances left";
            return a;
        } else if (enter.equals("man")) {
            a = "Wait...that's too scary, I don't think so."
                    + "\nYou have" + " " + atp.minusOne(puzzle) + " " + "chances left";
            return a;
        } else {
            return "invalid entry";
        }
    }


    // EFFECTS: display select options for play
    private void showGeneralMenu() {
        System.out.println(menus.showGeneralMenu());
    }


    // EFFECTS: call to display evidence selections that are provided for player
    private void giveEvidence() {
        System.out.println("What do you need, detective?");
        System.out.println(menus.displayEvidenceSelectionMenu());

    }

    // EFFECTS: show player evidences collected so far
    public List<String> checkEvidenceBook(EvidenceBook eb) {
        List<String> returnlist = new ArrayList<>();
        for (Evidence evi : eb.getEvidenceBook()) {
            String a = (evi.getInquiry() + " " + evi.getAnswer());
            returnlist.add(a);
        }
        return returnlist;
    }

    // EFFECTS: process evidence check
    public void checkEvidenceEnter(String enter) {
        if (enter.equals("cd")) {
            System.out.println("Please enter the question text with '?' that you are interested in...");
            System.out.println(menus.showCauseOfDeathMenu());

        }
        if (enter.equals("re")) {
            System.out.println("Please enter the question text with '?' that you are interested in...");
            System.out.println(menus.showCharactersRelationMenu());

        }
        if (enter.equals("cs")) {
            System.out.println("Please enter the question text with '?' that you are interested in...");
            System.out.println(menus.showCrimeSceneMenu());

        }
    }

    // EFFECTS: end game and show ending to player
    private void giveSolution() {
        System.out.println("\nThank you for your help, detective. It's been a while.");
        System.out.println("We have found that:" + puzzle.getEnd());
        System.out.println("\nHave a nice day.");
    }

    // MODIFIES: this
    // EFFECTS: save evidence history to file
    public void saveEvidenceHistory() {
        try {
            jsonWriter.open();
            jsonWriter.write(myevidence);
            jsonWriter.close();
            System.out.println("Saved " + "my evidences" + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        } finally {
            System.out.println("Thank you for your help detective, see you later.");
        }

    }

    // MODIFIES: this
    // EFFECTS: loads evidence history from file
    public void reloadEvidenceHistory() {
        try {
            myevidence = jsonReader.read();
            System.out.println("Loaded " + "my evidences" + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }



}
