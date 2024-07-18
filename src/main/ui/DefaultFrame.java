package ui;

import model.Event;
import model.Menu;
import model.*;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

// Frame class
public class DefaultFrame extends Solver implements ActionListener {


    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;


    private SituationPuzzle puzzle;
    private AttemptStage atp;
    private EvidenceBook evidenceBook;
    private EvidenceBook myevidence;
    private Menu menu;
    private EvidenceInputOperation eio;
    private JsonReader jsonReader;
    private JsonWriter jsonWriter;

    private JPanel labelBackMsg;
    private JTextArea userTextArea;
    private JButton askBtt;
    private JButton startBtt;
    private JButton evidenceBtt;
    private JButton evidenceHistoryBtt;
    private JButton attemptBtt;
    private JButton quitBtt;
    private JButton reloadBtt;
    private JButton endGameBtt;
    private JButton answerBtt;
    private JButton saveBtt;
    private JButton dontsaveBtt;
    private JButton removeBtt;
    private JFrame frame;


    //constructor of DefaultFrame
    public DefaultFrame() {
        frame = new JFrame();
        frame.setTitle("Situation Puzzle");
        iniFrame();
        positeFrame();
        functionButton();
        frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame.setLayout(null);
        frame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);

    }

    // EFFECTS: initialize all required for constructing frame
    public void iniFrame() {
        labelBackMsg = new JPanel();
        userTextArea = new JTextArea("");
        puzzle = new SituationPuzzle(3);
        evidenceBook = new EvidenceBook();
        evidenceBook.completeBook();
        myevidence = new EvidenceBook();
        menu = new Menu();
        atp = new AttemptStage();
        eio = new EvidenceInputOperation();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        startBtt = new JButton("Start");
        evidenceBtt = new JButton("Evidence");
        evidenceHistoryBtt = new JButton("Evidence History");
        attemptBtt = new JButton("Attempt");
        quitBtt = new JButton("Quit");
        reloadBtt = new JButton("Reload");
        endGameBtt = new JButton("End Game");
        askBtt = new JButton("ask");
        answerBtt = new JButton("answer");
        saveBtt = new JButton("save");
        dontsaveBtt = new JButton("exit");
        removeBtt = new JButton("remove");

    }



    // EFFECTS: set position for label, buttons, and textarea, display initial string for player
    @SuppressWarnings("methodlength")
    public void positeFrame() {
        JTextArea iniText = new JTextArea("\nWelcome to Situation Puzzle Game, detective\n"
                + "\nClick 'Start' to get started\n"
                + "\nClick 'Evidence' to get evidence\n"
                + "\nClick 'Evidence History' to review evidence history\n"
                + "\nClick 'Attempt' to begin your attempts\n"
                + "\nClick 'Quit' to quit game and resume later\n"
                + "\nClick 'Reload' to reload evidence history from file\n"
                + "\nClick 'End Game' to end game and show original story\n"
                + "\nClick 'remove' to remove all evidence history so far\n");
        iniText.setEditable(false);
        frame.add(iniText);
        iniText.setBounds(10, 20, 400, 300);
        labelBackMsg.setBounds(10,5,450,400);
        labelBackMsg.setBackground(Color.WHITE);
        frame.add(labelBackMsg);
        userTextArea.setBounds(10, 450, 400, 80);
        frame.add(userTextArea);

        evidenceBtt.setBounds(600, 20, 150, 50);
        evidenceHistoryBtt.setBounds(600, 80, 150, 50);
        attemptBtt.setBounds(600, 140, 150, 50);
        quitBtt.setBounds(600, 200, 150, 50);
        reloadBtt.setBounds(600, 260, 150, 50);
        endGameBtt.setBounds(600, 320, 150, 50);
        startBtt.setBounds(600, 380, 150, 50);
        askBtt.setBounds(450, 450, 100, 40);
        answerBtt.setBounds(450, 500, 100, 40);
        saveBtt.setBounds(570, 450, 100, 40);
        dontsaveBtt.setBounds(570, 500, 100, 40);
        removeBtt.setBounds(690, 450, 100, 40);

    }


    // EFFECTS: assign functions to button
    @SuppressWarnings("methodlength")
    public void functionButton() {
        frame.add(evidenceBtt);
        evidenceBtt.setActionCommand("e");
        evidenceBtt.addActionListener(this);

        frame.add(evidenceHistoryBtt);
        evidenceHistoryBtt.setActionCommand("h");
        evidenceHistoryBtt.addActionListener(this);

        frame.add(attemptBtt);
        attemptBtt.setActionCommand("a");
        attemptBtt.addActionListener(this);

        frame.add(quitBtt);
        quitBtt.setActionCommand("q");
        quitBtt.addActionListener(this);

        frame.add(reloadBtt);
        reloadBtt.setActionCommand("l");
        reloadBtt.addActionListener(this);

        frame.add(endGameBtt);
        endGameBtt.setActionCommand("end game");
        endGameBtt.addActionListener(this);

        frame.add(startBtt);
        startBtt.setActionCommand("start");
        startBtt.addActionListener(this);

        frame.add(askBtt);
        askBtt.setActionCommand("ask");
        askBtt.addActionListener(this);

        frame.add(answerBtt);
        answerBtt.setActionCommand("answer");
        answerBtt.addActionListener(this);

        frame.add(saveBtt);
        saveBtt.setActionCommand("save");
        saveBtt.addActionListener(this);

        frame.add(dontsaveBtt);
        dontsaveBtt.setActionCommand("dont save");
        dontsaveBtt.addActionListener(this);

        frame.add(removeBtt);
        removeBtt.setActionCommand("remove");
        removeBtt.addActionListener(this);
    }

    // EFFECTS: jump to the corresponding function for each button
    @SuppressWarnings("methodlength")
    @Override
    public void actionPerformed(ActionEvent e) {
        String key = e.getActionCommand();
        if (key.equals("e")) {
            displayMenu();
        } else if (key.equals("h")) {
            showHistory();
        } else if (key.equals("a")) {
            beginAttempt();
        } else if (key.equals("q")) {
            reminderMenu();
        } else if (key.equals("l")) {
            reloadHistory();
        } else if (key.equals("end game")) {
            endGame();
        } else if (key.equals("start")) {
            startGame();
        } else if (key.equals("ask")) {
            processInquiryEnter();
        } else if (key.equals("answer")) {
            processAnswerEnter();
        } else if (key.equals("save")) {
            processSave();
        } else if (key.equals("dont save")) {
            this.print(EventLog.getInstance());
            ClearLogAction clear = new ClearLogAction();
            System.exit(0);
        } else if (key.equals("remove")) {
            myevidence.clearEvidence();
        }
    }


    // MODIFIES: this
    // EFFECTS: save evidence history to file
    private void processSave() {
        try {
            jsonWriter.open();
            jsonWriter.write(myevidence);
            jsonWriter.close();
            JTextArea save = new JTextArea();
            save.setText("Saved " + "my evidences" + " to " + JSON_STORE
                        + "\nYou can click 'exit' button now");
            frame.add(save);
            save.setBounds(10, 20, 450, 400);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // EFFECTS: check answer enter from text area
    private void processAnswerEnter() {
        String usertEnter = userTextArea.getText();

        JTextArea attemptFeedBack = new JTextArea();
        attemptFeedBack.setText(checkAttemptEnter(usertEnter, puzzle, atp));
        frame.add(attemptFeedBack);
        attemptFeedBack.setBounds(10, 20, 450, 400);
    }

    // show category menu for user to ask
    public void displayMenu() {
        JTextArea evidenceMenu = new JTextArea("\nEnter 'cd' for cause of death\n"
                + "\nEnter 're' for character's relationship\n"
                + "\nEnter 'cs' for crime scene\n "
                + "\nThen click ask button\n");
        frame.add(evidenceMenu);
        evidenceMenu.setBounds(10, 20, 450, 400);
    }


    // EFFECTS: show evidence history
    public void showHistory() {
        int count = 0;
        List<String> historylist = new ArrayList<>();
        historylist = checkEvidenceBook(myevidence);
        if (historylist.size() == 0) {
            new NewWindow();
        }

        for (String s : historylist) {
            JTextArea history = new JTextArea(s);
            frame.add(history);
            history.setBounds(10, (20 + count * 50), 450, 50);
            history.setVisible(true);
            count++;
        }

    }


    // EFFECTS: begin answering
    public void beginAttempt() {
        JTextArea beginAttemptMenu = new JTextArea("\nLooks like you already know the truth, tell me, who did this.\n"
                + "\nYou have" + " " + puzzle.getAttempts() + " " + "chances, good luck.\n"
                + "\nEnter 'Boy', 'neighbour', 'woman', or 'man'.\n"
                + "\nThen click 'answer' button\n");
        frame.add(beginAttemptMenu);
        beginAttemptMenu.setBounds(10, 20, 450, 400);

    }

    // EFFECTS: reload history that user saved
    public void reloadHistory() {
        try {
            myevidence = jsonReader.read();
            JTextArea load = new JTextArea();
            load.setText("Loaded " + "my evidences" + " from " + JSON_STORE);
            frame.add(load);
            load.setBounds(10, 20, 450, 400);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    // EFFECTS: End game and show original story to user
    public void endGame() {
        JTextArea ending = new JTextArea("\nduring a quarrel, the hostess revealed that "
                + "\nthe boy's biological father was not the man, "
                + "\nand the man hanged himself.The boy witnessed his "
                + "\nfather’s death. He loved the family so much that "
                + "\nhe wished he was the his child. "
                + "\nSo he dressed his father's corpse in maternity clothes, "
                + "\ncut open his father's stomach and "
                + "\ndug out all his internal organs, put himself into"
                + "\n his father’s stomach, then bound themselves together "
                + "\nwith hemp rope to satisfy himself. "
                + "\nThe neighbour was scared so she did not call the police.");
        frame.add(ending);
        ending.setBounds(10, 20, 450, 400);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // EFFECTS: start game and show story
    public void startGame() {
        JTextArea start = new JTextArea("\nA family of three had a quarrel. "
                + "\nThe neighbour found the man dead in his home the next day, "
                + "\nbound with hemp rope and dressed in maternity clothes. "
                + "\nThe neighbour did not call the police. Why?");
        frame.add(start);
        start.setBounds(10, 20, 450, 400);
    }

    // EFFECTS: show reminder menu for user before they exit
    public void reminderMenu() {
        JTextArea reminderMenu = new JTextArea("\nClick 'save' to save your evidence history.\n"
                + "\nClick 'exit' to directly quit game.\n");
        frame.add(reminderMenu);
        reminderMenu.setBounds(10, 20, 450, 400);
    }


    // EFFECTS: give answer to inquiry user entered
    public void processInquiryEnter() {
        String userenter = userTextArea.getText();
        if (userenter.equals("cd") || userenter.equals("re") || userenter.equals("cs")) {
            evidenceMenu(userenter);
        }

        String a = new String();
        a = operateEvidenceEnter(userenter, eio);
        if (a != null) {
            addEvidenceTo(userenter, myevidence, evidenceBook);
            JTextArea response = new JTextArea(a);
            frame.add(response);
            response.setVisible(true);
            response.setBounds(10, 20, 450, 400);
        }

    }

    @SuppressWarnings("methodlength")
    // EFFECTS: show evidence menu on screen
    public void evidenceMenu(String enter) {
        if (enter.equals("cd")) {
            JTextArea cd = new JTextArea();
            cd.setText(menu.showCauseOfDeathMenu());
            frame.add(cd);
            cd.setBounds(10, 20, 450, 400);

        }
        if (enter.equals("re")) {
            JTextArea re = new JTextArea();
            re.setText(menu.showCharactersRelationMenu());
            frame.add(re);
            re.setBounds(10, 20, 450, 400);
        }
        if (enter.equals("cs")) {
            JTextArea cs = new JTextArea();
            cs.setText(menu.showCrimeSceneMenu());
            frame.add(cs);
            cs.setBounds(10, 20, 450, 400);
        }
    }

    //EFFECTS: prints the event log in console
    private void print(EventLog eventLog) {
        String msg = "";
        for (Event next : eventLog) {
            msg = msg + next.toString() + "\n\n";
        }
        System.out.println(msg);
    }

    private class ClearLogAction extends AbstractAction {
        ClearLogAction() {
            super("Clear log");
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            EventLog.getInstance().clear();
        }
    }


}
