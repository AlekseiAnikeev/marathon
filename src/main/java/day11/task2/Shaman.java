package day11.task2;

public class Shaman extends Hero implements MagicAttack, Healer {

    public Shaman() {
        physAtt = 10;
        magicAtt = 15;
        physDef = 0.2;
        magicDef = 0.2;
    }

    @Override
    public void healHimself() {
        if (health + SHAMAN_SELF_HEALTH > MAX_HEALTH) health = MAX_HEALTH;
        else health += SHAMAN_SELF_HEALTH;
    }

    @Override
    public void healTeammate(Hero hero) {
        if (hero.health + SHAMAN_OTHER_HEALTH > MAX_HEALTH) hero.health = MAX_HEALTH;
        else hero.health += SHAMAN_OTHER_HEALTH;
    }

    @Override
    public void magicalAttack(Hero hero) {
        double magicDmg = magicAtt * (1 - hero.magicDef);
        if (hero.health - magicDmg < MIN_HEALTH) hero.health = MIN_HEALTH;
        else hero.health -= magicDmg;
    }
}
