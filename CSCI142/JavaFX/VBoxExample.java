import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Created by robertstjacquesjr on 4/3/17.
 */
public class VBoxExample extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox box = new VBox();

        Button butt1 = new Button("Top");
        Button butt2 = new Button("Top Center");
        Button butt3 = new Button("Bottom Center");
        butt3.setFont(new Font("Papyrus", 48));
        Button butt4 = new Button("Bottom");

        box.getChildren().addAll(butt1, butt2, butt3, butt4);

        Scene scene = new Scene(box);

        primaryStage.setScene(scene);
        primaryStage.setTitle("VBox Demo");
        primaryStage.show();
    }
}
