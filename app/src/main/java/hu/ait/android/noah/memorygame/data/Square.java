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
        YELLOW(7, R.drawable.yellow),
        GREENOUTLINE(8, R.drawable.green_outline),
        ORANGEOUTLINE(9, R.drawable.orange_outline),
        REDOUTLINE(10, R.drawable.red_outline),
        BLUEOUTLINE(11, R.drawable.blue_outline),
        PINKOUTLINE(12, R.drawable.pink_outline),
        PURPLEOUTLINE(13, R.drawable.purple_outline),
        BROWNOUTLINE(14, R.drawable.brown_outline),
        YELLOWOUTLINE(15, R.drawable.yellow_outline),
        GREENBLUE(16, R.drawable.green_blue),
        YELLOWRED(17, R.drawable.yellow_red);


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
    private boolean animate = false;

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

    public void requireAnim() {
        animate = true;
    }

    public void noAnimRequired() {
        animate = false;
    }

    public boolean needsAnimation() {
        return animate;
    }
}