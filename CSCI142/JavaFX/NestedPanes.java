import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


/**
 * Created by robertstjacquesjr on 4/3/17.
 */
public class NestedPanes extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane parent = new BorderPane();

        parent.setTop(new Button("Top"));

        BorderPane center = new BorderPane();
        center.setCenter(new Label("Center Center"));
        center.setPrefSize(400, 400);
        center.setBottom(new Label("Center Bottom"));
        parent.setCenter(center);
        parent.setBottom(new Button("Bottom"));

        Scene scene = new Scene(parent);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
