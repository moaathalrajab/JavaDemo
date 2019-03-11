import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JOptionPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

public class myController {
	double average;         // Test average
    int studentNumber = 1;
    @FXML
    private Tab tabF;

    @FXML
    private TextArea fst;

    @FXML
    private Tab tabA;

    @FXML
    private TextArea Avg;

    @FXML
    void about(ActionEvent event) {
    	JOptionPane.showMessageDialog(null, "Moumen was here","About the Devolopers", 1);
    }

    @FXML
    void close(ActionEvent event) {
    	System.exit(0);
    }

    @FXML
    void open(ActionEvent event) throws Exception {
    	FileChooser fc= new FileChooser(); 
    	fc.setTitle("Open File");
    	
    	new FileChooser.ExtensionFilter("EXCEL file(*.csv)", ".CSV");
    	File eFile = fc.showOpenDialog(null); 
    	
    	StringBuilder stb = new StringBuilder();
    	
    	BufferedReader bfr = new BufferedReader(new FileReader(eFile));
    	
    	String line = bfr.readLine();
    	
    	if(eFile !=null) {
    		
    		while (line !=null) {
    			
    		stb.append(line).append("\n");
    		
    		line = bfr.readLine();
    		}
    	
    	String aString = stb.toString();
    	fst.setText(aString.replaceAll(",", "\t"));
    	}
    	bfr.close();
    	
    	 TestScoreReader scoreReader =
                 new TestScoreReader(eFile);
     String avgStr="tt";
     // Display the averages.
     while (scoreReader.readNextLine())
     {
        // Get the average from the TestScoreReader.
        average = scoreReader.getAverage();
        
        // Display the student's average.
        avgStr+= "Average for student " +
                           studentNumber + " is " +
                           average +"\n";

        // Increment the student number.
        studentNumber++;
     }
     
     // Close the TestScoreReader.
     scoreReader.close();
     Avg.setText(avgStr);
    	
    }
}

