package com.tanker.TandCollection;

public class TestRunner {

    public static void main(String[] args) {

        Warrior<Sword> warrior = new Warrior<>(10, 10);

        warrior.setWeapon(new Sword());

        Archer<Bow> archer = new Archer<>(20, 20);

        archer.setWeapon(new Bow());

        ShowHeroParams(warrior);

        ShowHeroParams(archer);
    }

    private static void ShowHeroParams(Hero <? extends Weapon> hero) {
        System.out.println(
                hero.getMP() + "\n" +
                hero.getHP() + "\n" +
                hero.getWeapon().getDamage());
    }

}
