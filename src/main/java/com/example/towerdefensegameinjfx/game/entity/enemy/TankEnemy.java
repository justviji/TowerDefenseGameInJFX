package com.example.towerdefensegameinjfx.game.entity.enemy;

import com.example.towerdefensegameinjfx.game.Config;
import com.example.towerdefensegameinjfx.game.GameField;
import javafx.animation.Interpolator;
import javafx.animation.SequentialTransition;
import javafx.scene.image.ImageView;

public class TankEnemy extends Enemy {
    public TankEnemy() {
        super(Config.TANK_ENEMY_SPEED, Config.TANK_ENEMY_HEALTH, Config.TANK_ENEMY_ARMOR, Config.TANK_ENEMY_REWARD);
        try {
            this.image = Config.TANK_ENEMY_IMG;
            this.imageView = new ImageView(image);
            this.transition = new SequentialTransition(imageView, createTransition(imageView, getSpeed()));
            this.transition.setInterpolator(Interpolator.LINEAR);

            initImgViewPos();
        } catch (Exception e) {
            System.out.println("Error Loading TANK Enemy Image:" + e.getMessage());
        }
    }
}
