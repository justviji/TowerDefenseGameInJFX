package com.example.towerdefensegameinjfx.game;

import com.example.towerdefensegameinjfx.game.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

//graphics not done by me btw check kenney_topdowntankredux
public class Main extends Application {
    private FXMLLoader fxmlLoader;
    private AnchorPane mainPane;
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        fxmlLoader = new FXMLLoader(Main.class.getResource("main.fxml"));
        mainPane = fxmlLoader.load();


        initMainMenu();

        primaryStage.setOnCloseRequest(event -> {
            event.consume(); //interesting function I found in the internet
            closeGame();
        });

        Scene theScene = new Scene(mainPane);

        primaryStage.setTitle("Tower defense game");
        primaryStage.setScene(theScene);
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();
        primaryStage.show();
    }
    private void closeGame() {
        primaryStage.close();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void initMainMenu() {
        // get main menu controller
        MainMenuController mainMenuController = fxmlLoader.getController();
        Button playBtn = mainMenuController.getPlayBtn();
        Button exitBtn = mainMenuController.getExitBtn();


        playBtn.setOnAction(event -> {
            try {
                startGame();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        exitBtn.setOnAction(event -> closeGame());
    }

    private void startGame() throws IOException {
        Group root = new Group();
        mainPane.getChildren().add(root);
        //Create canvas
        Canvas canvas = new Canvas(Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT);

        root.getChildren().addAll(canvas);

        Store store = new Store(mainPane, fxmlLoader.getController());
        new GameStage(root, canvas, store).start();
    }


}