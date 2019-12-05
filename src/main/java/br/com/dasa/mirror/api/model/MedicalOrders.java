package br.com.dasa.mirror.api.model;

import br.com.dasa.mirror.api.enumeration.State;

import java.util.List;
import java.util.Objects;

public class MedicalOrders {

    private  String uuid;
    private String doctorIdentifierKind;
    private String doctorIdentifierValue;
    private String doctorState;
    private List<Exams> exams;


    public MedicalOrders() {
    }

    public MedicalOrders(String uuid, String doctorIdentifierKind, String doctorIdentifierValue, String doctorState, List<Exams> exams) {
        this.uuid = uuid;
        this.doctorIdentifierKind = doctorIdentifierKind;
        this.doctorIdentifierValue = doctorIdentifierValue;
        this.doctorState = doctorState;
        this.exams = exams;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
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

    public String getDoctorState() {
        return doctorState;
    }

    public void setDoctorState(String doctorState) {
        this.doctorState = doctorState;
    }

    public List<Exams> getExams() {
        return exams;
    }

    public void setExams(List<Exams> exams) {
        this.exams = exams;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MedicalOrders)) return false;
        MedicalOrders that = (MedicalOrders) o;
        return Objects.equals(uuid, that.uuid) &&
                Objects.equals(doctorIdentifierKind, that.doctorIdentifierKind) &&
                Objects.equals(doctorIdentifierValue, that.doctorIdentifierValue) &&
                doctorState == that.doctorState &&
                Objects.equals(exams, that.exams);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, doctorIdentifierKind, doctorIdentifierValue, doctorState, exams);
    }

    @Override
    public String toString() {
        return "MedicalOrders{" +
                "uuid='" + uuid + '\'' +
                ", doctorIdentifierKind='" + doctorIdentifierKind + '\'' +
                ", doctorIdentifierValue='" + doctorIdentifierValue + '\'' +
                ", doctorState=" + doctorState +
                ", exams=" + exams +
                '}';
    }
}
