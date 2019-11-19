package br.com.dasa.mirror.api.model;

import java.util.Objects;

public class Scheduling {

	private String date;

	private String id;


	public Scheduling() {
	}

	public Scheduling(String date, String id) {
		this.date = date;
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Scheduling)) return false;
		Scheduling that = (Scheduling) o;
		return Objects.equals(date, that.date) &&
				Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, id);
	}

	@Override
	public String toString() {
		return "Scheduling{" +
				"date='" + date + '\'' +
				", id='" + id + '\'' +
				'}';
	}
}
