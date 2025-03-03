package edu.farmingdale.cardgame24;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class MainController {
    private GameData gameData = new GameData();

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
    private Button findSolutionButton;

    @FXML
    private Button refreshButton;

    @FXML
    private Label solutionLabel;

    @FXML
    private Button verifyButton;

    @FXML
    private Label warningLabel;

    @FXML
    void findSolutionAction(ActionEvent event) {

    }

    @FXML
    void refreshAction(ActionEvent event) {
        warningLabel.setText("");
        gameData.generateCards();
        card1.setImage(new Image(getClass().getResourceAsStream("images/" + gameData.cards.get(0))));
        card2.setImage(new Image(getClass().getResourceAsStream("images/" + gameData.cards.get(1))));
        card3.setImage(new Image(getClass().getResourceAsStream("images/" + gameData.cards.get(2))));
        card4.setImage(new Image(getClass().getResourceAsStream("images/" + gameData.cards.get(3))));
    }

    @FXML
    void verifyAction(ActionEvent event) {

    }

}
