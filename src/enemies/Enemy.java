package enemies;

import bases.*;

import java.awt.*;
import java.util.ArrayList;

public class Enemy extends GameObject {
    EnemyShoot enemyShoot;





    public Enemy(int x, int y){
        super(x,y);
        ArrayList<Image> images=new ArrayList<>();
        images.add(ImageUtil.load("images/enemy/bacteria/bacteria1.png"));
        images.add(ImageUtil.load("images/enemy/bacteria/bacteria2.png"));
        images.add(ImageUtil.load("images/enemy/bacteria/bacteria3.png"));
       this.renderer = new Animation(images);
       this.boxCollider= new BoxCollider(x,y,50,50);
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
    public void getHit(){
        this.destroy();
    }
}
