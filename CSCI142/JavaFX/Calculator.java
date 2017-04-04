import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Created by robertstjacquesjr on 4/3/17.
 */
public class Calculator extends Application {
    private static final Font FONT = new Font("Helvetica", 48);

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane grid = new GridPane();

        TextField result = new TextField();
        result.setAlignment(Pos.CENTER_RIGHT);
        result.setFont(FONT);
        result.setText("0");
        result.setPrefWidth(80);
        result.setEditable(false);
        result.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        GridPane.setColumnSpan(result, 4);
        grid.add(result, 0, 0);

        Button clear = makeButton("AC");
        GridPane.setColumnSpan(clear, 2);
        grid.add( clear, 0, 1);
        grid.add( makeButton("%"), 2, 1);
        grid.add( makeButton("/"), 3, 1);

        grid.add( makeButton("7"), 0, 2);
        grid.add( makeButton("8"), 1, 2);
        grid.add( makeButton("9"), 2, 2);
        grid.add(makeButton("x"), 3, 2);

        grid.add( makeButton("4"), 0, 3);
        grid.add( makeButton("5"), 1, 3);
        grid.add( makeButton("6"), 2, 3);
        grid.add( makeButton("-"), 3, 3);

        grid.add( makeButton("1"), 0, 4);
        grid.add( makeButton("2"), 1, 4);
        grid.add( makeButton("3"), 2, 4);
        grid.add( makeButton("+"), 3, 4);

        Button zero = makeButton("0");
        grid.add(zero, 0, 5);
        GridPane.setColumnSpan(zero, 2);
        grid.add(makeButton("."), 2, 5);
        grid.add( makeButton("="), 3, 5);

        Scene scene = new Scene(grid);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Calculon");
        primaryStage.show();
    }

    private static Button makeButton(String label) {
        Button butt = new Button(label);
        butt.setFont(FONT);
        butt.setAlignment(Pos.CENTER);
        butt.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        GridPane.setFillWidth(butt, true);
        return butt;
    }
}
