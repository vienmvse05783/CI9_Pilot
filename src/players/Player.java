package players;
import java.util.ArrayList;

import bases.BoxCollider;
import bases.GameObject;
import bases.ImageRenderer;

public class Player extends GameObject {
    private PlayerMove playerMove;
    private PLayerShoot pLayerShoot;
    public ArrayList<PlayerBullet> bullets;

    public Player(int x,int y){
        super(x,y);
        this.renderer=new ImageRenderer("images/player/MB-69/player1.png");
        playerMove = new PlayerMove();
        pLayerShoot = new PLayerShoot();
        this.boxCollider= new BoxCollider(x,y,60,70);
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
    public void getHit() {
        this.gameOver();
    }

    void move(){

        this.playerMove.run(position);
    }

}

