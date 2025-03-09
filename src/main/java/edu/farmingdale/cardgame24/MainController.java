package edu.farmingdale.cardgame24;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import java.util.Timer;
import java.util.TimerTask;


public class MainController {
    private final GameData gameData = new GameData();

    @FXML
    private ImageView card1;

    @FXML
    private ImageView card2;

    @FXML
    private ImageView card3;

    @FXML
    private ImageView card4;

    @FXML
    private HBox cardHbox;

    @FXML
    private TextField expressionTextField;

    @FXML
    private Button hintButton;

    @FXML
    private Button refreshButton;

    @FXML
    private Label titleLabel;

    @FXML
    private Button verifyButton;

    @FXML
    private Label warningLabel;

    @FXML
    void hintAction(ActionEvent event) {
        warningLabel.setText(gameData.getHint(gameData.valueOccurences.keySet()));
    }

    @FXML
    void refreshAction(ActionEvent event) {
        warningLabel.setText("");
        expressionTextField.setText("");
        gameData.generateCards();
        card1.setImage(new Image(getClass().getResourceAsStream("images/" + gameData.cards.get(0))));
        card2.setImage(new Image(getClass().getResourceAsStream("images/" + gameData.cards.get(1))));
        card3.setImage(new Image(getClass().getResourceAsStream("images/" + gameData.cards.get(2))));
        card4.setImage(new Image(getClass().getResourceAsStream("images/" + gameData.cards.get(3))));
    }

    @FXML
    void verifyAction(ActionEvent event) {
        String expression = expressionTextField.getText();

        //if expression contains invalid characters
        if (!gameData.isValidExpression(expression)) {
            warningLabel.setText("Invalid expression!");
        }
        //if user not use each card exactly once
        else if (!gameData.meetsRequirements(expression)) {
            warningLabel.setText("Must only use each card exactly once!");
        }
        //if expression not equivalent to 24
        else if (!gameData.equalsAnswer(expression)) {
            warningLabel.setText("Expression must equal 24!");
        }
        else {
            disableButtons(true);
            warningLabel.setStyle("-fx-text-fill: green;");
            expressionTextField.setStyle("-fx-background-color: #b0ffb0;");
            warningLabel.setText("Correct!");

            Timer timer = new Timer();

            timer.schedule(new TimerTask() {
                public void run() {
                    // Ensure this runs on the JavaFX Application Thread
                    Platform.runLater(() -> {
                        expressionTextField.setStyle("-fx-background-color: white;");
                        warningLabel.setStyle("-fx-text-fill: red;");
                        warningLabel.setText("");
                        refreshAction(new ActionEvent());
                        disableButtons(false);
                        expressionTextField.setText("");
                    });
                    timer.cancel();
                }
            }, 4000);
        }
    }

    void disableButtons(boolean value) {
        hintButton.setDisable(value);
        refreshButton.setDisable(value);
        verifyButton.setDisable(value);
        expressionTextField.setDisable(value);
    }

}
