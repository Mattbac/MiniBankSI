package com.projet.exception;

public class virementException extends Exception {
	private static final long serialVersionUID = 5324225868906543594L;
	private String champ;

	
	/* Getter */
	public String getChamp() { return champ; }
	
	
	/* Setter */
	public void setChamp(String champ) { this.champ = champ; }
	
	
	/* Constructor */
	public virementException(String champ, String message) {
		super(message);
		this.champ = champ;
	}
}
