package players;
import java.util.ArrayList;
import inputs.InputManager;

import bases.*;

public class Player extends GameObject {
    private PlayerMove playerMove;
    private PLayerShoot pLayerShoot;
    public ArrayList<PlayerBullet> bullets;
    private  PlayerAnimator playerAnimator;



    public Player(int x,int y){
        super(x,y);
        this.playerAnimator=new PlayerAnimator();

        this.renderer=this.playerAnimator;

        playerMove = new PlayerMove();
        pLayerShoot = new PLayerShoot();
        this.boxCollider= new BoxCollider(x,y,60,70);
    }



    public void run(){
        super.run();
        this.move();
        this.shoot();//shoot
        this.animate();

    }

    private void animate() {
        this.playerAnimator.selectAnimation(this.playerMove.velocity);
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

