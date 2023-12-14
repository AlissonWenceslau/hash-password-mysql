package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;

import services.HashMysqlService;
import view.WindowView;

public class WindowController {
	
	private HashMysqlService service;
	private WindowView view;
	
	public WindowController(HashMysqlService service, WindowView view) {
		this.service = service;
		this.view = view;
	}

	public void generatePassword() {
		view.getBtnGenerate().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent error) {
				try {
					String inputPassword = view.getTextFieldPassword().getText().replaceAll(" ", "").trim();			
					if(inputPassword.equals("")) {
						throw new IllegalAccessException();
					}		
					String password = service.MySQLPassword(inputPassword);
					view.showPasswordEncrypted(password);
					
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					view.errorMessage();
				}
				
			}
		});
	}
	
	public void getBtnClear() {
		view.getBtnClear();
	}
}
