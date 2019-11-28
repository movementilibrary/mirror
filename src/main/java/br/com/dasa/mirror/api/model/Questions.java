package br.com.dasa.mirror.api.model;

import java.util.List;
import java.util.Objects;

public class Questions {
	
	private String question;

	private String answer;

	private List<AdditionalProperties> additionalProperties;

    private String uuid;

	public Questions() {
	}

	public Questions(String question, String answer, List<AdditionalProperties> additionalProperties, String uuid) {
		this.question = question;
		this.answer = answer;
		this.additionalProperties = additionalProperties;
		this.uuid = uuid;
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

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Questions)) return false;
		Questions questions = (Questions) o;
		return Objects.equals(question, questions.question) &&
				Objects.equals(answer, questions.answer) &&
				Objects.equals(additionalProperties, questions.additionalProperties) &&
				Objects.equals(uuid, questions.uuid);
	}

	@Override
	public int hashCode() {
		return Objects.hash(question, answer, additionalProperties, uuid);
	}

	@Override
	public String toString() {
		return "Questions{" +
				"question='" + question + '\'' +
				", answer='" + answer + '\'' +
				", additionalProperties=" + additionalProperties +
				", uuid='" + uuid + '\'' +
				'}';
	}
}
