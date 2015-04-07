package hu.ait.android.noah.memorygame;

import android.app.Fragment;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import hu.ait.android.noah.memorygame.adapter.SquareAdapter;
import hu.ait.android.noah.memorygame.data.Square;
import hu.ait.android.noah.memorygame.view.GameView;


public class GameActivity extends ActionBarActivity {


    private ProgressBar progressBar;
    private GameFragment gameFragment;
    private int difficulty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        difficulty = (int)getIntent().getExtras().get("key_difficulty");


//        if (savedInstanceState == null) {
//            getFragmentManager()
//                    .beginTransaction()
//                    .add(R.
//
// id.container, new CardFrontFragment())
//                    .commit();
//        }

       showFragment(GameFragment.TAG);

        progressBar = (ProgressBar) findViewById(R.id.progress);
        progressBar.setMax(SquareAdapter.Difficulty.fromInt(difficulty).getTotalSquares()/2);
        progressBar.setProgress(0);


    }

    private void showFragment(String fragmentTag) {
        if (GameFragment.TAG.equals(fragmentTag)) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            gameFragment = new GameFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("key_difficulty", difficulty);
            gameFragment.setArguments(bundle);

            fragmentTransaction.replace(R.id.layoutContainer, gameFragment, GameFragment.TAG);

            fragmentTransaction.commit();
        }
    }





    public void increaseProgress() {
        progressBar.incrementProgressBy(1);
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

//    public void flipCard() {
//        if (showingBack) {
//            getFragmentManager().popBackStack();
//            return;
//        }
//
//        // Flip to the back.
//
//        showingBack = true;
//
//        // Create and commit a new fragment transaction that adds the fragment for the back of
//        // the card, uses custom animations, and is part of the fragment manager's back stack.
//
//        getFragmentManager()
//                .beginTransaction()
//
//                        // Replace the default fragment animations with animator resources representing
//                        // rotations when switching to the back of the card, as well as animator
//                        // resources representing rotations when flipping back to the front (e.g. when
//                        // the system Back button is pressed).
//                .setCustomAnimations(
//                        R.anim.card_flip_right_in, R.anim.card_flip_right_out,
//                        R.anim.card_flip_left_in, R.anim.card_flip_left_out)
//
//                        // Replace any fragments currently in the container view with a fragment
//                        // representing the next page (indicated by the just-incremented currentPage
//                        // variable).
//                .replace(R.id.container, new CardBackFragment())
//
//                        // Add this transaction to the back stack, allowing users to press Back
//                        // to get to the front of the card.
//                .addToBackStack(null)
//
//                        // Commit the transaction.
//                .commit();
//    }


    public static class CardFrontFragment extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return inflater.inflate(R.layout.square_hidden, container, false);
        }
    }

    public static class CardBackFragment extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            return inflater.inflate(R.layout.square, container, false);
        }
    }
}
