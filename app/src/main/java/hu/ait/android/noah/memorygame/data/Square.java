package hu.ait.android.noah.memorygame.data;

import hu.ait.android.noah.memorygame.R;

/**
 * Created by noah on 4/5/15.
 */
public class Square {


    public enum SquareType {
        GREEN(0, R.drawable.green),
        ORANGE(1, R.drawable.orange),
        RED(2, R.drawable.red),
        BLUE(3, R.drawable.blue),
        PINK(4, R.drawable.pink),
        PURPLE(5, R.drawable.purple),
        BROWN(6, R.drawable.brown),
        YELLOW(7, R.drawable.yellow);

        private int value;
        private int iconId;

        private SquareType(int value, int iconId) {
            this.value = value;
            this.iconId = iconId;
        }

        public static SquareType fromInt(int value) {
            for (SquareType p : SquareType.values()) {
                if (p.value == value) {
                    return p;
                }
            }
            return GREEN;
        }


        public int getIconId() {
            return iconId;
        }

        public int getValue() {
            return value;
        }
    }

    private SquareType squareType;
    private boolean revealed = false;

    public Square(SquareType squareType) {
        this.squareType = squareType;
    }

    public SquareType getSquareType() {
        return squareType;
    }

    public void setSquareType(SquareType squareType) {
        this.squareType = squareType;
    }

    public void revealSquare() {
        revealed = true;
    }

    public void hideSquare() {
        revealed = false;
    }

    public boolean isRevealed() {
        return revealed;
    }
}