package hu.ait.android.noah.memorygame.data;

import hu.ait.android.noah.memorygame.R;

/**
 * Created by noah on 4/5/15.
 */
public class Square {


    public enum SquareType {
        BLACK(-1, R.drawable.black),
        GREEN(0, R.drawable.green),
        ORANGE(1, R.drawable.orange);

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

    public void setRevealed(boolean revealed) {
        this.revealed = revealed;
    }

    public boolean isRevealed() {
        return revealed;
    }
}