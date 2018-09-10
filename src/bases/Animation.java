package bases;

import java.awt.*;
import java.util.ArrayList;


public class Animation extends Renderer {
    ArrayList<Image> images;
    int imageIndex;
    int frameDelay;
    FrameCounter frameCounter = new FrameCounter(frameDelay);
    private boolean changeImage;
    //1. load image
    public Animation(ArrayList<Image>images){
        this(images,50);
    }
    public Animation(ArrayList<Image> images,int frameDelay){
        this.images=images;
        this.imageIndex=0;
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
                this.imageIndex=0;
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
