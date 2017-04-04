import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Created by robertstjacquesjr on 4/3/17.
 */
public class LabelDemo extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Label label = new Label("Chris is a nice fellow");
        label.setFont(new Font("Courier New", 72));
        label.setPadding(new Insets(20));

        Scene scene = new Scene(label);

        primaryStage.setScene(scene);
        primaryStage.setTitle("The Title");
        primaryStage.sizeToScene();
        primaryStage.show();

    }
}
