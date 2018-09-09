package bases;

import enemies.Enemy;
import players.Player;

import java.awt.*;
import java.util.ArrayList;

public class GameObject {
    public Vector2D position;
    public ImageRenderer imageRenderer;
    public  boolean isActive;
    public  boolean isDead;
    private static ArrayList<GameObject> gameObjects=new ArrayList<>();
    private static ArrayList<GameObject> newGameObjects=new ArrayList<>();

    public static void add(GameObject g){
       newGameObjects.add(g);
    }
    public  static void runAll(){
        for(GameObject go: gameObjects){
            if(go.isActive && ! go.isDead)
            go.run();
        }
        gameObjects.addAll(newGameObjects);
        newGameObjects.clear();
    }

    public  static void renderAll(Graphics g){
        for(GameObject go: gameObjects){
            if(go.isActive && !go.isDead)
            go.render(g);
        }
    }
    public static Enemy checkCollisionEnemy(BoxCollider boxCollider){
        for (GameObject go: gameObjects){
            if (go.boxCollider !=null && go.isActive){
                if(go instanceof Enemy){
                    if(go.boxCollider.collideWith(boxCollider)){
                        return (Enemy)go;
                    }
                }
            }
        }
        return  null;
    }

    public static Player checkCollisionPlayer(BoxCollider boxCollider){
        for (GameObject go: gameObjects){
            if (go.boxCollider !=null && go.isActive){
                if(go instanceof Player){
                    if(go.boxCollider.collideWith(boxCollider)){
                        return (Player) go;
                    }
                }
            }
        }
        return  null;
    }
    public BoxCollider boxCollider;
    public GameObject(int x,int y){
        this.position =new Vector2D(x,y);
        this.imageRenderer=null; //not yet specified
        this.boxCollider = null;
        this.isActive=true;
    }
    public void run(){
        if(this.boxCollider !=null){
            this.boxCollider.position.x=this.position.x;
            this.boxCollider.position.y=this.position.y;
            this.boxCollider.run();

        }

    }
    public void render(Graphics g){
        if(this.imageRenderer!=null){
            this.imageRenderer.render(g,this.position);
        }
        if(this.boxCollider !=null){
            this.boxCollider.render(g);
        }
    }
    public void destroy(){

        this.isActive = false;
    }
    public void gameOver() {
        this.isDead = true;
        System.out.println("game over");
    }
}
