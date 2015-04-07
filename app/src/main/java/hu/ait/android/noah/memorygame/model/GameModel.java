package hu.ait.android.noah.memorygame.model;

import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import hu.ait.android.noah.memorygame.GameActivity;
import hu.ait.android.noah.memorygame.data.Square;

/**
 * Created by noah on 4/5/15.
 */
public class GameModel {

    private static GameModel instance = null;

    private List<Square> squares;

    private GameModel() {
        squares = new ArrayList<>();

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            list.add(i);
            list.add(i);
        }
        Collections.shuffle(list);

        for(int i = 0; i < 16; i++) {
            squares.add(new Square(
                    Square.SquareType.fromInt(list.get(i))));
        }


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

    public int getCount() {
        return squares.size();
    }

    public Square getItem(int position) {
        return squares.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public void handleItemClick(int position) {
//        if(!canPress || squares.get(position).isRevealed()) {
//            return;
//        }
//
//        squares.get(position).revealSquare();
//        notifyDataSetChanged();
//
//        if (pickedFirstSquare) {
//            if (squares.get(firstPick).getSquareType() ==
//                    squares.get(position).getSquareType()) {
//                Toast.makeText(context, "Match", Toast.LENGTH_SHORT).show();
//                pickedFirstSquare = false;
//
//                ((GameActivity)context).increaseProgress();
//            } else {
//                Toast.makeText(context, "No match", Toast.LENGTH_SHORT).show();
//                pickedFirstSquare = false;
//                canPress = false;
//                resetPicks(firstPick, position);
//            }
//        } else {
//            firstPick = position;
//            pickedFirstSquare = true;
//        }

    }

    public void resetPicks(final int first, final int second) {
//        Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            public void run() {
//                squares.get(first).hideSquare();
//                squares.get(second).hideSquare();
//
//                Log.d("tag_", "does reset picks");
//                canPress = true;
//                notifyDataSetChanged();
//            }
//        }, 1000);

    }


}
