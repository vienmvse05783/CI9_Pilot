package Bloods;

import Bases.FrameCounter;
import Bases.GameObject;
import java.util.ArrayList;
import java.util.Random;

public class BloodSpawn  {
    Random random;
    public ArrayList<Blood> bloods;
    FrameCounter frameCounter=new FrameCounter(200);

    public BloodSpawn(){
        bloods = new ArrayList<>();
        random = new Random();
    }
    public void run(){
        frameCounter.run();
        if (frameCounter.expired){
            int posX = random.nextInt(600);
            Blood blood = new Blood(posX, 0);
            GameObject.add(blood);
            frameCounter.reset();
        }
    }


}