package hu.ait.android.noah.memorygame.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import hu.ait.android.noah.memorygame.TutorialFragmentOne;
import hu.ait.android.noah.memorygame.TutorialFragmentThree;
import hu.ait.android.noah.memorygame.TutorialFragmentTwo;

/**
 * Created by noah on 4/7/15.
 */
public class TutorialAdapter extends FragmentPagerAdapter {

    public TutorialAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new TutorialFragmentOne();
            case 1:
                return new TutorialFragmentTwo();
            case 2:
                return new TutorialFragmentThree();
            default:
                return new TutorialFragmentOne();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
