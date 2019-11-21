package br.com.dasa.mirror.api.model;

import java.util.List;

public class MedicalOrders {

    private String doctorIdentifierKind;
    private String doctorIdentifierValue;
    private String doctorState;
    private String uuid;
    private List<Exams> exams;


    public MedicalOrders(String doctorIdentifierKind) {
        this.doctorIdentifierKind = doctorIdentifierKind;
    }

    public MedicalOrders(String doctorIdentifierKind, String doctorIdentifierValue, String doctorState, String uuid, List<Exams> exams) {
        this.doctorIdentifierKind = doctorIdentifierKind;
        this.doctorIdentifierValue = doctorIdentifierValue;
        this.doctorState = doctorState;
        this.uuid = uuid;
        this.exams = exams;
    }

    public String getDoctorIdentifierKind() {
        return doctorIdentifierKind;
    }

    public void setDoctorIdentifierKind(String doctorIdentifierKind) {
        this.doctorIdentifierKind = doctorIdentifierKind;
    }

    public String getDoctorIdentifierValue() {
        return doctorIdentifierValue;
    }

    public void setDoctorIdentifierValue(String doctorIdentifierValue) {
        this.doctorIdentifierValue = doctorIdentifierValue;
    }

    public String getDoctorState() {
        return doctorState;
    }

    public void setDoctorState(String doctorState) {
        this.doctorState = doctorState;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public List<Exams> getExams() {
        return exams;
    }

    public void setExams(List<Exams> exams) {
        this.exams = exams;
    }
}
