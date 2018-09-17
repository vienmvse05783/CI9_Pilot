package players;

import bases.Animation;
import bases.ImageUtil;
import bases.Renderer;
import bases.Vector2D;

import java.awt.*;

public class PlayerAnimator extends Renderer {
    private Animation currentAnimation;
    private Animation leftAninmation;
    private  Animation righAninmation;
    private  Animation straighAninmation;
    public PlayerAnimator(){
        leftAninmation=new Animation(
                ImageUtil.load("images/player/MB-69/player_left1.png"),
                ImageUtil.load("images/player/MB-69/player_left2.png"),
                ImageUtil.load("images/player/MB-69/player_left3.png"),
                ImageUtil.load("images/player/MB-69/player_left4.png")
        );
        righAninmation=new Animation(
                ImageUtil.load("images/player/MB-69/player_right1.png"),
                ImageUtil.load("images/player/MB-69/player_right2.png"),
                ImageUtil.load("images/player/MB-69/player_right3.png"),
                ImageUtil.load("images/player/MB-69/player_right4.png")
        );
        straighAninmation=new Animation(
                ImageUtil.load("images/player/MB-69/player1.png"),
                ImageUtil.load("images/player/MB-69/player2.png"),
                ImageUtil.load("images/player/MB-69/player3.png"),
                ImageUtil.load("images/player/MB-69/player4.png")
        );
        currentAnimation=this.straighAninmation;
    }

    @Override
    public void render(Graphics g, Vector2D position) {
       this.currentAnimation.render(g,position);
    }
    public void selectAnimation(Vector2D playerVelocity) {
        if(playerVelocity.x<0){
            this.currentAnimation= this.leftAninmation;

        }else if(playerVelocity.x>0){
            this.currentAnimation= this.righAninmation;
        }else {
            this.currentAnimation= this.straighAninmation;
        }
    }
}


