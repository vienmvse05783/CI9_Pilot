package enemies;

import bases.*;

import java.awt.*;
import java.util.ArrayList;

public class Enemy extends GameObject {
    EnemyShoot enemyShoot;


    public Enemy(int x, int y) {
        super(x, y);
        //  ArrayList<Image> images=new ArrayList<>();

        this.renderer = new Animation(
                ImageUtil.load("images/enemy/bacteria/bacteria1.png"),
                ImageUtil.load("images/enemy/bacteria/bacteria2.png"),
                ImageUtil.load("images/enemy/bacteria/bacteria3.png")
        );
        this.boxCollider = new BoxCollider(x, y, 50, 50);
        enemyShoot = new EnemyShoot();
    }


    @Override
    public void run() {
        super.run();
        this.shoot();
        this.position.addUp(0, 3);
        deActiveIfNeeded();
    }
    private void deActiveIfNeeded() {
        if(this.position.y >800){
            this.isActive=false;
        }
    }
    private void shoot() {
        enemyShoot.run(this);

    }

    public void getHit() {
        this.destroy();
        EnemyExplosion explosion = new EnemyExplosion((int) this.position.x,(int) this.position.y);
        GameObject.add(explosion);
    }
}
