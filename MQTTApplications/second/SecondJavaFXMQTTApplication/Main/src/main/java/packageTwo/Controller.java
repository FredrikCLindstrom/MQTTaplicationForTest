package packageTwo;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Controller {
    

    @FXML Button plusOneFirstButton, plusOneSecondButton;
    @FXML Label label1, labelFirstNumber, labelSecondNumber;
    @FXML

    int count1=0;
    String count1String;
    int count2=0;
    String count2String;


    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }


    public  void firstPlusMethod(){
        count1++;
        String topic = "first";
        count1String=String.valueOf(count1);
        labelFirstNumber.setText(count1String);
        sendMQTTData.sendDataToFirstApp(count1String, topic);
    }

    public  void secondPlusMethod(){
        count2++;
        String topic = "second";
        count2String=String.valueOf(count2);
        labelSecondNumber.setText(count2String);
        sendMQTTData.sendDataToFirstApp(count2String, topic);
    }
  
}