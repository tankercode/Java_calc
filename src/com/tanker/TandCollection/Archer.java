package com.tanker.TandCollection;

public class Archer<T extends LongRangeWeapon> extends Hero<T>{

    public Archer(int HP, int MP) {
        super(HP, MP);
    }
}
