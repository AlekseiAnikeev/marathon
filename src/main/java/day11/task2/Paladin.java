package day11.task2;

public class Paladin extends Hero implements Healer {

    public Paladin() {
        physDef = 0.5;
        magicDef = 0.2;
        physAtt = 15;
    }

    @Override
    public void healHimself() {
        if (health + PALADIN_SELF_HEALTH > MAX_HEALTH) health = MAX_HEALTH;
        else health += PALADIN_SELF_HEALTH;
    }

    @Override
    public void healTeammate(Hero hero) {
        if (hero.health + PALADIN_OTHER_HEALTH > MAX_HEALTH) hero.health = MAX_HEALTH;
        else hero.health += PALADIN_OTHER_HEALTH;
    }

    @Override
    public String toString() {
        return "Paladin{" +
                "health=" + health +
                '}';
    }
}
