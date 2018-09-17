package enemies;

import bases.FrameCounter;
import bases.GameObject;

import java.util.ArrayList;
import java.util.Random;

public class EnemySpawn extends GameObject {
    Random random;
    public ArrayList<Enemy> enemies;
    FrameCounter frameCounter = new FrameCounter(150);
    public EnemySpawn(){
        super(0,0);
        enemies = new ArrayList<>();
        random = new Random();
    }

    public void run(){
        frameCounter.run();
        if (frameCounter.expired){
            int posX = random.nextInt(600);
          Enemy enemy=GameObject.recycle(posX,0,Enemy.class);
//            Enemy enemy=GameObject.recycle(Enemy.class);
//            if(enemy==null){
//                enemy = new Enemy(posX, 0);
//                GameObject.add(enemy);
//            }else {
//                enemy.isActive=true;
//                enemy.position.x=posX;
//                enemy.position.y=0;
//
//            }

            frameCounter.reset();
        }
    }
}
