package packageOne;

import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Controller {
    

    @FXML Label label1, labelSecondNumber;

    public Label getLabelFirstNumber() {
        return labelFirstNumber;
    }

    public void setLabelFirstNumber(Label labelFirstNumber) {
        this.labelFirstNumber = labelFirstNumber;
    }

    @FXML Label labelFirstNumber;

    int count=0;

    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }



    public void changeFirstLabelNumber(String message){labelFirstNumber.setText(message);}
    public void changeSecondLabelNumber(String message){
        labelSecondNumber.setText(message);
    }

  
}