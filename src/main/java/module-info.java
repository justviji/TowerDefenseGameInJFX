module com.example.towerdefensegameinjfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.towerdefensegameinjfx.game to javafx.fxml;
    exports com.example.towerdefensegameinjfx.game;
}