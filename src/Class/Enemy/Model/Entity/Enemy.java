package Class.Enemy.Model.Entity;

import Class.Character.model.entity.Character;

public class Enemy extends Character {


    public Enemy() {
    }

    public Enemy(String name, int x, int y) {
        super.name = name;
        super.maxHP = (int) (Math.random() * (130 - 90 + 1) + 90);
        super.currentHp = super.maxHP;
        super.armour = (int) (Math.random() * (2 - 5 + 1) + 5);
        super.currentDamage = (int) (Math.random() * (15 - 10 + 1) + 10);
        super.maxDamage = super.currentDamage * 2;
        super.positionX = (int) (Math.random() * x);
        super.positionY = (int) (Math.random() * y + 2);
        super.dead = false;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public boolean getDead() {
        return this.dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    @Override
    public String toString() {
        if (!this.getDead()) {
            return "| ✩ |";
        } else {

            return "|   |";
        }

    }

}
