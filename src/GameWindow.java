import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class GameWindow extends JFrame {


    GameCanvas gameCanvas;
    InputManager inputManager;


    public GameWindow() {
        //setup game windowc //?

        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.addKeyListener(new KeyAdapter() {


            @Override
            public void keyPressed(KeyEvent e) {
                gameCanvas.inputManager.KeyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                gameCanvas.inputManager.KeyReleased(e);
            }
        });
        this.setTitle("Micro-war ");
        this.setResizable(false);
        this.setSize(600, 800);


        // setup canvas
        gameCanvas = new GameCanvas();
        this.setContentPane(gameCanvas);

        this.setVisible(true);


    }


    void mainLoop(){
        long lastTimeRender=0;
        while (true){
            long currentTime=System.nanoTime();
            if(currentTime- lastTimeRender>=17_000_000){
                gameCanvas.run();
                gameCanvas.render();
                lastTimeRender=currentTime;
            }

        }
    }
}
