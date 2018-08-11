import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class GameWindow extends JFrame {


    GameCanvas gameCanvas;


    public GameWindow() {
        //setup game window
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("windowOpened");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
        this.setTitle("Micro-war by vienmv");
        this.setResizable(false);
        this.setSize(600, 800);



        // setup canvas
        gameCanvas = new GameCanvas();
        this.setContentPane(gameCanvas);

        this.setVisible(true);



    }
}
