package players;
import java.awt.*;
public class Player2Move {

    public void run(Player2 player2) {
        PointerInfo p = MouseInfo.getPointerInfo();
        player2.position.x = (int) p.getLocation().getX();
        player2.position.y = (int) p.getLocation().getY();
    }

}