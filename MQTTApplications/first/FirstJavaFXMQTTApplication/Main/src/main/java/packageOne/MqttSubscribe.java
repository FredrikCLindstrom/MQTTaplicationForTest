package packageOne;

import javafx.application.Platform;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
;

public class MqttSubscribe {

    Controller controller;

    public MqttSubscribe(Controller controller) {
        this.controller = controller;
    }

    public void executeMQTTSubscribe() {

        String topicOne        = "messageOne"; //detta är topic som subscribern lyssnar på
        String topicTwo        = "messageTwo"; //detta är topic som subscribern lyssnar på
        String broker       = "tcp://test.mosquitto.org:1883";//detta är brokern, detta är testbroker från eclipse.
        //ni kommer förmodligen behöva sätta upp en egen broker på egen server.
        String clientId     = "client1"; // detta är bara namnet på den som gör publish
        MemoryPersistence persistence = new MemoryPersistence();//håller kvar meddelandet utanför minnet vid issues (googla)

        try {
            MqttClient sampleClient = new MqttClient(broker, clientId, persistence);//bakar in broker, client och persistence i sampleClient
            MqttConnectOptions connOpts = new MqttConnectOptions(); //Holds the set of options that control how the client connects to a server
            connOpts.setCleanSession(true);//true or false, har med minne att göra (googla vad som blir bäst)
            System.out.println("Connecting to broker: "+broker);
            sampleClient.connect(connOpts);//connectar till en mqtt server (brokern)
            System.out.println("Connected");

            MqttCallback callback = new MqttCallback(){ //Enables an application to be notified when asynchronous events related to the client occur.
                // Classes implementing this interface can be registered on both types of client:
                // IMqttClient.setCallback(MqttCallback) and IMqttAsyncClient.setCallback(MqttCallback)

                public void messageArrived(String topic, MqttMessage message) throws Exception {

                        String stringMessage = message.toString();
                        callControllerAndItsMethod(stringMessage, topic);
                }

                public void deliveryComplete(IMqttDeliveryToken token) {
                }

                public void connectionLost(Throwable cause) {
                    cause.printStackTrace();
                }
            };
            sampleClient.subscribe(topicOne);//första knappen
            sampleClient.subscribe(topicTwo);//andra knappen
            sampleClient.setCallback(callback); //Sets the callback listener to use for events that happen asynchronously.
            //There are a number of events that listener will be notified about.


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

        System.out.println(stringMessage + " = this is stringMessage");
        if(topic.equals("messageOne")){
            Platform.runLater(new Runnable(){
                public void run() {
                    controller.changeFirstLabelNumber(stringMessage);

                }
            });

        }else if(topic.equals("messageTwo")){
            Platform.runLater(new Runnable(){
                public void run() {
                    controller.changeSecondLabelNumber(stringMessage);
                }
            });

        }
    }
}
