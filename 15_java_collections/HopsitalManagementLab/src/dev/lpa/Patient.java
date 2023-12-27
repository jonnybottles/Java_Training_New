package dev.lpa;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Patient extends Person{

    public enum HealthCondition {BAD_HEARING, ANXIETY, COMMON_COLD, CHRONES_DISEASE, DIABETES, CANCER}

    private List<HealthCondition> medicalHistory;


    public Patient(String name, String contactInfo) {
        super(name, contactInfo);
        this.medicalHistory = new ArrayList<>();

    }

    private Comparator<HealthCondition> sortByHealthConditionSeverity() {
        return Comparator.comparing(HealthCondition::ordinal).reversed();
    }

    public List<HealthCondition> getMedicalHistory() {
        return medicalHistory;
    }

    public boolean addCondition(HealthCondition condition) {
        if (findCondition(condition)) {
            System.out.println("Condition already in medical history");
            return false;
        }
        medicalHistory.add(condition);
        this.medicalHistory.sort(sortByHealthConditionSeverity());
        return true;
    }

    private boolean findCondition(HealthCondition condition) {
        return medicalHistory.contains(condition);
    }




}
