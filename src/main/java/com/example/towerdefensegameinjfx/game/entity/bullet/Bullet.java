package com.example.towerdefensegameinjfx.game.entity.bullet;

import com.example.towerdefensegameinjfx.game.entity.GameEntity;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public final class Bullet extends GameEntity {
    public Bullet(Image image, double angle) {
        this.image = image;
        this.imageView = new ImageView(this.image);
        this.imageView.setRotate(angle);
        initImgViewPos();
    }
}