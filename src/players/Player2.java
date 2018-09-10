package players;

import bases.GameObject;
import bases.ImageRenderer;


import java.awt.*;

public class Player2 extends GameObject {
    Player2Move player2Move;

    public Player2(int x, int y) {
        super(x, y);
        renderer = new ImageRenderer("images/player/MB-70/player1.png");
        player2Move = new Player2Move();
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
    }

    @Override
    public void run() {
        super.run();
        player2Move.run(this);
    }
}