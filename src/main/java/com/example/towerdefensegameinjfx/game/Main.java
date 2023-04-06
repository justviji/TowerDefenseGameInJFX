package com.example.towerdefensegameinjfx.game;

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
    private static FXMLLoader fxmlLoader;
    private static AnchorPane mainPane;
    public static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Main.primaryStage = primaryStage;



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
    private static void closeGame() {
        primaryStage.close();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void initMainMenu() throws IOException {
        fxmlLoader = new FXMLLoader(Main.class.getResource("main.fxml"));
        mainPane = fxmlLoader.load();
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

    private static void startGame() throws IOException {

        Group root = new Group();
        mainPane.getChildren().setAll(root);
        //Create canvas
        Canvas canvas = new Canvas();
        canvas.setHeight(Config.SCREEN_HEIGHT);
        canvas.setWidth(Config.SCREEN_WIDTH);
        //Canvas canvas = new Canvas(Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT);

        root.getChildren().add(canvas);


        Store store = new Store(mainPane, fxmlLoader.getController());

        new GameStage(root, canvas, store).start();
    }


}