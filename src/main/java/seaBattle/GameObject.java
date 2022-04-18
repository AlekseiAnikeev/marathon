package seaBattle;

/**
 * @author Aleksey Anikeev aka AgentChe
 * Date of creation: 04.04.2022
 */

public enum GameObject {
    FOUR_DECK_SHIP(4, "🟩", 1), THREE_DECK_SHIP(3, "🟩", 1),
    TWO_DECK_SHIP(2, "🟩", 1), ONE_DECK_SHIP(1, "🟩", 1),
    EMPTY(-1, "🟦", -1), HALO(0, "🟪", 6), DAMAGE(-1, "🟥", 5),
    ZERO(0,"0  ", 5), ONE(0,"1 ", 5), TWO(0,"2 ", 5),
    THREE(0,"3 ", 5), FOUR(0,"4  ", 5), FIVE(0,"5 ", 5),
    SIX(0,"6 ", 5), SEVEN(0,"7 ", 5), EIGHT(0,"8 ", 5),
    NINE(0,"9", 5);


    private final int value;
    private final String texture;
    private final int meaning;

    GameObject(int value, String texture, int meaning) {
        this.value = value;
        this.texture = texture;
        this.meaning = meaning;

    }

    public int getValue() {
        return value;
    }

    public String getTexture() {
        return texture;
    }

    public int getMeaning() {
        return meaning;
    }
}
