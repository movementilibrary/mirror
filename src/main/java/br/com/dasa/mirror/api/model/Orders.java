package br.com.dasa.mirror.api.model;

import java.util.List;
import java.util.Objects;

public class Orders {

	private Doctor doctor;

	private List<Exams> exams;

	public Orders() {
	}

	public Orders(Doctor doctor, List<Exams> exams) {
		this.doctor = doctor;
		this.exams = exams;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
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
		if (!(o instanceof Orders)) return false;
		Orders orders = (Orders) o;
		return Objects.equals(doctor, orders.doctor) &&
				Objects.equals(exams, orders.exams);
	}

	@Override
	public int hashCode() {
		return Objects.hash(doctor, exams);
	}

	@Override
	public String toString() {
		return "Orders{" +
				"doctor=" + doctor +
				", exams=" + exams +
				'}';
	}
}
