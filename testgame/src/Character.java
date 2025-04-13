import javafx.scene.shape.Rectangle;

// Kelas abstrak Character
abstract class Character {
    protected Rectangle shape;
    protected double x, y;
    protected int hp;

    public Character(double x, double y, int hp, Color color) {
        this.x = x;
        this.y = y;
        this.hp = hp;
        this.shape = new Rectangle(x, y, 30, 30); // Ukuran 30x30
        this.shape.setFill(color);
    }

    public Rectangle getShape() { return shape; }
    public double getX() { return x; }
    public double getY() { return y; }
    public int getHp() { return hp; }
    public void setHp(int hp) { this.hp = hp; }
    public void setX(double x) { this.x = x; shape.setX(x); }
    public boolean isAlive() { return hp > 0; }
}