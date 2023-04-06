package com.example.towerdefensegameinjfx.game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

public class MainMenuController {
    public static AnchorPane menu = new AnchorPane();
    public AnchorPane asdf;
    public Label currentlyChosen;
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

    @FXML
    void initialize(){
        asdf.setBackground(new Background(new BackgroundImage(Config.background, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
    }

    public void normalBtn(ActionEvent actionEvent) {
        Config.chosenDifficultyMultiplyer = Config.difficultyMultiplyerNormal;
        currentlyChosen.setText("normal");
    }

    public void hardBtn(ActionEvent actionEvent) {
        Config.chosenDifficultyMultiplyer = Config.difficultyMultiplyerHard;
        currentlyChosen.setText("hard");
    }

    public void insaneBtn(ActionEvent actionEvent) {
        Config.chosenDifficultyMultiplyer = Config.difficultyMultiplyerInsane;
        currentlyChosen.setText("insane");
    }

    public void impossibleBtn(ActionEvent actionEvent) {
        Config.chosenDifficultyMultiplyer = Config.difficultyMultiplyerImpossible;
        currentlyChosen.setText("impossible");
    }
}

    


