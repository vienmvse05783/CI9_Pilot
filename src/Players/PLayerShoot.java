package Players;

import Bases.FrameCounter;
import Bases.GameObject;
import Inputs.InputManager;

public class PLayerShoot {
    private boolean shootLock = false;//shoot
    FrameCounter frameCounter =  new FrameCounter(50);

    void run(Player player){
        if(InputManager.instance.xPressed && !this.shootLock){
            PlayerBullet newBullet = new PlayerBullet((int)player.position.x ,(int)player.position.y);
            GameObject.add(newBullet);
            this.shootLock = true;
        }

        if(shootLock){
            frameCounter.run();
            if(frameCounter.expired){
                shootLock = false;
                frameCounter.reset();
            }
        }
    }

}
