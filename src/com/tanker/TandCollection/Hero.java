package com.tanker.TandCollection;

public abstract class Hero<T> {

    private int HP;
    private int MP;

    private T weapon;

    public Hero(int HP, int MP) {
        this.HP = HP;
        this.MP = MP;
    }

    public int getHP() {
        return HP;
    }

    public int getMP() {
        return MP;
    }


    public void setMP(byte MP) {
        this.MP = MP;
    }

    public void setHP(byte HP) {
        this.HP = HP;
    }

    public T getWeapon() {
        return weapon;
    }

    public void setWeapon(T weapon) {
        this.weapon = weapon;
    }

}
