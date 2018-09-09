package players;

import bases.BoxCollider;
import bases.GameObject;
import bases.ImageRenderer;
import enemies.Enemy;

public class PlayerBullet extends GameObject {
    public PlayerBullet(int x, int y){
      super(x,y);
      this.imageRenderer=new ImageRenderer("images/bullet/player/mb69bullet1.png");
      this.boxCollider= new BoxCollider(x,y,20,30);
    }

    @Override
    public void run() {
        super.run();
        hitEnemies();
        this.position.addUp(0,-10);
    }
    private void hitEnemies() {
        Enemy enemy = checkCollisionEnemy(this.boxCollider);
        if(enemy !=null){
            System.out.println("Hit");
            enemy.getHit();
            this.destroy();
        }
    }
}

