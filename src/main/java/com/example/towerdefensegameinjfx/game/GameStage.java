package com.example.towerdefensegameinjfx.game;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;

import java.io.IOException;

public class GameStage {
    public static int money;
    public static int health;

    private final GameField gameField;
    private final Group root;
    private final Store store;

    public GameStage(Group root, Canvas canvas, Store store) {
        gameField = new GameField(root, canvas, store);
        this.root = root;
        this.store = store;
        GameStage.money = (int)((double)1000*Config.chosenDifficultyMultiplyer);
        GameStage.health = (int)((double)10*Config.chosenDifficultyMultiplyer);
    }

    private void renderGameField() {
        gameField.renderMap();
    }

    public void start() throws IOException {
        renderGameField();
        store.init();
        gameField.play();

    }
}
