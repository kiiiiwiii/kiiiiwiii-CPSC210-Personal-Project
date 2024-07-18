package model;


import static model.Evidence.*;

// the class of operations of enter strings
public class EvidenceInputOperation {

    public EvidenceInputOperation() {
    }

    // EFFECTS: operate player's enter for cause of death section
    public String operateCDEvidenceEnter(String enter) {
        if (enter.equals("Suicide?")) {
            return (suicide.getAnswer());
        } else if (enter.equals("Murder?")) {
            return (murder.getAnswer());
        } else if (enter.equals("Secondary injury?")) {
            return (si.getAnswer());
        } else if (enter.equals("Strangled?")) {
            return (strangled.getAnswer());
        } else if (enter.equals("Stab?")) {
            return (stab.getAnswer());
        } else if (enter.equals("Collaborative murder?")) {
            return (clm.getAnswer());
        }
        return null;
    }

    // EFFECTS: operate player's enter for character relationships section
    public String operateCREvidenceEnter1(String enter) {
        if (enter.equals("Biological mother?")) {
            return (bm.getAnswer());
        } else if (enter.equals("Biological father?")) {
            return (bf.getAnswer());
        } else if (enter.equals("Woman pregnant?")) {
            return (wp.getAnswer());
        } else if (enter.equals("Boy is around 5 years old?")) {
            return (bage.getAnswer());
        } else if (enter.equals("Woman is alive?")) {
            return (wa.getAnswer());
        } else if (enter.equals("Boy is alive?")) {
            return (ba.getAnswer());
        }
        return null;
    }

    // EFFECTS: operate player's enter for character relationships section
    public String operateCREvidenceEnter2(String enter) {
        if (enter.equals("Neighbour is alive?")) {
            return (na.getAnswer());
        } else if (enter.equals("Neighbour appeared during quarrel?")) {
            return (nappd.getAnswer());
        } else if (enter.equals("Neighbour appeared after quarrel?")) {
            return (nappa.getAnswer());
        } else if (enter.equals("Does neighbour has disability?")) {
            return (dis.getAnswer());
        }
        return null;
    }

    // EFFECTS: operate player's enter for crime scene section
    public String operateCSEvidenceEnter1(String enter) {
        if (enter.equals("Bloody?")) {
            return (blo.getAnswer());
        } else if (enter.equals("Dead during quarrel?")) {
            return (ddq.getAnswer());
        } else if (enter.equals("Neighbour changed the scene?")) {
            return (ncs.getAnswer());
        } else if (enter.equals("Boy changed the scene?")) {
            return (bcs.getAnswer());
        }
        return null;
    }

    // EFFECTS: operate player's enter for crime scene section
    public String operateCSEvidenceEnter2(String enter) {
        if (enter.equals("Woman changed the scene?")) {
            return (wcs.getAnswer());
        } else if (enter.equals("Is the crime accidental?")) {
            return (acc.getAnswer());
        } else if (enter.equals("Is the crime planned?")) {
            return (pla.getAnswer());
        } else if (enter.equals("Is the boy still at the crime scene?")) {
            return (batcs.getAnswer());
        } else if (enter.equals("Is the woman still at the crime scene?")) {
            return (watcs.getAnswer());
        } else if (enter.equals("Did the boy put on dress for his father?")) {
            return (bdr.getAnswer());
        } else if (enter.equals("Is the corpse cut up?")) {
            return (corpse.getAnswer());
        }
        return null;
    }

}
