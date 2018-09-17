package players;

import bases.*;
import enemies.Enemy;

import java.awt.*;

public class PlayerBullet extends GameObject {
    public PlayerBullet(){
        this(0,0);
    }
    public PlayerBullet(int x, int y){
      super(x,y);
      this.renderer=new Animation(
              ImageUtil.load("images/bullet/player/mb69bullet1.png"),
              ImageUtil.load("images/bullet/player/mb69bullet2.png"),
              ImageUtil.load("images/bullet/player/mb69bullet3.png"),
              ImageUtil.load("images/bullet/player/mb69bullet4.png")

      );
      this.boxCollider= new BoxCollider(x,y,20,30);
    }

    @Override
    public void run() {
        super.run();
        hitEnemies();
        deActiveIfNeeded();
        this.position.addUp(0,-10);
    }

    private void deActiveIfNeeded() {
        if(this.position.y <0){
            this.isActive=false;
        }
    }

    private void hitEnemies() {
        Enemy enemy = checkCollision(this.boxCollider, Enemy.class);
        if(enemy !=null){
            System.out.println("Hit");
            enemy.getHit();
            this.destroy();
        }
    }
}

