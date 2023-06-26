package com.gatikahome.androidhw1.myListeners;

import android.view.View;
import android.widget.TextView;

import com.gatikahome.androidhw1.R;

public class OnClickDotButton implements View.OnClickListener{
    final private TextView displayText;

    public OnClickDotButton(TextView displayText) {
        this.displayText = displayText;
    }

    @Override
    public void onClick(View view) {
        String val = displayText.getText().toString();
        String num = ((TextView)view).getText().toString();

        if(val!=""){
            val=val+num;
            displayText.setText(val);

        }

    }
}
