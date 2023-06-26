package com.gatikahome.androidhw1.myListeners;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class OnClickChengeSingButton implements View.OnClickListener {
    final private TextView displayText;

    public OnClickChengeSingButton(TextView displayText) {
        this.displayText = displayText;
    }

    @Override
    public void onClick(View view) {
        String val = displayText.getText().toString();
        if (val!=""){
          try{
              Double number = Double.parseDouble(val);
              if (number>0){
                  displayText.setText("-"+val);
              } else{
                  if(number!=0) displayText.setText(val.substring(1));
              }
          } catch (Exception e){
              displayText.setText("error");
              Log.e("Помилка при зміні знаку числа в OnClickChengeSingButton ",e.getMessage());
          }
        }

    }
}
