package br.com.dasa.mirror.api.model.from.to.admission;

public class Scheduling {

	private String date;

	private String id;

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
	public String toString() {
		return "Scheduling [date = " + date + ", id = " + id + "]";
	}
}
