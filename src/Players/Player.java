package Players;
import java.awt.*;
import java.util.ArrayList;
import Bases.GameObject;
import Bases.ImageRenderer;

public class Player extends GameObject {
    private PlayerMove playerMove;
    private PLayerShoot pLayerShoot;
    public ArrayList<PlayerBullet> bullets;

    public Player(int x,int y){
        super(x,y);
        this.imageRenderer=new ImageRenderer("images/player/MB-69/player1.png");
        playerMove = new PlayerMove();
        pLayerShoot = new PLayerShoot();
    }



    public void run(){
        super.run();
        this.move();
        this.shoot();//shoot
    }

    public void shoot() {
        pLayerShoot.run(this);
//        for(PlayerBullet b: bullets)
//        {
//            b.run();
//        }

    }

    void move(){
        this.playerMove.run(position);
    }

}

