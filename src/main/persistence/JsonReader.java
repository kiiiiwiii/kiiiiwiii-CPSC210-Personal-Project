package persistence;

import model.Evidence;
import model.EvidenceBook;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// Represents a reader that reads EvidenceBook from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads EvidenceBook from file and returns it;
    // throws IOException if an error occurs reading data from file
    public EvidenceBook read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseEvidenceBook(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses EvidenceBook from JSON object and returns it
    private EvidenceBook parseEvidenceBook(JSONObject jsonObject) {
        EvidenceBook eb = new EvidenceBook();
        addEvidences(eb, jsonObject);
        return eb;
    }

    // MODIFIES: eb
    // EFFECTS: parses Evidences from JSON object and adds them to EvidenceBook
    private void addEvidences(EvidenceBook eb, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("myevidences");
        for (Object json : jsonArray) {
            JSONObject nextEvidence = (JSONObject) json;
            addEvidence(eb, nextEvidence);
        }
    }

    // MODIFIES: eb
    // EFFECTS: parses Evidence from JSON object and adds it to EvidenceBook
    private void addEvidence(EvidenceBook eb, JSONObject jsonObject) {
        String inquiry = jsonObject.getString("inquiry");
        String answer = jsonObject.getString("answer");
        Evidence evidence = new Evidence(inquiry, answer);
        eb.addEvidence(evidence);
    }
}