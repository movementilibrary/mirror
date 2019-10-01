package br.com.dasa.mirror.api.enumeration;

public enum TypeFile {
	BRAND("brand"), UNIT("unit");

	private TypeFile(String value) {
		this.value = value;
	}

	private String value;

	public String getValue() {
		return value;
	}

}
