import java.math.*;

public class Vector2D {
    float x;
    float y;

    public Vector2D() {
        this(0, 0);
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
        return this.add(other.x, other.y);
    }

    public void addUp(Vector2D other) {
        this.addUp(other.x, other.y);
    }

    void print() {
        System.out.println(this.x + " " + this.y);
    }

    public void subtractBy(float x, float y) {
        this.x -= x;
        this.y -= y;
    }

    public void subtractBy(Vector2D other) {
        this.subtractBy(other.x, other.y);
    }

    public Vector2D subtract(float x, float y) {
        return new Vector2D(x - this.x, y - this.y);
    }

    public Vector2D sutract(Vector2D other) {
        return this.subtract(other.x, other.y);
    }

    public void scaleBy(float m) {
        this.x *= m;
        this.y *= m;
    }

    public Vector2D scale(float m) {
        return new Vector2D(this.x * m, this.y * m);
    }

    public float length() {
        return (float) Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
    }

    public Vector2D normalize() {
        float length=this.length();
        return new Vector2D(this.x/length,this.y/length) ;
    }

    public static void main(String[] args) {
        Vector2D v1 = new Vector2D(3, 4);

        Vector2D v2;
        v2=v1.normalize();
        v2.print();

    }


}
