import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
public class hw extends Application{



	public void start(Stage primaryStage)throws Exception
	{
		 
		Parent root =FXMLLoader.load(getClass().getClassLoader().getResource("HW.fxml"));
			
		Scene sn = new Scene(root);
			
		primaryStage.centerOnScreen();	
		primaryStage.setTitle("Test Averages");
		primaryStage.setScene(sn);
		primaryStage.show(); 
	
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}

}