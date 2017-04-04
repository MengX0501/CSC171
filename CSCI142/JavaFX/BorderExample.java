import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Created by robertstjacquesjr on 4/3/17.
 */
public class BorderExample extends Application {
    private static final Font FONT = new Font("Helvetica", 48);

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane border = new BorderPane();

        border.setLeft(makeLabel("Left"));
        border.setTop(makeLabel("Top"));
        border.setBottom(makeLabel("Bottom"));
        border.setCenter(makeLabel("Center"));
        border.setRight(makeLabel("Right"));

        Scene scene = new Scene(border);
        primaryStage.setScene(scene);
        primaryStage.setTitle("BorderPane Example");
        primaryStage.show();
    }

    private static Label makeLabel(String text) {
        Label label = new Label(text);
        label.setAlignment(Pos.CENTER);
        label.setFont(FONT);
        return label;
    }
}
