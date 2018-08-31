package Enemies;

import Bases.FrameCounter;
import Bases.GameObject;
import Inputs.InputManager;

public class EnemyShoot {
    boolean shootLock = false;//shoot
    FrameCounter frameCounter = new FrameCounter(50);

    void run(Enemy enemy) {
        if ( !this.shootLock) {
            EnemyBullet newBullet = new EnemyBullet((int) enemy.position.x, (int) enemy.position.y);
            GameObject.add(newBullet);
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
