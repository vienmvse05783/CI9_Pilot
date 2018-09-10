package bases;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;


public class Animation extends Renderer {
    ArrayList<Image> images;
    int imageIndex;
    int frameDelay;
    FrameCounter frameCounter ;
    private boolean oneTime;
    public  boolean finish;

    //1. load image
    public Animation(Image... imgs){
        this(10,false,imgs);

    }
    public Animation(int frameDelay,boolean oneTime,Image... imgs){
        this.images=new ArrayList<>();
        this.images.addAll(Arrays.asList(imgs));

        this.imageIndex=0;
        this.frameCounter= new FrameCounter(frameDelay);
        this.oneTime=oneTime;
        this.finish=false;
    }
    //2. draw
    public void render(Graphics g,Vector2D position){
        renderCurrentImage( g,position);
        changeCurrentImage();

    }

    private void changeCurrentImage() {
        frameCounter.run();
        if(frameCounter.expired){
            frameCounter.reset();
            if(this.imageIndex<this.images.size()-1){
                this.imageIndex+=1;
            }else{
                if (this.oneTime){
                    this.finish=true;
                }else {
                    this.imageIndex=0;
                }

            }
        }
    }

    private void renderCurrentImage(Graphics g,Vector2D position) {
        Image curentImage=images.get(this.imageIndex);
        int width=curentImage.getWidth(null);
        int height=curentImage.getHeight(null);

        g.drawImage(curentImage,(int)(position.x-width/2),(int)(position.y-height/2),null);
    }

}
