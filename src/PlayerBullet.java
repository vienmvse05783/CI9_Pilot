import java.awt.*;

public class PlayerBullet {
    Vector2D position;

//    int x;
//    int y;
    Image image;
    PlayerBullet(int x,int y){
        this.position=new Vector2D(x,y);

//        this.x= x;
//        this.y=y;
        this.image = ImageUtil.load("images/bullet/player/mb69bullet1.png");
    }
    void render(Graphics g){
        g.drawImage(this.image,(int)this.position.x,(int)this.position.y,null);
    }
    void run(){
        this.position.y -=10;
    }
}
