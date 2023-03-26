package com.example.towerdefensegameinjfx.game;

import com.example.towerdefensegameinjfx.game.store.*;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;

import java.io.IOException;

public class GameStage {
    public static int money;
    public static int health;

    private final GameField gameField;
    private final Group root;
    private final com.example.towerdefensegameinjfx.game.store.Store store;

    public GameStage(Group root, Canvas canvas, com.example.towerdefensegameinjfx.game.store.Store store) {
        gameField = new GameField(root, canvas, store);
        this.root = root;
        this.store = store;
        GameStage.money = 1000;
        GameStage.health = 10;
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