package com.example.towerdefensegameinjfx.game;

import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class StoreController {
    public ImageView normalTowerCover = new ImageView(new Image("file:src/main/java/com/example/towerdefensegameinjfx/game/resources/assets/PNG/Default size/towerDefense_tile249.png"));
    public ImageView normalTower = new ImageView(new Image("file:src/main/java/com/example/towerdefensegameinjfx/game/resources/assets/PNG/Default size/towerDefense_tile249.png"));
    public ImageView machineGunTowerCover = new ImageView(new Image("file:src/main/java/com/example/towerdefensegameinjfx/game/resources/assets/PNG/Default size/towerDefense_tile250.png"));
    public ImageView machineGunTower = new ImageView(new Image("file:src/main/java/com/example/towerdefensegameinjfx/game/resources/assets/PNG/Default size/towerDefense_tile250.png"));
    public ImageView sniperTowerCover = new ImageView(new Image("file:src/main/java/com/example/towerdefensegameinjfx/game/resources/assets/PNG/Default size/towerDefense_tile206.png"));
    public ImageView sniperTower = new ImageView(new Image("file:src/main/java/com/example/towerdefensegameinjfx/game/resources/assets/PNG/Default size/towerDefense_tile206.png"));
    public VBox towers = new VBox(normalTowerCover,normalTower,machineGunTowerCover,machineGunTower,sniperTowerCover,sniperTower);


//    private FXMLLoader fxmlLoader;
//    private AnchorPane storePane;

//    Store(AnchorPane storePane) {
//        this.storePane = storePane;
//    }





    public ImageView getNormalTower() {
        return normalTower;
    }

    public ImageView getMachineGunTower() {
        return machineGunTower;
    }

    public ImageView getSniperTower() {
        return sniperTower;
    }

    @FXML
    private void onMouseEntered() {
        normalTower.setCursor(Cursor.CLOSED_HAND); // wollte extra cursors hinzufugen aber wird noch bei v2 kommen
        machineGunTower.setCursor(Cursor.CLOSED_HAND);
        sniperTower.setCursor(Cursor.CLOSED_HAND);
    }
}
