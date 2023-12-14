package app;

import java.io.IOException;

import controller.WindowController;
import services.HashMysqlService;
import view.WindowView;

public class Main {

	public static void main(String[] args) throws IOException {
		HashMysqlService service = new HashMysqlService();
		WindowController controller = new WindowController(service);
		WindowView view = new WindowView(controller);
		view.generatePassword();
		view.clear();
	}
}
