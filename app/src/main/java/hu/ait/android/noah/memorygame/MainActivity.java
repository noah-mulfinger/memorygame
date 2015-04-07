package hu.ait.android.noah.memorygame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.ListPreference;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DialerFilter;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    TextView welcomeMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);

        welcomeMessage = (TextView) findViewById(R.id.welcomeMessage);

        Button btnNewGame = (Button) findViewById(R.id.btnNewGame);
        btnNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDifficultyFragment();
                Toast.makeText(MainActivity.this, "Click", Toast.LENGTH_LONG).show();

            }
        });

        Button btnSettings = (Button) findViewById(R.id.btnSettings);
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSettings = new Intent();
                intentSettings.setClass(MainActivity.this,
                        SettingsActivity.class);
                startActivity(intentSettings);
            }
        });

        Button btnTutorial = (Button) findViewById(R.id.btnTutorial);
        btnTutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTutorial = new Intent();
                intentTutorial.setClass(MainActivity.this,
                        TutorialActivity.class);
                startActivity(intentTutorial);
            }
        });

    }

    private void showDifficultyFragment() {
        DifficultyFragment difficultyFragment = new DifficultyFragment();
        difficultyFragment.show(getSupportFragmentManager(), DifficultyFragment.TAG);

//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        DifficultyFragment difficultyFragment = new DifficultyFragment();
//        fragmentTransaction.replace(R.id.menuLayoutContainer,
//                difficultyFragment, DifficultyFragment.TAG);
//        fragmentTransaction.addToBackStack(null);
//        fragmentTransaction.commit();
//        difficultyFragment.show(fragmentManager, DifficultyFragment.TAG);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        String name = sp.getString("key_name", "");
        welcomeMessage.setText("Welcome, "+name);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
