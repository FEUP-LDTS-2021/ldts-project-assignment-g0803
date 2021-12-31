package g0803.bindingofshiba.gui;

public class Player {
    private int x;
    private int y;
    private float hp;
    private float damage;

    public Player(int x, int y, float hp, float damage) {
        this.x = x;
        this.y = y;
        this.hp = hp;
        this.damage = damage;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public float getHp() {
        return hp;
    }

    public void setHp(float hp) {
        this.hp = hp;
    }

    public float getDamage() {
        return damage;
    }

    public void setDamage(float damage) {
        this.damage = damage;
    }

    public boolean isAlive() {
        return this.hp > 0;
    }

    public void decreaseHpByAmount(float amount) throws IllegalArgumentException {
        if (amount < 0)
            throw new IllegalArgumentException("Amount cannot be negative");

        float newHp = this.hp - amount;
        this.hp = newHp >= 0 ? newHp : 0;
    }
}
