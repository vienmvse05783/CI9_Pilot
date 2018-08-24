import java.math.*;
public class Vector2D {
    float x;
    float y;

    public Vector2D() {
        this(0,0);
    }

    public Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void addUp(float x, float y) {
        this.x += x;
        this.y += y;
    }

    public Vector2D add(float x, float y) {
        return new Vector2D(x + this.x, y + this.y);
    }
    public Vector2D add(Vector2D other) {
        return this.add(other.x,other.y);
    }

    public void addUp(Vector2D other) {
       this.addUp(other.x,other.y);
    }
    void print(){
        System.out.println(this.x+ " "+ this.y);
    }

    public void subtractBy(float x, float y) {
        this.x -= x;
        this.y -= y;
    }
    public void subtractBy(Vector2D other) {
        this.subtractBy(other.x,other.y);
    }
    public Vector2D subtract(float x, float y) {
        return new Vector2D(x - this.x, y - this.y);
    }
    public  Vector2D sutract(Vector2D other){
        return this.subtract(other.x,other.y);
    }

    public void scaleBy(float m){
        this.x *=m;
        this.y *=m;
    }
    public Vector2D scale(float m){
        return new Vector2D(this.x*m,this.y*m);
    }
    public float length(){
        return (float) Math.sqrt(Math.pow(this.x,2) + Math.pow(this.y,2));
    }

    public static void main(String[] args) {
        Vector2D v1 = new Vector2D(3, 4);
        System.out.println(v1.length());
        v1.addUp(5, 7);
        Vector2D v2 = new Vector2D(2, 3);
        Vector2D v3 = v2.add(5, 7);
        v1.subtractBy(3,4);
        v1.print();
        v1.subtractBy(v2);
        v1.scaleBy(2);
        v1.print();
        Vector2D v4 ;
        v4=v1.scale(3);
        v4.print();

        v1.addUp(v2);
        v2.add(v3);




    }


}
