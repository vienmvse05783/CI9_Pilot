import java.awt.*;

public class Enemy {
    int x;
    int y;
    int speed;
    Image image;

    Enemy(int posX, int posY ){
        x=posX;
        y=posY;
        image=ImageUtil.load("images/enemy/bacteria/bacteria1.png");
    }

}
