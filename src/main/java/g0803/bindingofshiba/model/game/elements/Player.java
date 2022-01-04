package g0803.bindingofshiba.model.game.elements;

import g0803.bindingofshiba.model.game.Position;

public class Player {
    private Position position;
    private int numberOfKeys;
    private int hp;
    private int damage;

    public Player(Position position, int numberOfKeys, int hp, int damage) {
        this.position = position;
        this.numberOfKeys = numberOfKeys;
        this.hp = hp;
        this.damage = damage;
    }

    public int getX() {
        return position.getX();
    }

    public int getY() {
        return position.getY();
    }

    public int getHp() {
        return hp;
    }

    public Position getPosition() {
        return position;
    }

    public int getNumberOfKeys() {
        return numberOfKeys;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public float getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void pickKey() {
        this.numberOfKeys++;
    }

    public boolean isAlive() {
        return this.hp > 0;
    }

    public void decreaseHpByAmount(int amount) throws IllegalArgumentException {
        if (amount < 0)
            throw new IllegalArgumentException("Amount cannot be negative");

        int newHp = this.hp - amount;
        this.hp = newHp >= 0 ? newHp : 0;
    }
}
