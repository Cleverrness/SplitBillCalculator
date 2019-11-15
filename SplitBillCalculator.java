/* Code for Class Lab 11/14/19
 * Student: Jose Soto
 * CISC 3115
 * Brooklyn College, Fall 2019
 */
package splitbillcalculator;

import java.util.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;

public class SplitBillCalculator extends Application {
    private TextField tfBill = new TextField();
    private TextField tfTax = new TextField();
    private TextField tfSplit = new TextField();
    private Button btCalculate = new Button("Calculate");
    Label msg1;
    
    @Override
    public void start(Stage primaryStage) {
        //Create UI
        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.add(new Label("Bill:"),0,0);
        gridPane.add(tfBill, 1, 0);
        gridPane.add(new Label("Tax:"),0,1);
        gridPane.add(tfTax, 1, 1);
        gridPane.add(new Label("Split:"),0, 2);
        gridPane.add(tfSplit, 1, 2);
        //gridPane.add(btCalculate, 1, 3);
      
        //Set properties for UI
        gridPane.setAlignment(Pos.CENTER);
        tfBill.setAlignment(Pos.BOTTOM_RIGHT);
        tfTax.setAlignment(Pos.BOTTOM_RIGHT);
        tfSplit.setAlignment(Pos.BOTTOM_RIGHT);
        GridPane.setHalignment(btCalculate, HPos.RIGHT);

        //Process events
        msg1 = new Label();
            msg1.setWrapText(true);
            msg1.setPrefWidth(300);
	    msg1.setWrapText(true);
            gridPane.add(msg1, 1, 4);
        btCalculate.setOnAction(e -> calculateSplitBill());
        HBox buttonBox = new HBox();
	    buttonBox.getChildren().add(btCalculate);
            buttonBox.setAlignment(Pos.BOTTOM_RIGHT);
            gridPane.add(btCalculate, 1, 3);
		
        //Create a scene and place it in the stage
        Scene scene = new Scene(gridPane, 400, 400);
        primaryStage.setTitle("Split Bill Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void calculateSplitBill(){
        //Get input from text fields.
        double bill = Double.parseDouble(tfBill.getText());
        double tax = Double.parseDouble(tfTax.getText());
        int split = Integer.parseInt(tfSplit.getText());
        
        /*this try will execute the calculations, and will throw an exception
        if tax is less than 0 or the split is less than 1 and instead of 
        posting the final message is a label, will post Arithmetic error instead*/
        try{
        double total = (bill + (bill*(tax/100)));        
        double totalSplit = (double)(total/(split*1.0));
        
        if(tax < 0)
            throw new ArithmeticException("Tax can't be less than 0");
        if(split < 1)
            throw new ArithmeticException("Split can't be less than 1");
        msg1.setText("After being split " + split + " ways, " + 
            String.format("The total for the bill is $%.2f and split its $%.2f", total, totalSplit));
        }
        catch(ArithmeticException ex){
            msg1.setText("Arithmetic error");
        }       
    }
    public static void main(String[] args) {
        launch(args);
    }
}


