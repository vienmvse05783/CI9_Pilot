package enemies;

import bases.GameObject;
import bases.ImageRenderer;

import static bases.GameObject.checkCollision;

public class EnemyBullet extends GameObject {


    public EnemyBullet(int x, int y){
       super(x,y);
        this.imageRenderer = new ImageRenderer("images\\bullet\\enemy\\enemy2_bullet1.png");
    }


    public void run(){
        super.run();
        move();
    }
    private void move() {
        this.position.addUp(0,5);
    }
}
