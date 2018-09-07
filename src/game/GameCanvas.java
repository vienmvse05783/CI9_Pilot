package game;

import bases.GameObject;
import bases.ImageUtil;
import bloods.Blood;
import bloods.BloodSpawn;
import enemies.EnemySpawn;
import players.Player;
import players.Player2;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;


public class GameCanvas extends JPanel {


    Image background;
    BloodSpawn bloodSpawn;
    EnemySpawn enemySpawn;
    Player player;
    Player2 player2;
    Blood blood;

//    int enemySpawnCount = 0;
    BufferedImage backBuffer;
    Graphics backBufferGraphics;
    Random random;

    public GameCanvas(){

        bloodSpawn=new BloodSpawn();
        enemySpawn = new EnemySpawn();
        random = new Random();
        GameObject.add(bloodSpawn);
        GameObject.add(enemySpawn);
        player2=new Player2(300,300);
        GameObject.add(player2);
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
