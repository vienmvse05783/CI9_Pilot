package Game;

import Bases.GameObject;
import Bases.ImageUtil;
import Enemies.Enemy;
import Enemies.EnemySpawn;
import Players.Player;
import Players.PlayerBullet;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;


public class GameCanvas extends JPanel {


    Image background;

    EnemySpawn enemySpawn;
    Player player;




//    int enemySpawnCount = 0;
    BufferedImage backBuffer;
    Graphics backBufferGraphics;
    Random random;

    public GameCanvas(){

        enemySpawn = new EnemySpawn();
        random = new Random();


        player = new Player(268, 600);
          GameObject.add(player);

        background = ImageUtil.load("images/background/background.png");

        backBuffer = new BufferedImage(600, 800, BufferedImage.TYPE_INT_ARGB);
        backBufferGraphics = backBuffer.getGraphics();
    }

    @Override
    protected void paintComponent(Graphics g) {
       g.drawImage(backBuffer, 0 , 0 , null);
    }



    void run() {
        GameObject.runAll();
        enemySpawn.run();
        }

//
//        enemySpawnCount++;
//        if(enemySpawnCount > 60){
//            enemySpawnCount = 0;
//            int posX = random.nextInt(600);
//            Enemy enemy = new Enemy(posX, 0);
//            enemies.add(enemy);
//        }



    public void render(){
        backBufferGraphics.drawImage(background, 0, 0, null);
        GameObject.renderAll(backBufferGraphics);
        this.repaint();
    }
}
