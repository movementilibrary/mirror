package br.com.dasa.mirror.api.model;

import java.util.List;

public class ResponseMedicalOrders {

    private String uuid;
    private String doctorId;
	private List<Exams> exams;

    public ResponseMedicalOrders() {

    }

    public ResponseMedicalOrders(String uuid, String doctorId, List<Exams> exams) {
        this.uuid = uuid;
        this.doctorId = doctorId;
        this.exams = exams;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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
}
