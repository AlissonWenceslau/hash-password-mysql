package app;

import java.io.IOException;

import controller.WindowController;
import services.HashMysqlModel;
import view.WindowView;

public class Main {

	public static void main(String[] args) throws IOException {
		WindowView view = new WindowView();
		HashMysqlModel model = new HashMysqlModel();
		WindowController controller = new WindowController(view, model);
		
		controller.generatePassword();
		controller.clearFields();
	}
}
