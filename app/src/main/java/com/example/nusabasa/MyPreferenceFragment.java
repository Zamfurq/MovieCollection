package com.example.nusabasa;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceFragmentCompat;

public class MyPreferenceFragment extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle bundle, String s) {
        addPreferencesFromResource(R.xml.preference);
    }
}
