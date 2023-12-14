package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import utils.Util;

public class WindowView {
	private JFrame jframe;
	private JLabel labelPassword;
	private JTextField textFieldPassword;
	private JLabel labelOutPassword;
	private JTextField textFieldOutPassword;
	private JButton btnGenerate;
	private JButton btnClear;
	
	private final String DEFAULT_MESSAGE_TEXT_OUT_PASSWORD = "DIGITE A SENHA NO CAMPO ACIMA...";
	private final String ERROR_MESSAGE = "O campo está vazio!\nFavor digite uma senha...";
	
	public WindowView() throws IOException {
		jframe = new JFrame();
		GridLayout gridLayout = new GridLayout(3,2);
		JPanel panel = new JPanel(gridLayout);
		
		//labelPassword
		labelPassword =  new JLabel();
		gridLayout.addLayoutComponent(null, labelPassword);
		labelPassword.setText("Digite a senha:");
		labelPassword.setBounds(250, 150, 300, 50);
		Util.sizeFontLabel(labelPassword);
		panel.add(labelPassword);
		//textFieldPassword
		textFieldPassword = new JTextField(10);
		gridLayout.addLayoutComponent(null, textFieldPassword);
		textFieldPassword.selectAll();
		panel.add(textFieldPassword);
		
		//labelOutPassword
		labelOutPassword = new JLabel();
		gridLayout.addLayoutComponent(null, labelOutPassword);
		labelOutPassword.setText("Senha criptografada:");
		labelOutPassword.setBounds(250, 150, 300, 50);
		Util.sizeFontLabel(labelOutPassword);
		panel.add(labelOutPassword);
		//textFieldOutPassword
		textFieldOutPassword = new JTextField(10);
		gridLayout.addLayoutComponent(null, textFieldOutPassword);
		textFieldOutPassword.setForeground(Color.RED);
		textFieldOutPassword.setEditable(false);
		textFieldOutPassword.setText(DEFAULT_MESSAGE_TEXT_OUT_PASSWORD);
		panel.add(textFieldOutPassword);
		
		//ButtonClearFields
		btnClear = new JButton();
		btnClear.setText("LIMPAR CAMPOS");
		gridLayout.addLayoutComponent(null, btnClear);
		panel.add(btnClear);
		
		//ButtonGenerate
		btnGenerate  = new JButton();
		btnGenerate.setText("GERAR SENHA");
		gridLayout.addLayoutComponent(null, btnGenerate);
		panel.add(btnGenerate);

		Image imagem = ImageIO.read(getClass().getResource("/utils/chave.png"));
		jframe.setTitle("Gerador de Senha Criptografada MYSQL [By: Alisson DEV]");
		jframe.add(panel);
		jframe.setIconImage(imagem);
		jframe.setSize(700, 150);
		jframe.setLocationRelativeTo(null);
		jframe.setResizable(false);
		jframe.setVisible(true);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}	
	public JTextField getTextFieldPassword() {
		return textFieldPassword;
	}

	public JButton getBtnGenerate() {
		return btnGenerate;
	}

	public void getBtnClear() {
		btnClear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textFieldPassword.setText("");
				textFieldOutPassword.setText(DEFAULT_MESSAGE_TEXT_OUT_PASSWORD);
				textFieldPassword.requestFocus();
			}
		});
	}
	
	public void showPasswordEncrypted(String password) {
		textFieldOutPassword.setText(password);
	}
	
	public void errorMessage() {
		JOptionPane.showMessageDialog(jframe, ERROR_MESSAGE, "Erro", JOptionPane.ERROR_MESSAGE);
	}
}
