package hu.ait.android.noah.memorygame.data;

import com.orm.SugarRecord;

import java.io.Serializable;
import java.util.Date;

import hu.ait.android.noah.memorygame.adapter.SquareAdapter;

/**
 * Created by noah on 4/7/15.
 */
public class Score extends SugarRecord<Score> implements Serializable {

    private SquareAdapter.Difficulty difficulty;
    private long score;
    private Date date;

    private Score() {

    }

    private Score(SquareAdapter.Difficulty difficulty,
                  long score, Date date) {
        this.difficulty = difficulty;
        this.score = score;
        this.date = date;
    }


}
