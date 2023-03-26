package com.example.towerdefensegameinjfx.game;

import com.example.towerdefensegameinjfx.game.store.Store;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController {
    public AnchorPane menu = new AnchorPane();
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

    


