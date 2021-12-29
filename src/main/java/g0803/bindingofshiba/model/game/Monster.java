package g0803.bindingofshiba.model.game;

public class Monster {
    private int x;
    private int y;
    private float hp;
    private float damage;

    public Monster(int x, int y, float hp, float dmg) {
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public float getHp() {
        return this.hp;
    }

    public float getDamage() {
        return this.damage;
    }

    public boolean isAlive() {
        return false;
    }

    public void decreaseHpByAmount(float amount) throws IllegalArgumentException {

    }
}
