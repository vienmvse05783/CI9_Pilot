package bloods;

import bases.Animation;
import bases.GameObject;
import bases.ImageRenderer;
import bases.ImageUtil;

public class Blood extends GameObject {


    public Blood(int x, int y) {
        super(x, y);
        this.renderer = new Animation(
                ImageUtil.load("images/blood cells/blood-cell1.png"),
                ImageUtil.load("images/blood cells/blood-cell2.png"),
                ImageUtil.load("images/blood cells/blood-cell3.png"),
                ImageUtil.load("images/blood cells/blood-cell4.png")
        );

    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(2,3);
        deActiveIfNeeded();
    }
    private void deActiveIfNeeded() {
        if(this.position.y >800 || this.position.x>600){
            this.isActive=false;
        }
    }
}
