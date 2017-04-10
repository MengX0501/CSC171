import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
    public enum Operator {
        MOD,
        ADD,
        SUB,
        DIV,
        MUL
    }

    private static final Font FONT = new Font("Helvetica", 48);

    private TextField result;
    private double operand;
    private Operator operator;
    private boolean clear;

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane grid = new GridPane();

        clear = true;
        ButtonHandler numbers = new ButtonHandler();

        result = new TextField();
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
        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                result.setText("0");
            }
        });
        grid.add( clear, 0, 1);
        grid.add( makeButton("%", new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                operator(Operator.MOD);
            }
        }), 2, 1);
        grid.add( makeButton("/", new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                operator(Operator.DIV);
            }
        }), 3, 1);

        grid.add( makeButton("7", numbers), 0, 2);
        grid.add( makeButton("8", numbers), 1, 2);
        grid.add( makeButton("9", numbers), 2, 2);
        grid.add(makeButton("x", new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                operator(Operator.MUL);
            }
        }), 3, 2);

        grid.add( makeButton("4", numbers), 0, 3);
        grid.add( makeButton("5", numbers), 1, 3);
        grid.add( makeButton("6", numbers), 2, 3);
        grid.add( makeButton("-", new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                operator(Operator.SUB);
            }
        }), 3, 3);

        grid.add( makeButton("1", numbers), 0, 4);
        grid.add( makeButton("2", numbers), 1, 4);
        grid.add( makeButton("3", numbers), 2, 4);
        grid.add( makeButton("+", new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                operator(Operator.ADD);
            }
        }), 3, 4);

        Button zero = makeButton("0", numbers);
        grid.add(zero, 0, 5);
        GridPane.setColumnSpan(zero, 2);
        grid.add(makeButton(".", numbers), 2, 5);
        Button equals = makeButton("=", new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                calculate();
            }
        });
        grid.add( equals, 3, 5);

        Scene scene = new Scene(grid);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Calculon");
        primaryStage.show();
    }

    private void operator(Operator op) {
        operator = op;
        operand = Double.parseDouble(result.getText());
        clear = true;
    }

    private void calculate() {
        double operand2 = Double.parseDouble(result.getText());
        double answer;
        switch(operator) {
            case MOD:
                answer = operand % operand2;
                break;
            case ADD:
                answer = operand + operand2;
                break;
            case SUB:
                answer = operand - operand2;
                break;
            case DIV:
                answer = operand / operand2;
                break;
            case MUL:
                answer = operand * operand2;
                break;
            default:
                answer = 0;
        }

        result.setText(Double.toString(answer));
        clear = true;
    }

    private static Button makeButton(String label) {
        return makeButton(label, null);
    }

    private static Button makeButton(String label, EventHandler<ActionEvent> handler) {
        Button butt = new Button(label);
        butt.setOnAction(handler);
        butt.setFont(FONT);
        butt.setAlignment(Pos.CENTER);
        butt.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        GridPane.setFillWidth(butt, true);
        return butt;
    }

    private class ButtonHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            Button source = (Button)event.getSource();
            String bText = source.getText();

            String text = result.getText();
            if(clear) {
                result.setText(bText);
                clear = false;
            }
            else {
                result.setText(text + bText);
            }
        }
    }
}