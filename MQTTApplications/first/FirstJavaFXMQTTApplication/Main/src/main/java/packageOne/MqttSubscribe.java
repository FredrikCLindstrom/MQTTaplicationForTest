package packageOne;

import javafx.application.Platform;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MqttSubscribe {
    @FXML Label labelOne;
    Controller controller;
    public String messageString;

    public MqttSubscribe(Controller controller) {
        this.controller = controller;
    }

    public void test() {

        String topic        = "first";
        String broker       = "tcp://test.mosquitto.org:1883";
        String clientId     = "client1";
        MemoryPersistence persistence = new MemoryPersistence();

        try {
            MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            System.out.println("Connecting to broker: "+broker);
            sampleClient.connect(connOpts);
            System.out.println("Connected");

            MqttCallback callback = new MqttCallback(){

                public void messageArrived(String topic, MqttMessage message) throws Exception {

                        System.out.println(message);
                        String stringMessage = message.toString();
                        callControllerAndItsMethod(stringMessage, topic);
                }

                public void deliveryComplete(IMqttDeliveryToken token) {
                }

                public void connectionLost(Throwable cause) {
                    cause.printStackTrace();
                }
            };
            sampleClient.subscribe(topic);
            sampleClient.subscribe("second");
            sampleClient.setCallback(callback);

            //sampleClient.disconnect();

        } catch(MqttException me) {
            System.out.println("reason "+me.getReasonCode());
            System.out.println("msg "+me.getMessage());
            System.out.println("loc "+me.getLocalizedMessage());
            System.out.println("cause "+me.getCause());
            System.out.println("excep "+me);
            me.printStackTrace();
        }
    }
    public void callControllerAndItsMethod(final String stringMessage, String topic){

        System.out.println(stringMessage + " = this is messageString");
        if(topic.equals("first")){
            Platform.runLater(new Runnable(){
                public void run() {
                    controller.changeFirstLabelNumber(stringMessage);

                }
            });

        }else if(topic.equals("second")){
            Platform.runLater(new Runnable(){
                public void run() {
                    controller.changeSecondLabelNumber(stringMessage);
                }
            });

        }

    }




    public String getMessageString() {
        return messageString;
    }



}
