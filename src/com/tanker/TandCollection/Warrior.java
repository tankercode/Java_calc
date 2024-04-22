package com.tanker.TandCollection;

public class Warrior<T extends MeleeWeapon> extends Hero<T> {

    public Warrior(int HP, int MP) {
        super(HP, MP);
    }
}
