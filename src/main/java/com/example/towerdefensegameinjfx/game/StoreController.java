package com.example.towerdefensegameinjfx.game;

import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class StoreController {
    public static ImageView normalTowerCover = new ImageView(String.valueOf(Config.class.getResource("assets/PNG/Default_size/towerDefense_tile249.png")));
    public ImageView normalTower = new ImageView(String.valueOf(Config.class.getResource("assets/PNG/Default_size/towerDefense_tile249.png")));
    public static ImageView machineGunTowerCover = new ImageView(String.valueOf(Config.class.getResource("assets/PNG/Default_size/towerDefense_tile250.png")));
    public ImageView machineGunTower = new ImageView(String.valueOf(Config.class.getResource("assets/PNG/Default_size/towerDefense_tile250.png")));
    public static ImageView sniperTowerCover = new ImageView(String.valueOf(Config.class.getResource("assets/PNG/Default_size/towerDefense_tile206.png")));
    public ImageView sniperTower = new ImageView(String.valueOf(Config.class.getResource("assets/PNG/Default_size/towerDefense_tile206.png")));
    public VBox towers = new VBox(normalTowerCover,normalTower,machineGunTowerCover,machineGunTower,sniperTowerCover,sniperTower);
    public HBox standardTowerHbox;
    public HBox mgTowerHbox;
    public HBox sniperTowerHbox;


//    private FXMLLoader fxmlLoader;
//    private AnchorPane storePane;

//    Store(AnchorPane storePane) {
//        this.storePane = storePane;
//    }
    @FXML
    void initialize(){
        standardTowerHbox.getChildren().add(normalTowerCover);
        mgTowerHbox.getChildren().add(machineGunTowerCover);
        sniperTowerHbox.getChildren().add(sniperTowerCover);
        normalTowerCover.setOnMouseEntered(normalTowerEvent->
                Store.storeStatic.handleDragDropEvent((ImageView) normalTowerEvent.getSource(),GameField.getRoot(),GameField.staticHills,GameField.staticTowers)
        );
        machineGunTowerCover.setOnMouseEntered(mgTowerEvent->
                Store.storeStatic.handleDragDropEvent((ImageView) mgTowerEvent.getSource(),GameField.getRoot(),GameField.staticHills,GameField.staticTowers)
        );
        sniperTowerCover.setOnMouseEntered(sniperTowerEvent->
                Store.storeStatic.handleDragDropEvent((ImageView) sniperTowerEvent.getSource(),GameField.getRoot(),GameField.staticHills,GameField.staticTowers)
        );

    }





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
