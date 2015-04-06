package hu.ait.android.noah.memorygame.view;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import hu.ait.android.noah.memorygame.R;
import hu.ait.android.noah.memorygame.adapter.SquareAdapter;
import hu.ait.android.noah.memorygame.data.Square;
import hu.ait.android.noah.memorygame.model.GameModel;

/**
 * Created by noah on 4/5/15.
 */
public class GameView extends GridView {

    public GameView(final Context context, AttributeSet attrs) {
        super(context, attrs);

//        setColumnWidth(getWidth() / 4);
//        setNumColumns(4);
//        setAdapter(new SquareAdapter(context, new ArrayList<Square>()));
//
//
//        setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                ((SquareAdapter)getAdapter()).handleItemClick(position);
//            }
//        });


    }




}
