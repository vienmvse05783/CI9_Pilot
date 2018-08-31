package Enemies;

import Bases.GameObject;
import Bases.ImageRenderer;
import Bases.ImageUtil;
import Bases.Vector2D;

import java.awt.*;

public class EnemyBullet extends GameObject {


    public EnemyBullet(int x, int y){
       super(x,y);
        this.imageRenderer = new ImageRenderer("images\\bullet\\enemy\\enemy2_bullet1.png");
    }


    public void run(){
        super.run();
        this.position.addUp(0,5);
    }
}
