package main;

import javafx.application.Application;
import javafx.stage.Stage;
import gui.CafeControl;
public class Main extends Application{

	public static void main(String[] args)  {
		// TODO Auto-generated method stub

		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		new CafeControl(primaryStage);
	}

}
