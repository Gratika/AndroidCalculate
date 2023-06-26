package com.gatikahome.androidhw1.myListeners;

import android.view.View;
import android.widget.TextView;

import com.gatikahome.androidhw1.R;

public class OnClickClearButton implements View.OnClickListener {
    final private TextView displayText;
    final private TextView miniDisplayText;

    public OnClickClearButton(TextView displayText, TextView miniDisplayText) {
        this.displayText = displayText;
        this.miniDisplayText = miniDisplayText;
    }

    @Override
    public void onClick(View view) {
        String def_display_val =displayText.getResources().getString(R.string.display);
        this.displayText.setText(def_display_val);
        this.miniDisplayText.setText("");
    }
}
