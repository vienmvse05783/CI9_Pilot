package Bloods;

import Bases.GameObject;
import Bases.ImageRenderer;

public class Blood extends GameObject {


    public Blood(int x, int y) {
        super(x, y);
        this.imageRenderer = new ImageRenderer("images/blood cells/blood-cell1.png");

    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(2,3);
    }
}
