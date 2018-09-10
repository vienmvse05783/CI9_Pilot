package players;

import bases.FrameCounter;
import bases.GameObject;
import inputs.InputManager;

public class PLayerShoot {
    private boolean shootLock = false;//shoot
    FrameCounter frameCounter =  new FrameCounter(50);

    void run(Player player){
        if(InputManager.instance.xPressed && !this.shootLock){
//            Vector2D bulletPosition = player.position.subtract(0,0);
            // 1. try to recycle
            PlayerBullet newBullet= GameObject.recycle();
            if(newBullet== null){
                newBullet = new PlayerBullet((int)player.position.x ,(int)player.position.y);
            }else {
                newBullet.isActive=true;
                newBullet.position.x = player.position.x;
                newBullet.position.y = player.position.y;

            }
            // 2. if recycle fail, create new.

            GameObject.add(newBullet);
            this.shootLock = true;
        }

    }

}
