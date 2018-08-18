
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class GameCanvas extends JPanel {


    Image background;
    Image bloodCell;
    Player player = new Player();
    InputManager inputManager;

    ArrayList<PlayerBullet> bullets;
    ArrayList<Enemy> enemies;


    BufferedImage backbuffer;
    Graphics backbufferGraphics;


    String text = "Press Enter to start game";

    Random random;

    public GameCanvas() {
        inputManager =new InputManager();
        player.inputManager=inputManager;
        random = new Random();
        bullets = new ArrayList<>();
        enemies = new ArrayList<>();


        background = ImageUtil.load("images/background/background.png");

        bloodCell = ImageUtil.load("images/blood cells/blood-cell1.png");


        backbuffer = new BufferedImage(600, 800, BufferedImage.TYPE_INT_ARGB);
        backbufferGraphics = backbuffer.getGraphics();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(backbuffer, 0, 0, null);

    }

    void run() {
        player.run();

        for (PlayerBullet b : bullets) {
            b.run();
        }
        for (Enemy e : enemies) {
//            e.y += e.speed;
            e.run();
        }
        if (inputManager.xpressed && !ShootLock) {
            PlayerBullet newB = new PlayerBullet(player.x, player.y);

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
            int posX = random.nextInt(getWidth() - 32);
            Enemy newEne = new Enemy(posX, 0);
            newEne.speed = random.nextInt(4) + 2;
            newEne.image = ImageUtil.load("images/enemy/bacteria/bacteria1.png");
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


        for (PlayerBullet b : bullets) {
            b.render(backbufferGraphics);
        }
        for (Enemy e : enemies) {
            e.render(backbufferGraphics);
        }
       // backbufferGraphics.drawImage(player.image, player.x, player.y, null);
        player.render(backbufferGraphics);

        this.repaint();
    }
}
