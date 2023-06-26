package com.gatikahome.androidhw1.myListeners;

import android.view.View;
import android.widget.TextView;

import com.gatikahome.androidhw1.R;

public class OnClickNumberButton implements View.OnClickListener{
    final private TextView displayText;

    public OnClickNumberButton(TextView displayText) {
        this.displayText = displayText;
    }

    @Override
    public void onClick(View view) {
        String val = displayText.getText().toString();
        String num = ((TextView)view).getText().toString();
        String def_display_val =displayText.getResources().getString(R.string.display);

        if (val==def_display_val){
                val = num;
        }else {
            val = val + num;
        }
        displayText.setText(val);

    }
}
