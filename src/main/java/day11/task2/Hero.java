package day11.task2;

public abstract class Hero implements PhysAttack {
    int health;
    double physDef;
    double magicDef;
    int physAtt;

    final int MAX_HEALTH = 100;
    final int MIN_HEALTH = 0;
    final int PALADIN_SELF_HEALTH = 25;
    final int PALADIN_OTHER_HEALTH = 20;
    final int SHAMAN_SELF_HEALTH = 50;
    final int SHAMAN_OTHER_HEALTH = 30;

    public Hero() {
        health = MAX_HEALTH;
    }

    @Override
    public void physicalAttack(Hero hero) {
        double physDmg = physAtt * (1 - hero.physDef);
        if (hero.health - physDmg < MIN_HEALTH) hero.health = MIN_HEALTH;
        else hero.health -= physDmg;
    }
}
