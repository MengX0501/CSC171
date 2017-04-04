import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Created by robertstjacquesjr on 4/3/17.
 */
public class HBoxEx extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox box = new VBox();

        Button butt1 = new Button("First");
        butt1.setFont(new Font("Helvetica", 72));

        Button butt2 = new Button("Second");
        Button butt3 = new Button("Third");

        Scene scene = new Scene(box);

        primaryStage.setScene(scene);

        primaryStage.show();

        box.getChildren().addAll(butt1, butt2, butt3);

        primaryStage.hide();
        primaryStage.show();
    }


}
