package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;

import javax.swing.JOptionPane;

import services.HashMysqlService;
import view.WindowView;

public class WindowController {
	
	private WindowView windowView;
	private HashMysqlService hashMysqlModel;
	private final String ERROR_MESSAGE = "O campo está vazio!\nFavor digite uma senha...";
	
	public WindowController(WindowView windowView, HashMysqlService hashMysqlModel) {
		this.windowView = windowView;
		this.hashMysqlModel = hashMysqlModel;
	}

	public void generatePassword() {
		
		windowView.getBtnGenerate().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String fieldPassword = windowView.getTextFieldPassword().getText().replaceAll(" ", "").trim();
					
					if(fieldPassword.equals("")){
						JOptionPane.showMessageDialog(windowView.getJframe(), ERROR_MESSAGE, "Erro", JOptionPane.ERROR_MESSAGE);
						windowView.getBtnClear();
						windowView.getTextFieldPassword().requestFocus();
					}else {
						
						
						String passwordEncrypted = hashMysqlModel.MySQLPassword(fieldPassword);
						windowView.getTextFieldOutPassword().setText(passwordEncrypted);
					}
				} catch (UnsupportedEncodingException error) {
					error.printStackTrace();
				}
				
			}
		});
	}
	
	public void clearFields() {
		windowView.getBtnClear().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				windowView.getBtnClear();
				windowView.getTextFieldPassword().requestFocus();
				
			}
		});
	}
}
