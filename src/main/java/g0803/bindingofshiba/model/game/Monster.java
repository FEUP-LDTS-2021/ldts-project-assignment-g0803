package g0803.bindingofshiba.model.game;

public class Monster {
    private int x;
    private int y;
    private float hp;
    private float damage;

    public Monster(int x, int y, float hp, float damage) {
        this.x = x;
        this.y = y;
        this.hp = hp;
        this.damage = damage;
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
        return this.hp > 0;
    }

    public void decreaseHpByAmount(float amount) throws IllegalArgumentException {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        } else if (amount > this.hp) {
            this.hp = 0;
        } else {
            this.hp = hp - amount;
        }
    }
}
