package seaBattle;

public enum GameObject {
    FOUR_DECK_SHIP(4, "🛥", 1), THREE_DECK_SHIP(3, "🛥", 1),
    TWO_DECK_SHIP(2, "🛥", 1), ONE_DECK_SHIP(1, "🛥", 1),
    EMPTY(-1, "⬜", -1), HALO(0, "▩", -1), DAMAGE(-1, "🟥", 5);


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
