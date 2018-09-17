package players;

import bases.FrameCounter;
import bases.GameObject;
import bases.Vector2D;
import inputs.InputManager;

public class PLayerShoot {
    private boolean shootLock = false;//shoot
    FrameCounter frameCounter = new FrameCounter(50);

    void run(Player player) {
        if (InputManager.instance.xPressed && !this.shootLock) {
            // 1. try to recycle
            Vector2D bulletposition= player.position.subtract(0, 30);
            PlayerBullet newBullet = GameObject.recycle((int)bulletposition.x, (int) bulletposition.y,PlayerBullet.class);
            // 2. if recycle fail, create new.
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
