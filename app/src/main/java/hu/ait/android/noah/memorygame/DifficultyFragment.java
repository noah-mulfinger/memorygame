package hu.ait.android.noah.memorygame;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;

/**
 * Created by noah on 4/6/15.
 */
public class DifficultyFragment extends DialogFragment {

    private int selectedDifficulty = 0;
    public static final String TAG = "DifficultyFragment";


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Select Difficulty");
        builder.setSingleChoiceItems(R.array.difficulty_levels, -1,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        selectedDifficulty = which;
                    }
                });

        builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), ""+selectedDifficulty,
                        Toast.LENGTH_LONG).show();
                Intent intentNewGame = new Intent();
                intentNewGame.setClass(getActivity(), GameActivity.class);
                intentNewGame.putExtra("key_difficulty", selectedDifficulty);
                startActivity(intentNewGame);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        return builder.create();
    }
}
