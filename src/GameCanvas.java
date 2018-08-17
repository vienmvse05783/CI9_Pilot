import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class GameCanvas extends JPanel {

    boolean rightPress = false;
    boolean leftPress = false;
    boolean upPress = false;
    boolean downPress = false;
    boolean xpress = false;
    Image background;
    Image player;
    Image bloodCell;

    ArrayList<PlayerBullet> bullets;
    ArrayList<Enemy> enemies;


    BufferedImage backbuffer;
    Graphics backbufferGraphics;


    int x = 300 - 32;
    int y = 700 - 40;

    String text = "Press Enter to start game";

    Random random;

    public GameCanvas() {
        random = new Random();
        bullets = new ArrayList<>();
        enemies = new ArrayList<>();


        background = ImageUtil.load("images/background/background.png");
        player = ImageUtil.load("images/player/MB-69/player1.png");
        bloodCell = ImageUtil.load("images/blood cells/blood-cell1.png");


        backbuffer = new BufferedImage(600, 800, BufferedImage.TYPE_INT_ARGB);
        backbufferGraphics = backbuffer.getGraphics();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(backbuffer, 0, 0, null);

    }


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
            xpress = true;
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
            xpress = false;
        }
    }

    void run() {
        if (rightPress)
            x += 5;
        if (leftPress)
            x -= 5;
        if (upPress)
            y -= 5;
        if (downPress)
            y += 5;
        for (PlayerBullet b : bullets) {
            b.y -= 10;
        }
        for (Enemy e : enemies) {
            e.y += e.speed;
        }
        if (xpress && !ShootLock) {
            PlayerBullet newB = new PlayerBullet();
            newB.x = x;
            newB.y = y;

            newB.image = ImageUtil.load("images/bullet/player/mb69bullet1.png");

            bullets.add(newB);
            ShootLock = true;
        }
        if (ShootLock) {
            count++;
            if (count > 40) {
                ShootLock = false;
                count = 0;
            }
        }
        if (!EnemyLock) {

            Enemy newEne = new Enemy();
            newEne.x = random.nextInt(getWidth() - 32);
            newEne.speed = random.nextInt(4) + 2;
            newEne.y = 0;

            try {
                newEne.image = ImageIO.read(new File("images/enemy/bacteria/bacteria1.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            enemies.add(newEne);
            EnemyLock = true;
        }
        if (EnemyLock) {
            countEnemy1++;
            if (countEnemy1 > 40) {
                EnemyLock = false;
                countEnemy1 = 0;
            }
        }


    }

    boolean ShootLock = false;
    int count;
    int countEnemy1;
    boolean EnemyLock = false;


    void render() {
        backbufferGraphics.drawImage(background, 0, 0, null);
        backbufferGraphics.drawImage(bloodCell, 200, 384, null);
        backbufferGraphics.drawImage(player, x, y, null);

        for (PlayerBullet b : bullets) {
            backbufferGraphics.drawImage(b.image, b.x, b.y, null);
        }
        for (Enemy e : enemies) {
            backbufferGraphics.drawImage(e.image, e.x, e.y, null);
        }

        this.repaint();
    }
}
