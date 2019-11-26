package br.com.dasa.mirror.api.model;

import java.util.List;

public class MedicalOrders {

    private String id;
    private String doctorId;
	private List<Exams> exams;

    public MedicalOrders() {

    }

    public MedicalOrders(String id, String doctorId, List<Exams> exams) {
        this.id = id;
        this.doctorId = doctorId;
        this.exams = exams;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public List<Exams> getExams() {
        return exams;
    }

    public void setExams(List<Exams> exams) {
        this.exams = exams;
    }

    @Override
    public String toString() {
        return "MedicalOrders{" +
                "id='" + id + '\'' +
                ", doctorId='" + doctorId + '\'' +
                ", exams=" + exams +
                '}';
    }
}
