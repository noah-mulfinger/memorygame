package hu.ait.android.noah.memorygame.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import hu.ait.android.noah.memorygame.data.Square;

/**
 * Created by noah on 4/5/15.
 */
public class GameModel {

    private static GameModel instance = null;

    private List<Square> squares;

    private GameModel() {
        squares = new ArrayList<>();


    }

    public List<Square> getSquares() {
        return  squares;
    }

    public static GameModel getInstance() {
        if (instance == null) {
            instance = new GameModel();
        }
        return instance;
    }

    public static void destroyInstance() {
        instance = null;
    }
}
