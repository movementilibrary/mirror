package br.com.dasa.mirror.api.model;

public class Orders {

	private Doctor doctor;

	private Exams[] exams;

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Exams[] getExams() {
		return exams;
	}

	public void setExams(Exams[] exams) {
		this.exams = exams;
	}

	@Override
	public String toString() {
		return "Orders [doctor = " + doctor + ", exams = " + exams + "]";
	}
}
