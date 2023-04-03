package com.example.towerdefensegameinjfx.game;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;

public class MainMenuController {
    public static AnchorPane menu = new AnchorPane();
    public AnchorPane asdf;
    @FXML
    private Button playBtn = new Button();

    @FXML
    private Button exitBtn = new Button();

    @FXML
    private AnchorPane store = new AnchorPane();

    @FXML
    public AnchorPane getStore() {
        return store;
    }
    @FXML
    public Button getPlayBtn() {
        return playBtn;
    }
    @FXML
    public Button getExitBtn() {
        return exitBtn;
    }
}

    


