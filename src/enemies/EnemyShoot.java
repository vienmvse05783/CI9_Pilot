package enemies;

import bases.FrameCounter;
import bases.GameObject;

public class EnemyShoot {
    boolean shootLock = false;//shoot
    FrameCounter frameCounter = new FrameCounter(350);

    void run(Enemy enemy) {
        if ( !this.shootLock) {
            EnemyBullet newBullet= GameObject.recycle((int) enemy.position.x, (int) enemy.position.y,EnemyBullet.class);
//            if(newBullet==null){
//                newBullet = new EnemyBullet((int) enemy.position.x, (int) enemy.position.y);
//                GameObject.add(newBullet);
//            }else {
//                newBullet.isActive=true;
//                newBullet.position.x=enemy.position.x;
//                newBullet.position.y=enemy.position.y;
//
//            }

            this.shootLock = true;
        }

        if (shootLock) {
            frameCounter.run();
            if (frameCounter.expired) {
                shootLock = false;
                frameCounter.reset();
            }
        }
    }


}
