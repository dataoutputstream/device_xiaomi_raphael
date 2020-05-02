/*
 * Copyright (C) 2018 The LineageOS Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.lineageos.settings.popupcamera;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.preference.Preference;
import androidx.preference.Preference.OnPreferenceChangeListener;
import androidx.preference.PreferenceFragment;
 import androidx.preference.SwitchPreference;

import org.lineageos.settings.R;


 import com.android.internal.util.custom.popupcamera.PopUpCameraUtils;
 
public class PopupCameraSettingsFragment extends PreferenceFragment implements OnPreferenceChangeListener {

    
    private static final String PREF_POPUP_LED = "popup_led_effect";
    private SwitchPreference mPopupLed;



    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.popup_settings);
        getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
        mPopupLed = (SwitchPreference) findPreference(PREF_POPUP_LED);
        mPopupLed.setOnPreferenceChangeListener(this);
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        switch (preference.getKey()) {
            case PREF_POPUP_LED:
                PopUpCameraUtils.setLedEnabled(getActivity(), (Boolean) newValue);
                return true;
            default: return false;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            getActivity().onBackPressed();
            return true;
        }
        return false;
    }
}
