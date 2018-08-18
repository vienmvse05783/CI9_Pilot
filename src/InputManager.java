import java.awt.event.KeyEvent;

public class InputManager {
    boolean rightPress = false;
    boolean leftPress = false;
    boolean upPress = false;
    boolean downPress = false;
    boolean xpressed = false;

    void KeyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightPress = true;

        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftPress = true;

        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            upPress = true;

        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            downPress = true;

        }
        if (e.getKeyCode() == KeyEvent.VK_X) {
            xpressed = true;
        }
    }

    void KeyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightPress = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftPress = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            upPress = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            downPress = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_X) {
            xpressed = false;
        }
    }

}
