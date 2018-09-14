package players;
import java.util.ArrayList;
import inputs.InputManager;

import bases.*;

public class Player extends GameObject {
    private PlayerMove playerMove;
    private PLayerShoot pLayerShoot;
    public ArrayList<PlayerBullet> bullets;

    public Player(int x,int y){
        super(x,y);
        if(InputManager.instance.leftPressed){
            this.renderer = new Animation(
                    ImageUtil.load("images/player/MB-69/player_left1.png"),
                    ImageUtil.load("images/player/MB-69/player_left2.png"),
                    ImageUtil.load("images/player/MB-69/player_left3.png"),
                    ImageUtil.load("images/player/MB-69/player_left4.png")
            );
        }
        else if (InputManager.instance.rightPressed){
            this.renderer = new Animation(
                    ImageUtil.load("images/player/MB-69/player_right1.png"),
                    ImageUtil.load("images/player/MB-69/player_right2.png"),
                    ImageUtil.load("images/player/MB-69/player_right3.png"),
                    ImageUtil.load("images/player/MB-69/player_right4.png")
            );

        }
        else {
            this.renderer = new Animation(
                    ImageUtil.load("images/player/MB-69/player1.png"),
                    ImageUtil.load("images/player/MB-69/player2.png"),
                    ImageUtil.load("images/player/MB-69/player3.png"),
                    ImageUtil.load("images/player/MB-69/player4.png")
            );
        }
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

