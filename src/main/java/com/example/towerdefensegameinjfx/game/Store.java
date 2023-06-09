package com.example.towerdefensegameinjfx.game;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Store {
    private AnchorPane mainPane;
    private MainMenuController mainMenuController;
    private final FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("store.fxml"));;

    private ImageView normalTower = StoreController.normalTowerCover;
    private ImageView machineGunTower = StoreController.machineGunTowerCover;
    private ImageView sniperTower = StoreController.sniperTowerCover;
    private boolean isChosen = false;
    public static Store storeStatic;
    boolean wasMouseReleased =true;

    private final HashMap<ImageView, Integer> radius = new HashMap<>(); // hash map for fast comparisons

    public Store(AnchorPane mainPane, MainMenuController mainMenuController) {
        this.mainPane = mainPane;
        this.mainMenuController = mainMenuController;;
    }

    public AnchorPane getMainPane() {
        return mainPane;
    }

    public void setMainPane(AnchorPane mainPane) {
        this.mainPane = mainPane;
    }

    public void init() throws IOException {
        AnchorPane store = mainMenuController.getStore();
        store.setVisible(true);
        store.toFront();
        mainPane.getChildren().add(store);
        // render
        Parent root = fxmlLoader.load();
        store.getChildren().add(root);

        normalTower = StoreController.normalTowerCover;
        machineGunTower = StoreController.machineGunTowerCover;
        sniperTower = StoreController.sniperTowerCover;
        // add to hash map
        radius.put(normalTower, Config.NORMAL_TOWER_RANGE);
        radius.put(machineGunTower, Config.MACHINE_GUN_TOWER_RANGE);
        radius.put(sniperTower, Config.SNIPER_TOWER_RANGE);
        storeStatic = this;
    }

    public void disable() {
        mainMenuController.getStore().setVisible(false);
        mainMenuController.getStore().getChildren().clear();
    }

    public void handleMouseEvent(Group root, List<Hill> hills, List<Tower> towers) {


        EventHandler<MouseEvent> mousePressed = event -> {
            handleDragDropEvent((ImageView) event.getSource(), root, hills, towers);
        };

        normalTower.setOnMousePressed(mousePressed);
        machineGunTower.setOnMousePressed(mousePressed);
        sniperTower.setOnMousePressed(mousePressed);

    }

    public void handleDragDropEvent(ImageView source, Group root, List<Hill> hills, List<Tower> towers) {
        //System.out.println("handle drag drop event");
        Circle tempCircle = new Circle(-1000, -1000, radius.get(source));
        tempCircle.setStroke(Color.FORESTGREEN);
        tempCircle.setFill(Color.rgb(0, 0, 0, 0.05));
        root.getChildren().add(tempCircle);
        EventHandler<MouseEvent> mouseDragged = event -> {
            source.setVisible(false);

            source.setTranslateX(event.getSceneX() - 32 - (mainPane.getWidth() - mainMenuController.getStore().getWidth()));
            source.setTranslateY(event.getSceneY() - 32 - source.getLayoutY());

            tempCircle.setCenterX(event.getSceneX());
            tempCircle.setCenterY(event.getSceneY());

            AtomicBoolean hovering = new AtomicBoolean(false);
            // if mouse hovering on a hill then change cursor type
            if (normalTower.equals(source)) {
                source.setCursor(new ImageCursor(StoreController.normalTower.getImage()));
            } else if (machineGunTower.equals(source)) {
                source.setCursor(new ImageCursor(StoreController.machineGunTower.getImage()));
            } else if (sniperTower.equals(source)) {
                source.setCursor(new ImageCursor(StoreController.sniperTower.getImage()));
            }
            hills.forEach(hill -> {
                if (hill.isUsable(event.getSceneX(), event.getSceneY())) {
                    //source.setCursor(Cursor.CROSSHAIR);
                    hovering.set(true);
                    if (normalTower.equals(source)) {
                        if (GameStage.money < Config.NORMAL_TOWER_PRICE)
                            source.setCursor(new ImageCursor(Config.NOT_ENOUGH_MONEY));
                    } else if (machineGunTower.equals(source)) {
                        if (GameStage.money < Config.MACHINE_GUN_TOWER_PRICE)
                            source.setCursor(new ImageCursor(Config.NOT_ENOUGH_MONEY));
                    } else if (sniperTower.equals(source)) {
                        if (GameStage.money < Config.SNIPER_TOWER_PRICE)
                            source.setCursor(new ImageCursor(Config.NOT_ENOUGH_MONEY));
                    }
                }
            });

            root.getChildren().remove(tempCircle);
        };
        // will definetly continue the game so well if I add a new tower --->>> fix some things here (else{bugs=true})
        EventHandler<MouseEvent> mouseReleased = event -> {
            source.setVisible(true);
//            resetPosition();
            source.setTranslateX(0);
            source.setTranslateY(0);

            root.getChildren().remove(tempCircle);
            hills.forEach(hill -> {
                if (hill.isUsable(event.getSceneX(), event.getSceneY())) {
                    Tower tower;
//
                    if (normalTower.equals(source)) {
                        tower = new NormalTower();
                    } else if (machineGunTower.equals(source)) {
                        tower = new MachineGunTower();
                    } else /*if (sniperTower.equals(source))*/ { //if i add new tower again ignore
                        tower = new SniperTower();
                    }
                    tower.setHill(hill);

                    if (GameStage.money >= tower.getPrice()) {
                        tower.setPosition(hill.getX(), hill.getY());
                        towers.add(tower);
                        hill.setUsed(true);

                        root.getChildren().addAll(tower.getImageView());
                        tower.getImageView().toFront();
                        handleUpgradeOptions(root, tower, towers);

                        GameStage.money -= tower.getPrice();
                    } else System.out.println("Not enough money you poor man/woman/nb person(dass die sprochler happy sein)");
                }
            });
        };
        source.setOnMouseDragged(mouseDragged);
        source.setOnMouseReleased(mouseReleased);
    }

    private void handleUpgradeOptions(Group root, Tower t, List<Tower> towers) {

        t.getImageView().setOnMousePressed(e -> {
            // Check if another tower is being chosen
            if (!isChosen) {
                // Set current state, a tower is being chosen
                isChosen = true;

                // Create tower range circle
                Circle circle = new Circle(t.getX(), t.getY(), t.getRange());
                circle.setStroke(Color.AQUA);
                circle.setFill(Color.rgb(0, 0, 0, 0.07));

                // Create 3 button when click
                Button upgrade = new Button("", Config.UPGRADE_BUTTON_IMAGE_VIEW);
                upgrade.setOnMouseEntered(ev -> upgrade.setStyle(Config.BUTTON_HOVER_STYLE));
                upgrade.setOnMouseExited(ev -> upgrade.setStyle(Config.BUTTON_STYLE));
                upgrade.setStyle(Config.BUTTON_STYLE);
                upgrade.setTranslateX(t.getX() - 75);
                upgrade.setTranslateY(t.getY() - 75);

                Button sell = new Button("", Config.SELL_BUTTON_IMAGE_VIEW);
                sell.setOnMouseEntered(ev -> sell.setStyle(Config.BUTTON_HOVER_STYLE));
                sell.setOnMouseExited(ev -> sell.setStyle(Config.BUTTON_STYLE));
                sell.setStyle(Config.BUTTON_STYLE);
                sell.setTranslateX(t.getX() + 15);
                sell.setTranslateY(t.getY() - 75);

                Button cancel = new Button("", Config.CANCEL_BUTTON_IMAGE_VIEW);
                cancel.setOnMouseEntered(ev -> cancel.setStyle(Config.BUTTON_HOVER_STYLE));
                cancel.setOnMouseExited(ev -> cancel.setStyle(Config.BUTTON_STYLE));
                cancel.setStyle(Config.BUTTON_STYLE);
                cancel.setTranslateX(t.getX() - 28);
                cancel.setTranslateY(t.getY() + 30);

                // Text show how much money needed for upgrade
                Text upgradeMoney = new Text(40, 40, "-" + t.getPrice());
                upgradeMoney.setFont(Font.font("Helvetica", FontWeight.BOLD, 17));
                upgradeMoney.setFill(Color.YELLOW);
                upgradeMoney.setStroke(Color.BLACK);

                // Text show how much money you get when selling
                Text sellMoney = new Text(40, 40, "+" + t.getPrice() / 2);
                sellMoney.setFont(Font.font("Helvetica", FontWeight.BOLD, 17));
                sellMoney.setFill(Color.YELLOW);
                sellMoney.setStroke(Color.BLACK);

                // Text show how much damage your tower has
                Text towerDamage = new Text(35, 0, "Damage: " + t.getDamage());
                towerDamage.setFont(Font.font("Helvetica", FontWeight.BOLD, 14));
                towerDamage.setFill(Color.RED);
                towerDamage.setStroke(Color.BLACK);

                // Set money text next to the button, damage text on top
                upgradeMoney.setTranslateX(upgrade.getTranslateX());
                upgradeMoney.setTranslateY(upgrade.getTranslateY());
                towerDamage.setTranslateX(upgrade.getTranslateX());
                towerDamage.setTranslateY(upgrade.getTranslateY());
                sellMoney.setTranslateX(sell.getTranslateX());
                sellMoney.setTranslateY(sell.getTranslateY());

                root.getChildren().addAll(circle, upgrade, sell, cancel, upgradeMoney, sellMoney, towerDamage);

                if (t.getLevel() == 4) upgradeMoney.setText("Max");
                //When user click on upgrade button
                upgrade.setOnMouseClicked(eventUpgrade -> {
                    if (GameStage.money >= t.getPrice() && t.getLevel() < 4) {

                        // Increase money each time tower level up
                        GameStage.money -= t.getPrice();

                        // Upgrade tower
                        t.upgrade();

                        upgradeMoney.setText("-" + t.getPrice());

                        // Update information for user
                        if (t.getLevel() == 3) upgradeMoney.setText("Max");
                        sellMoney.setText("+" + t.getPrice() / 2);
                        towerDamage.setText("Damage: " + t.getDamage());
                        circle.setRadius(t.getRange());


                        // Add star for each upgrade
                        ImageView star = new ImageView(String.valueOf(this.getClass().getResource("assets/star.png")));
                        t.stars.add(star);
                        star.setX(t.getX() - 30 + t.getLevel() * 15);
                        star.setY(t.getY() + 15);
                        root.getChildren().add(star);

                        // Make sure star don't stay in front of cancel button or tower
                        cancel.toFront();
                        t.getImageView().toFront();

                        t.setLevel(t.getLevel() + 1);
                    }
                });

                //When user clicks on sell button
                sell.setOnMouseClicked(eventSell -> {
                    root.getChildren().removeAll(t.getImageView(), circle, upgrade, sell, cancel);
                    root.getChildren().removeAll(upgradeMoney, sellMoney, towerDamage);
                    towers.remove(t);
                    GameStage.money += t.getPrice() / 2;
                    isChosen = false;
                    t.getHill().setUsed(false);
                    t.stars.forEach(star -> root.getChildren().remove(star));
                });

                // When user click on cancel button
                cancel.setOnMouseClicked(eventCancel -> {
                    root.getChildren().removeAll(circle, upgrade, sell, cancel, upgradeMoney, sellMoney, towerDamage);
                    isChosen = false;
                });
                t.getImageView().toFront();
            }
        });

    }

    public Node getRoot() {
        return this.getRoot();
    }
}
