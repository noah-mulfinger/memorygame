package hu.ait.android.noah.memorygame;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import hu.ait.android.noah.memorygame.adapter.SquareAdapter;
import hu.ait.android.noah.memorygame.data.Square;


public class GameActivity extends ActionBarActivity {


    private int previousPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        final List<Square> squares = new ArrayList<>();

        Random random = new Random();

        for(int i = 0; i < 16; i++) {
            squares.add(new Square(
                    Square.SquareType.fromInt(random.nextInt(2))));
        }

        final GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setColumnWidth(gridview.getWidth() / 4);
        gridview.setNumColumns(4);
        gridview.setAdapter(new SquareAdapter(this, squares));


        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                ((Square) gridview.getAdapter().
                        getItem(position)).setRevealed(true);
                ((SquareAdapter)gridview.getAdapter()).
                        notifyDataSetChanged();

                if (previousPosition != -1) {
                    if (((Square) gridview.getAdapter().
                            getItem(previousPosition)).getSquareType()
                            == ((Square) gridview.getAdapter().
                            getItem(position)).getSquareType()) {
                        Toast.makeText(GameActivity.this, "Match",
                                Toast.LENGTH_SHORT).show();
                        previousPosition = -1;
                        Log.d("tag_", "match");
                    } else {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        ((Square) gridview.getAdapter().
                                getItem(position)).setRevealed(false);
                        ((Square) gridview.getAdapter().
                                getItem(previousPosition)).setRevealed(false);


                        Toast.makeText(GameActivity.this, "No match",
                                Toast.LENGTH_SHORT).show();
                        previousPosition = -1;

                    }

                } else {
                    previousPosition = position;

                }

                ((SquareAdapter)gridview.getAdapter()).
                        notifyDataSetChanged();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
