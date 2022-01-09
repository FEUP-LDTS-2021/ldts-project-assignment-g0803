package g0803.bindingofshiba.model.game.elements;

import g0803.bindingofshiba.model.game.Position;

public class Monster extends Element {
    private float hp;
    private float damage;

    public Monster(Position position, float hp, float damage) {
        super(position);
        this.hp = hp;
        this.damage = damage;
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
        }

        if (amount > this.hp) {
            this.hp = 0;
        } else {
            this.hp = hp - amount;
        }
    }
}