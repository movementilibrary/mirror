package br.com.dasa.mirror.api.model.from.to.admission;

public class Questions {
	
	private String question;

	private String answer;

	private AdditionalProperties[] additionalProperties;

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

	public AdditionalProperties[] getAdditionalProperties() {
		return additionalProperties;
	}

	public void setAdditionalProperties(AdditionalProperties[] additionalProperties) {
		this.additionalProperties = additionalProperties;
	}

	@Override
	public String toString() {
		return "Questions [question = " + question + ", answer = " + answer + ", additionalProperties = "
				+ additionalProperties + "]";
	}
}
