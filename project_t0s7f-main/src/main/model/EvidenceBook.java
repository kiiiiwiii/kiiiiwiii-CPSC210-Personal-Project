package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.Arrays;

import static model.Evidence.*;


// a collection of evidences player have so far
public class EvidenceBook implements Writable {

    private ArrayList<Evidence> myevidences;
    private Evidence evi = new Evidence("inquiry","answer");

    // EFFECTS: construct a list of evidences
    public EvidenceBook() {
        myevidences = new ArrayList<>();

    }

    public void completeBook() {
        for (Evidence evidence : Arrays.asList(suicide,murder, si, strangled, stab, clm, bm, bf,
                wp, bage, wa, ba, na, nappd, nappa, dis,
                blo, ddq, ncs, bcs, wcs, acc, pla, batcs,
                watcs, bdr, corpse)) {
            myevidences.add(evidence);
        }
    }

    // EFFECTS: return evidences in the current evidence list
    public ArrayList<Evidence> getEvidenceBook() {
        return myevidences;

    }

    //EFFECTS: add the evidence to my evidence list
    public void addEvidence(Evidence evi) {
        myevidences.add(evi);
        EventLog.getInstance().logEvent(new Event("Added " + evi.getInquiry() + " to evidence history."));
    }

    // EFFECTS: return the size of evidence list
    public int length() {
        return myevidences.size();
    }

    public void clearEvidence() {
        myevidences.removeAll(myevidences);
        EventLog.getInstance().logEvent(new Event("Cleared evidence history."));
    }


    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", "evidence history");
        json.put("myevidences", evidencesToJson());
        return json;
    }

    // EFFECTS: returns things in this EvidenceBook as a JSON array
    public JSONArray evidencesToJson() {
        JSONArray jsonArray = new JSONArray();
        for (Evidence e : myevidences) {
            jsonArray.put(e.toJson());
        }
        return jsonArray;
    }

}
