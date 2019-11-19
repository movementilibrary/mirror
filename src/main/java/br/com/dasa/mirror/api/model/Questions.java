package br.com.dasa.mirror.api.model;

import java.util.List;

public class Questions {
	
	private String question;

	private String answer;

	private List<AdditionalProperties> additionalProperties;



	public Questions() {
	}

	public Questions(String question, String answer, List<AdditionalProperties> additionalProperties) {
		this.question = question;
		this.answer = answer;
		this.additionalProperties = additionalProperties;
	}


	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public List<AdditionalProperties> getAdditionalProperties() {
		return additionalProperties;
	}

	public void setAdditionalProperties(List<AdditionalProperties> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}
}
