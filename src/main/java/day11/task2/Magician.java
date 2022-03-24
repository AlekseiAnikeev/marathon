package day11.task2;

public class Magician extends Hero implements MagicAttack {

    public Magician() {
        magicAtt = 20;
        physAtt = 5;
        magicDef = 0.8;
        physDef = 0;
    }

    @Override
    public void magicalAttack(Hero hero) {
        double magicDmg = magicAtt * (1 - hero.magicDef);
        if (hero.health - magicDmg < MIN_HEALTH) hero.health = MIN_HEALTH;
        else hero.health -= magicDmg;
    }

    @Override
    public String toString() {
        return "Magician{" +
                "health=" + health +
                '}';
    }
}
