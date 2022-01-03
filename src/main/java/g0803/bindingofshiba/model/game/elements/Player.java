package g0803.bindingofshiba.model.game.elements;

import g0803.bindingofshiba.model.game.Position;

public class Player {
    private Position position;
    private float hp;
    private float damage;

    public Player(Position position, float hp, float damage) {
        this.position = position;
        this.hp = hp;
        this.damage = damage;
    }

    public int getX() {
        return position.getX();
    }

    public int getY() {
        return position.getY();
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
