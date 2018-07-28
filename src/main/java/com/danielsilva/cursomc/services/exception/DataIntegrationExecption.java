package com.danielsilva.cursomc.services.exception;

public class DataIntegrationExecption extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public DataIntegrationExecption(String msg) {
		super(msg);
	}
	
	public DataIntegrationExecption(String msg, Throwable cause) {
		super(msg, cause);
	}

}
