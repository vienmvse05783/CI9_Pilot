package bloods;

import bases.FrameCounter;
import bases.GameObject;
import java.util.ArrayList;
import java.util.Random;

public class BloodSpawn extends GameObject{
    Random random;
    public ArrayList<Blood> bloods;
    FrameCounter frameCounter=new FrameCounter(200);

    public BloodSpawn(){
        super(0,0);
        bloods = new ArrayList<>();
        random = new Random();
    }
    public void run(){
        frameCounter.run();
        if (frameCounter.expired){
            int posY = random.nextInt(600);
           Blood blood = GameObject.recycle(0,posY,Blood.class);
//            if(blood==null){
//                blood=new Blood(posX, 0);
//                GameObject.add(blood);
//            }else {
//                blood.isActive=true;
//                blood.position.x=posX;
//                blood.position.y=0;
//            }

            frameCounter.reset();
        }
    }


}
