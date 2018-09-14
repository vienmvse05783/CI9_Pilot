package enemies;

import bases.*;
import players.Player;

public class EnemyBullet extends GameObject {


    public EnemyBullet(int x, int y){
       super(x,y);
        this.renderer=new Animation(
                ImageUtil.load("images\\bullet\\enemy\\enemy_bullet1.png"),
                ImageUtil.load("images\\bullet\\enemy\\enemy_bullet2.png"),
                ImageUtil.load("images\\bullet\\enemy\\enemy_bullet3.png"),
                ImageUtil.load("images\\bullet\\enemy\\enemy2_bullet1.png"),
                ImageUtil.load("images\\bullet\\enemy\\enemy2_bullet2.png"),
                ImageUtil.load("images\\bullet\\enemy\\enemy2_bullet3.png")

        );
                this.boxCollider= new BoxCollider(x,y,20,30);
    }


    public void run(){
        super.run();
        move();
        hitPlayer();
        deActiveIfNeeded();
    }
    private void deActiveIfNeeded() {
        if(this.position.y >800){
            this.isActive=false;
        }
    }
    private void hitPlayer() {
        Player player = checkCollision(this.boxCollider,Player.class);
        if(player !=null){
            System.out.println("Hit Player");
            player.getHit();
            this.destroy();
        }
    }
    private void move() {
        this.position.addUp(0,10);
    }
}
