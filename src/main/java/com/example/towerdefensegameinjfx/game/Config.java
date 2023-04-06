package com.example.towerdefensegameinjfx.game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public final class Config {


    // one second in nanoseconds
    public static final long SECOND = 1000000000;

    public static final int TILE_SIZE = 64;

    private static final int TILE_HORIZONTAL = 22;

    private static final int TILE_VERTICAL = 15;

    public static final int SCREEN_WIDTH = TILE_SIZE * TILE_HORIZONTAL;

    public static final int SCREEN_HEIGHT = TILE_SIZE * TILE_VERTICAL;

    public static final Image background = new Image(Objects.requireNonNull(Config.class.getResourceAsStream("background.png")));


    public static final  double difficultyMultiplyerNormal = 1;
    public static final  double difficultyMultiplyerHard = 0.75;
    public static final  double difficultyMultiplyerInsane = 0.5;
    public static final  double difficultyMultiplyerImpossible = 0.25;
    public static double chosenDifficultyMultiplyer = difficultyMultiplyerNormal;
    public static final Image NORMAL_BULLET_IMG = new Image(Objects.requireNonNull(Config.class.getResourceAsStream("assets/PNG/Default_size/towerDefense_tile257.png")));
    public static final Image SNIPER_BULLET_IMG = new Image(Objects.requireNonNull(Config.class.getResourceAsStream("assets/PNG/Default_size/towerDefense_tile252.png")));
    public static final Image MACHINE_GUN_BULLET_IMG = new Image(Objects.requireNonNull(Config.class.getResourceAsStream("assets/PNG/Default_size/towerDefense_tile295.png")));

    // normal tower
    public static final Image NORMAL_TOWER_IMG = new Image(Objects.requireNonNull(Config.class.getResourceAsStream("assets/PNG/Default_size/towerDefense_tile249.png")));
    public static final int NORMAL_TOWER_PRICE = 20;
    public static final int NORMAL_TOWER_DAMAGE = 150;
    public static final int NORMAL_TOWER_DELAY_TIME = (int) SECOND;
    public static final int NORMAL_TOWER_RANGE = 275;

    // sniper tower
    public static final Image SNIPER_TOWER_IMG = new Image(Config.class.getResourceAsStream("assets/PNG/Default_size/towerDefense_tile206.png"));
    public static final int SNIPER_TOWER_PRICE = 70;
    public static final int SNIPER_TOWER_DAMAGE = 700;
    public static final int SNIPER_TOWER_DELAY_TIME = (int) (SECOND * 2.5);
    public static final int SNIPER_TOWER_RANGE = 450;

    // machine gun tower
    public static final Image MACHINE_GUN_TOWER_IMG = new Image(Config.class.getResourceAsStream("assets/PNG/Default_size/towerDefense_tile250.png"));
    public static final int MACHINE_GUN_TOWER_PRICE = 50;
    public static final int MACHINE_GUN_TOWER_DAMAGE = 75;
    public static final int MACHINE_GUN_TOWER_DELAY_TIME = (int) (SECOND * 0.2);
    public static final int MACHINE_GUN_TOWER_RANGE = 200;



    // normal enemy
    public static final Image NORMAL_ENEMY_IMG = new Image(Config.class.getResourceAsStream("assets/PNG/Default_size/towerDefense_tile245.png"));
    public static final int NORMAL_ENEMY_SPEED = 100;
    public static final int NORMAL_ENEMY_HEALTH = 300;
    public static final int NORMAL_ENEMY_ARMOR = 10;
    public static final int NORMAL_ENEMY_REWARD = 5;

    // smaller enemy
    public static final Image SMALLER_ENEMY_IMG = new Image(Config.class.getResourceAsStream("assets/PNG/Default_size/towerDefense_tile246.png"));
    public static final int SMALLER_ENEMY_SPEED = 180;
    public static final int SMALLER_ENEMY_HEALTH = 150;
    public static final int SMALLER_ENEMY_ARMOR = 5;
    public static final int SMALLER_ENEMY_REWARD = 3;

    // tanker enemy
    public static final Image TANK_ENEMY_IMG = new Image(Config.class.getResourceAsStream("assets/PNG/Default_size/towerDefense_tile269.png"));
    public static final int TANK_ENEMY_SPEED = 80;
    public static final int TANK_ENEMY_HEALTH = 650;
    public static final int TANK_ENEMY_ARMOR = 40;
    public static final int TANK_ENEMY_REWARD = 15;

    // boss enemy
    public static final Image BOSS_ENEMY_IMG = new Image(Config.class.getResourceAsStream("assets/kenney_topdowntanksredux/PNG/Default_size/tank_bigRed.png"));
    public static final int BOSS_ENEMY_SPEED = 60;
    public static final int BOSS_ENEMY_HEALTH = 1000;
    public static final int BOSS_ENEMY_ARMOR = 100;
    public static final int BOSS_ENEMY_REWARD = 35;


    public static final Image HILL_IMG = new Image(Config.class.getResourceAsStream("assets/PNG/Default_size/towerDefense_tile181.png"));
    //delay time when spawning new enemy in nanosecond
    public static final long SPAWN_DELAY_TIME = (long) (SECOND * 0.5);

    public static final ImageView EXPLOSION1 = new ImageView(Config.class.getResource("assets/kenney_topdowntanksredux/PNG/Default_size/explosion1.png").toString());
    public static final ImageView EXPLOSION2 = new ImageView(Config.class.getResource("assets/kenney_topdowntanksredux/PNG/Default_size/explosion2.png").toString());
    public static final ImageView EXPLOSION3 = new ImageView(Config.class.getResource("assets/kenney_topdowntanksredux/PNG/Default_size/explosion3.png").toString());
    public static final ImageView EXPLOSION4 = new ImageView(Config.class.getResource("assets/kenney_topdowntanksredux/PNG/Default_size/explosion4.png").toString());
    public static final ImageView EXPLOSION5 = new ImageView(Config.class.getResource("assets/kenney_topdowntanksredux/PNG/Default_size/explosion5.png").toString());




    public static final ImageView UPGRADE_BUTTON_IMAGE_VIEW = new ImageView(Config.class.getResource("assets/button/upgrade.png").toString());
    public static final ImageView SELL_BUTTON_IMAGE_VIEW = new ImageView(Config.class.getResource("assets/button/sell.png").toString());
    public static final ImageView CANCEL_BUTTON_IMAGE_VIEW = new ImageView(Config.class.getResource("assets/button/cancel.png").toString());
    public static final ImageView PAUSE_BUTTON_IMAGE_VIEW = new ImageView(Config.class.getResource("assets/button/pause.png").toString());
    public static final String BUTTON_STYLE = "-fx-background-radius: 5em; " + "-fx-min-width: 55px; " + "-fx-min-height: 55px; " + "-fx-max-width: 55px; " + "-fx-max-height: 55px;" + "-fx-background-color: " + "linear-gradient(#f0ff35, #a9ff00)," + "radial-gradient(center 50% -40%, radius 200%, #b8ee36 45%, #80c800 50%);" + " -fx-background-insets: 0, 1;" + " -fx-effect: dropShadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );" + " -fx-text-fill: #395306;";
    public static final String BUTTON_HOVER_STYLE = "-fx-background-radius: 5em; " + "-fx-min-width: 55px; " + "-fx-min-height: 55px; " + "-fx-max-width: 55px; " + "-fx-max-height: 55px;" + "-fx-background-color: " + "linear-gradient(#f0ff35, #81C200)," + "radial-gradient(center 50% -40%, radius 200%, #A0CF2E 45%, #80c800 50%);" + " -fx-background-insets: 0, 1;" + " -fx-effect: dropShadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );" + " -fx-text-fill: #395306;";



    public static final Image NOT_ENOUGH_MONEY = new Image(Config.class.getResourceAsStream("assets/button/sell.png"));


}
