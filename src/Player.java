import java.awt.*;
import java.util.ArrayList;

public class Player {
    int x ;
    int y ;
    Image image;
    InputManager inputManager;
    boolean shootLock = false;
    int count ;

    Player(int x, int y){
        this.x = x;
        this.y = y;
        this.image = ImageUtil.load("images/player/MB-69/player1.png");
    }

    // Method inserted
    void render(Graphics g){
        g.drawImage(this.image, this.x, this.y, null);
    }

    void run(){
        if(inputManager.rightPress){
            this.x += 5;
        }
        if(inputManager.leftPress){
            this.x -= 5;
        }
        if(inputManager.upPress){
            this.y -= 5;
        }
        if(inputManager.downPress){
            this.y += 5;
        }
    }

    void shoot(ArrayList<PlayerBullet> bullets){

        if(inputManager.xpressed && !shootLock){
            PlayerBullet newB = new PlayerBullet(this.x, this.y);
            bullets.add(newB);
            shootLock = true;
        }

        for(PlayerBullet b: bullets)
        {
            b.run();
        }

        if(shootLock){
            count++;
            if(count > 20)
            {
                shootLock = false;
                count = 0;
            }
        }

    }
}