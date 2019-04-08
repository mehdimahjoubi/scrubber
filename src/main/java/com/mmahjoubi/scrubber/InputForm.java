package com.mmahjoubi.scrubber;

public class InputForm {

	public InputForm() {
	}
	
	public InputForm(String textField) {
		this.textField = textField;
	}

	private String textField;

	public String getTextField() {
		return textField;
	}

	public void setTextField(String textField) {
		this.textField = textField;
	}
}
