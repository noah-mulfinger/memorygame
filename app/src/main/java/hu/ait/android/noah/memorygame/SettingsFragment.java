package hu.ait.android.noah.memorygame;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.widget.Toast;

/**
 * Created by noah on 4/6/15.
 */
public class SettingsFragment extends PreferenceFragment
        implements SharedPreferences.OnSharedPreferenceChangeListener{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);

        EditTextPreference name = (EditTextPreference) findPreference("key_name");
        EditTextPreference age = (EditTextPreference) findPreference("key_age");
        name.setSummary(name.getText());
        age.setSummary(age.getText());



    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if(key.equals("key_name") ||
                key.equals("key_age")) {
            Preference pref = findPreference(key);
            pref.setSummary(sharedPreferences.getString(key,""));
        } else if (key.equals("key_gender")) {
            ListPreference pref = (ListPreference) findPreference(key);
            pref.setSummary(pref.getEntry().toString());
        }

        Toast.makeText(getActivity(),
                "Preferences changed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        getPreferenceScreen().getSharedPreferences()
                .registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        getPreferenceScreen().getSharedPreferences()
                .unregisterOnSharedPreferenceChangeListener(this);
    }
}

