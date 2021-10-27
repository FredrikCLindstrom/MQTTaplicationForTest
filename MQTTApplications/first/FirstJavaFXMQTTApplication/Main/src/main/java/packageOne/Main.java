
package packageOne;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;


public class Main extends Application{

    private Stage primaryStage;
    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage=primaryStage;
       
        mainWindow();
    }
    public void mainWindow() throws IOException {
        FXMLLoader loader=new FXMLLoader(Main.class.getResource("/sampleOne.fxml"));
        AnchorPane pane = loader.load();
        Controller controller = loader.getController();
        controller.setMain(this);
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("subscriber");

        primaryStage.show();                          //hela denna klass är #BasicJavaFx
        controller.changeFirstLabelNumber("0");
        controller.changeSecondLabelNumber("0");
        final MqttSubscribe Ms = new MqttSubscribe(controller);
        Ms.executeMQTTSubscribe();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
