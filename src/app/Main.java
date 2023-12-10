package app;

import java.io.IOException;

import controller.WindowController;
import services.HashMysqlService;
import view.WindowView;

public class Main {

	public static void main(String[] args) throws IOException {
		WindowView view = new WindowView();
		HashMysqlService model = new HashMysqlService();
		WindowController controller = new WindowController(view, model);
		
		controller.generatePassword();
		controller.clearFields();
	}
}
