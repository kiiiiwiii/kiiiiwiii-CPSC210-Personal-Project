package model;


import org.json.JSONObject;
import persistence.Writable;

// the class of different types of evidences
public class Evidence implements Writable {

    private final String answer;
    private final String inquiry;

    public static final Evidence suicide = new Evidence("Suicide?","Yes");
    public static final Evidence murder = new Evidence("Murder?", "No");
    public static final Evidence si = new Evidence("Secondary injury?", "Yes");
    public static final Evidence strangled = new Evidence("Strangled?", "Yes");
    public static final Evidence stab = new Evidence("Stab?", "No");
    public static final Evidence clm = new Evidence("Collaborative murder?", "No");
    public static final Evidence bm = new Evidence("Biological mother?", "Yes");
    public static final Evidence bf = new Evidence("Biological father?","No");
    public static final Evidence wp = new Evidence("Woman pregnant?", "No");
    public static final Evidence bage = new Evidence("Boy is around 5 years old?", "Yes");
    public static final Evidence wa = new Evidence("Woman is alive?", "Yes");
    public static final Evidence ba = new Evidence("Boy is alive?", "Yes");
    public static final Evidence na = new Evidence("Neighbour is alive?", "Yes");
    public static final Evidence nappd = new Evidence("Neighbour appeared during quarrel?", "No");
    public static final Evidence nappa = new Evidence("Neighbour appeared after quarrel?","Yes");
    public static final Evidence dis = new Evidence("Does neighbour has disability?", "No");
    public static final Evidence blo = new Evidence("Bloody?","Yes");
    public static final Evidence ddq = new Evidence("Dead during quarrel?", "No");
    public static final Evidence ncs = new Evidence("Neighbour changed the scene?", "No");
    public static final Evidence bcs = new Evidence("Boy changed the scene?", "Yes");
    public static final Evidence wcs = new Evidence("Woman changed the scene", "No");
    public static final Evidence acc = new Evidence("Is the crime accidental?", "No");
    public static final Evidence pla = new Evidence("Is the crime planned?", "No");
    public static final Evidence batcs = new Evidence("Is the boy still at the crime scene?","Yes");
    public static final Evidence watcs = new Evidence("Is the woman still at the crime scene?", "No");
    public static final Evidence bdr = new Evidence("Dis the boy put on dress for his father?", "Yes");
    public static final Evidence corpse = new Evidence("Is the corpse cut up?", "Yes");

    // EFFECTs: construct an evidence with inquiry and answer to it
    public Evidence(String inquiry, String answer) {
        this.inquiry = inquiry;
        this.answer = answer;

    }

    // EFFECTS: provide the inquiry part of an evidence
    public String getInquiry() {
        return inquiry;
    }


    // EFFECTS: provide the answer to an inquiry of an evidence
    public String getAnswer() {
        return answer;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("inquiry", inquiry);
        json.put("answer", answer);
        return json;
    }


}
