package packageOne;

import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class Controller {

    @FXML Label label1, labelSecondNumber;
    @FXML Label labelFirstNumber;

    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    public void changeFirstLabelNumber(String message){labelFirstNumber.setText(message);}
    public void changeSecondLabelNumber(String message){
        labelSecondNumber.setText(message);
    }

}