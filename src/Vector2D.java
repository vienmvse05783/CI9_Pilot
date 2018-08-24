public class Vector2D {
    float x;
    float y;

    public Vector2D() {
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
        Vector2D vector2D = new Vector2D(x+ this.x,y+ this.y);

        return vector2D;
    }

    public static void main(String[] args) {
        Vector2D v1 =new Vector2D(2,3);
        v1.addUp(5,7);

        Vector2D v2=new Vector2D(2,3);
        Vector2D v3=v2.add(5,7);

    }
}
