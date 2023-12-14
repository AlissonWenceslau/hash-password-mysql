package controller;

import java.io.UnsupportedEncodingException;

import services.HashMysqlService;

public class WindowController {
	
	private HashMysqlService service;
	
	public WindowController(HashMysqlService service) {
		this.service = service;
	}

	public String generatePassword(String textField) throws UnsupportedEncodingException {
		if(textField.equals("")) {
			throw new IllegalArgumentException();
		}
		String password = textField.replaceAll(" ", "").trim();
		password = service.MySQLPassword(password);
		
		return password;
	}
}
