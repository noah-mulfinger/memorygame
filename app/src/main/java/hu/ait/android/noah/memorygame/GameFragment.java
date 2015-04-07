package hu.ait.android.noah.memorygame;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

import hu.ait.android.noah.memorygame.adapter.SquareAdapter;
import hu.ait.android.noah.memorygame.data.Square;

/**
 * Created by noah on 4/6/15.
 */
public class GameFragment extends Fragment {

    public static final String TAG = "GameFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_game, container, false);

        int difficultyValue = getArguments().getInt("key_difficulty");
        SquareAdapter.Difficulty difficulty =
                SquareAdapter.Difficulty.fromInt(difficultyValue);

        final GridView gridView = (GridView) rootView.findViewById(R.id.gridView);

        gridView.setColumnWidth(gridView.getWidth() /
                difficulty.getRowSize());
        gridView.setNumColumns(
                difficulty.getRowSize());
        gridView.setAdapter(new SquareAdapter(getActivity(),
                new ArrayList<Square>(),
                difficulty));


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ((SquareAdapter)gridView.getAdapter()).handleItemClick(position);
                //flipCard();
            }
        });

        return rootView;
    }
}
