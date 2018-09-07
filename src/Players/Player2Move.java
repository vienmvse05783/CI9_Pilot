package Players;

import Bases.Vector2D;
import java.awt.*;
public class Player2Move {
    Vector2D velocity = new Vector2D();

    public void run(Player2 player2) {
        PointerInfo p = MouseInfo.getPointerInfo();
        player2.position.x = (int) p.getLocation().getX();
        player2.position.y = (int) p.getLocation().getY();
    }

}