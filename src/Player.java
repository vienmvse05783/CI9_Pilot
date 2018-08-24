import java.awt.*;
import java.util.ArrayList;

public class Player {
    Vector2D position;

    Image image;
    InputManager inputManager;
    boolean shootLock = false;
    int count ;
    ArrayList<PlayerBullet>bullets;

    Player(int x, int y){
        this.position=new Vector2D(x,y);
        this.image = ImageUtil.load("images/player/MB-69/player1.png");
    }

    // Method inserted
    void render(Graphics g){
        g.drawImage(this.image, (int)this.position.x,(int)this.position.y, null);
    }

    void run(){
        this.move();
        this.shoot();
    }

    private void shoot() {
        if(this.inputManager.xpressed && !this.shootLock){
            PlayerBullet newBullet= new PlayerBullet((int)this.position.x,(int)this.position.y);
            this.bullets.add(newBullet);
            this.shootLock=true;
        }
    }

    private void move() {
        Vector2D velocity =new Vector2D();
        if(inputManager.rightPress){
            velocity.x+=5;
        }
        if(inputManager.leftPress){
           velocity.x -= 5;
        }
        if(inputManager.upPress){
            velocity.y -= 5;
        }
        if(inputManager.downPress){
            velocity.y += 5;
        }
        this.position.addUp(velocity);
    }

//    void shoot(ArrayList<PlayerBullet> bullets){
//
//        if(inputManager.xpressed && !shootLock){
//            PlayerBullet newB = new PlayerBullet(this.x, this.y);
//            bullets.add(newB);
//            shootLock = true;
//        }
//
//        for(PlayerBullet b: bullets)
//        {
//            b.run();
//        }
//
//        if(shootLock){
//            count++;
//            if(count > 20)
//            {
//                shootLock = false;
//                count = 0;
//            }
//        }
//
//    }
}