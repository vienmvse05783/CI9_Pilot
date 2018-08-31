package Enemies;

import Bases.GameObject;
import Bases.ImageRenderer;
import Bases.ImageUtil;
import Bases.Vector2D;

import java.awt.*;
import java.util.ArrayList;

public class Enemy extends GameObject {
    EnemyShoot enemyShoot;




    public Enemy(int x, int y){
        super(x,y);
       this.imageRenderer = new ImageRenderer("images/enemy/bacteria/bacteria1.png");
       enemyShoot =new EnemyShoot();
    }



    @Override
    public void run() {
        super.run();
        this.shoot();
        this.position.addUp(0,3);

    }

    private void shoot() {
    enemyShoot.run(this);

    }
}
