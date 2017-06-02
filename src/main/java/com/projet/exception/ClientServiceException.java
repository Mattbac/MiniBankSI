package com.projet.exception;

public class ClientServiceException extends Exception {

	private String champ;

	public ClientServiceException(String champ, String message) {
		super(message);
		this.champ = champ;
	}

	public String getChamp() {
		return champ;
	}

	public void setChamp(String champ) {
		this.champ = champ;
	}
}
