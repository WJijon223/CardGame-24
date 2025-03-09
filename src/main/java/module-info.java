module edu.farmingdale.cardgame24 {
    requires javafx.controls;
    requires javafx.fxml;
    requires exp4j;
    requires org.json;


    opens edu.farmingdale.cardgame24 to javafx.fxml;
    exports edu.farmingdale.cardgame24;
}