package app;

import java.io.IOException;

import controller.WindowController;
import services.HashMysqlService;
import view.WindowView;

public class Main {

	public static void main(String[] args) throws IOException {
		HashMysqlService service = new HashMysqlService();
		WindowView view = new WindowView();
		WindowController controller = new WindowController(service, view);
		
		controller.generatePassword();
		controller.getBtnClear();
	}
}
