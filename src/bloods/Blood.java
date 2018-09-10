package bloods;

import bases.GameObject;
import bases.ImageRenderer;

public class Blood extends GameObject {


    public Blood(int x, int y) {
        super(x, y);
        this.renderer = new ImageRenderer("images/blood cells/blood-cell1.png");

    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(2,3);
    }
}
