import java.awt.*;

public class Player {
    int x = 300 - 32;
    int y = 700 - 40;
    Image image;
    InputManager inputManager;
    Player(){
        this.x=x;
        this.y=y;
        image=ImageUtil.load("images/player/MB-69/player1.png");
    }
    void render(Graphics g){
        g.drawImage(this.image,this.x,this.y,null);
    }


    void run(){
        if (inputManager.rightPress)
            this.x += 5;
        if (inputManager.leftPress)
            this.x -= 5;
        if (inputManager.upPress)
            this.y -= 5;
        if (inputManager.downPress)
            this.y += 5;
    }
}
