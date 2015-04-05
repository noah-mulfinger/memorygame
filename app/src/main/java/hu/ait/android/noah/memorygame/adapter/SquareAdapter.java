package hu.ait.android.noah.memorygame.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import hu.ait.android.noah.memorygame.R;
import hu.ait.android.noah.memorygame.data.Square;

/**
 * Created by noah on 4/3/15.
 */
public class SquareAdapter extends BaseAdapter {
    private Context context;
    private List<Square> squares;

    public SquareAdapter(Context context, List<Square> squares) {
        this.context = context;
        this.squares = squares;
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

    static class ViewHolder {
        ImageView ivIcon;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        if (v == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            v = inflater.inflate(R.layout.square, null);
            ViewHolder holder = new ViewHolder();
            holder.ivIcon = (ImageView) v.findViewById(R.id.ivIcon);
            v.setTag(holder);
        }






        final Square square = squares.get(position);
        if (square != null) {
            ViewHolder holder = (ViewHolder) v.getTag();
            if (!square.isRevealed()) {
                Log.d("tag_debug", "drawing black");
                holder.ivIcon.setImageResource(R.drawable.black);
            } else {
                holder.ivIcon.setImageResource(
                        square.getSquareType().getIconId());
                Log.d("tag_debug", "drawing type");
            }

        }
        return v;
    }


}