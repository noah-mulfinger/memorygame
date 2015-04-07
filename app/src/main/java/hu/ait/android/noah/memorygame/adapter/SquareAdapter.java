package hu.ait.android.noah.memorygame.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import hu.ait.android.noah.memorygame.GameActivity;
import hu.ait.android.noah.memorygame.R;
import hu.ait.android.noah.memorygame.data.Square;
import hu.ait.android.noah.memorygame.view.GameView;

/**
 * Created by noah on 4/3/15.
 */
public class SquareAdapter extends BaseAdapter {


    public enum Difficulty {
        EASY(0, 4),
        MEDIUM(1, 5),
        HARD(2, 6);


        private int value;
        private int rowSize;


        private Difficulty(int value, int rowSize) {
            this.value = value;
            this.rowSize = rowSize;
        }

        public static Difficulty fromInt(int value) {
            for (Difficulty d : Difficulty.values()) {
                if (d.value == value) {
                    return d;
                }
            }
            return EASY;
        }

        public int getRowSize() {
            return rowSize;
        }

        public int getValue() {
            return value;
        }

        public int getTotalSquares() {
            int total = getRowSize()*getRowSize();
            if (getRowSize() == MEDIUM.getRowSize()) {
                total+=getRowSize();
            }
            return total;
        }
    }




    private Context context;
    private List<Square> squares;
    private int firstPick = -1;
    private boolean pickedFirstSquare = false;
    private boolean canPress = true;
    private boolean firstClick = true;
    private int numMatches = 0;
    private Difficulty difficulty;
    private long startTime;
    private long finishTime;

    public SquareAdapter(Context context, List<Square> squares, Difficulty difficulty) {
        this.squares = squares;
        this.context = context;
        this.difficulty = difficulty;
        Toast.makeText(context, difficulty.getRowSize()+"", Toast.LENGTH_LONG).show();

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < difficulty.getTotalSquares() / 2; i++) {
            list.add(i);
            list.add(i);
        }
        Collections.shuffle(list);

        for(int i = 0; i < difficulty.getTotalSquares(); i++) {
            squares.add(new Square(
                    Square.SquareType.fromInt(list.get(i))));
        }
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
        if (firstClick) {
            startTime = System.currentTimeMillis();
            firstClick = false;
        }
        if(!canPress || squares.get(position).isRevealed()) {
            return;
        }

        squares.get(position).revealSquare();
        squares.get(position).requireAnim();
        notifyDataSetChanged();

        if (pickedFirstSquare) {
            if (squares.get(firstPick).getSquareType() ==
                            squares.get(position).getSquareType()) {
                //Toast.makeText(context, "Match", Toast.LENGTH_SHORT).show();
                pickedFirstSquare = false;

                ((GameActivity)context).increaseProgress();
                numMatches++;
                if (numMatches == difficulty.getTotalSquares()/2) {
                    finishTime = System.currentTimeMillis() - startTime;
                    Toast.makeText(context, finishTime + "", Toast.LENGTH_LONG).show();
                }
            } else {
                //Toast.makeText(context, "No match", Toast.LENGTH_SHORT).show();
                pickedFirstSquare = false;
                canPress = false;
                resetPicks(firstPick, position);
            }
        } else {
            firstPick = position;
            pickedFirstSquare = true;
        }

    }

    public void resetPicks(final int first, final int second) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                squares.get(first).hideSquare();
                squares.get(first).requireAnim();
                squares.get(second).hideSquare();
                squares.get(second).requireAnim();

                Log.d("tag_", "does reset picks");
                canPress = true;
                notifyDataSetChanged();
            }
        }, 500);

    }


    static class ViewHolder {
        ImageView image;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        if (v == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            v = inflater.inflate(R.layout.square, null);
            ViewHolder holder = new ViewHolder();
            holder.image = (ImageView) v.findViewById(R.id.image);
            v.setTag(holder);
        }

        final Square square = squares.get(position);
        if (square != null) {
            ViewHolder holder = (ViewHolder) v.getTag();

            if (!square.isRevealed()) {
                holder.image.setImageResource(R.drawable.black);
            } else {
                holder.image.setImageResource(
                        square.getSquareType().getIconId());

            }




//            final ViewFlipper flipper = (ViewFlipper) v.findViewById(R.id.view_flipper);
//                    if (flipper.getDisplayedChild() == 0) {
//                        Log.d("tag_", "displayed child is 0");
////                        flipper.setInAnimation(context, R.anim.card_flip_left_in);
////                        flipper.setOutAnimation(context, R.anim.card_flip_right_out);
//                        flipper.showNext();
//                    } else if (flipper.getDisplayedChild() == 1) {
////                        flipper.setInAnimation(context, R.anim.card_flip_right_in);
////                        flipper.setOutAnimation(context, R.anim.card_flip_left_out);
//                        flipper.showPrevious();
//                    }



        }



        return v;
    }
}