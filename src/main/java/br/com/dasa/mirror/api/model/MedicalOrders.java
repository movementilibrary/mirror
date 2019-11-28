package br.com.dasa.mirror.api.model;

import br.com.dasa.mirror.api.enumeration.State;

import java.util.List;
import java.util.Objects;

public class MedicalOrders {

    private String doctorIdentifierKind;
    private String doctorIdentifierValue;
    private State state;
    private List<Exams> exams;
    private  String uuid;


    public MedicalOrders() {
    }

    public MedicalOrders(String doctorIdentifierKind, String doctorIdentifierValue, State state, List<Exams> exams, String uuid) {
        this.doctorIdentifierKind = doctorIdentifierKind;
        this.doctorIdentifierValue = doctorIdentifierValue;
        this.state = state;
        this.exams = exams;
        this.uuid = uuid;
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

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public List<Exams> getExams() {
        return exams;
    }

    public void setExams(List<Exams> exams) {
        this.exams = exams;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MedicalOrders)) return false;
        MedicalOrders that = (MedicalOrders) o;
        return Objects.equals(doctorIdentifierKind, that.doctorIdentifierKind) &&
                Objects.equals(doctorIdentifierValue, that.doctorIdentifierValue) &&
                state == that.state &&
                Objects.equals(exams, that.exams) &&
                Objects.equals(uuid, that.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doctorIdentifierKind, doctorIdentifierValue, state, exams, uuid);
    }

    @Override
    public String toString() {
        return "MedicalOrders{" +
                "doctorIdentifierKind='" + doctorIdentifierKind + '\'' +
                ", doctorIdentifierValue='" + doctorIdentifierValue + '\'' +
                ", state=" + state +
                ", exams=" + exams +
                ", uuid='" + uuid + '\'' +
                '}';
    }
}
