package Game;

import Bases.GameObject;
import Bases.ImageUtil;
import Bloods.Blood;
import Bloods.BloodSpawn;
import Enemies.Enemy;
import Enemies.EnemySpawn;
import Players.Player;
import Players.Player2;
import Players.PlayerBullet;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
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

        blood =new Blood(0,0);
        GameObject.add(blood);

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
