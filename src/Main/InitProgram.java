package Main;

import javafx.application.Application;
import javafx.stage.Stage;

public class InitProgram extends Application
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//System.out.println(System.getProperty("user.dir"));
		launch(args);

	}
	
	
	@Override
	public void start(Stage arg0) throws Exception 
	{
		// TODO Auto-generated method stub
		RunEditor.startProgram(arg0);
		
	}

}
