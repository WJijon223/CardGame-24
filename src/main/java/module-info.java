module edu.farmingdale.cardgame24 {
    requires javafx.controls;
    requires javafx.fxml;
    requires exp4j;


    opens edu.farmingdale.cardgame24 to javafx.fxml;
    exports edu.farmingdale.cardgame24;
}