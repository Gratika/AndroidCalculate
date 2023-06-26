package com.gatikahome.androidhw1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.gatikahome.androidhw1.myListeners.OnClickChengeSingButton;
import com.gatikahome.androidhw1.myListeners.OnClickClearButton;
import com.gatikahome.androidhw1.myListeners.OnClickDotButton;
import com.gatikahome.androidhw1.myListeners.OnClickNumberButton;
import com.gatikahome.androidhw1.myListeners.OnClickOperationButton;

import java.util.Stack;

public class CalcActivity extends AppCompatActivity {
    TextView dislayText;
    TextView miniDisplayText;
    Stack<String> stack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        dislayText = (TextView) findViewById(R.id.display);
        miniDisplayText = (TextView) findViewById(R.id.mini_display);
        stack=new Stack<>();
        //встановлюю слухача події OnClick для цифрових кнопок
        findViewById(R.id.btn_0).setOnClickListener(new OnClickNumberButton(dislayText));
        findViewById(R.id.btn_1).setOnClickListener(new OnClickNumberButton(dislayText));
        findViewById(R.id.btn_2).setOnClickListener(new OnClickNumberButton(dislayText));
        findViewById(R.id.btn_3).setOnClickListener(new OnClickNumberButton(dislayText));
        findViewById(R.id.btn_4).setOnClickListener(new OnClickNumberButton(dislayText));
        findViewById(R.id.btn_5).setOnClickListener(new OnClickNumberButton(dislayText));
        findViewById(R.id.btn_6).setOnClickListener(new OnClickNumberButton(dislayText));
        findViewById(R.id.btn_7).setOnClickListener(new OnClickNumberButton(dislayText));
        findViewById(R.id.btn_8).setOnClickListener(new OnClickNumberButton(dislayText));
        findViewById(R.id.btn_9).setOnClickListener(new OnClickNumberButton(dislayText));
        //встановлюю слухача події OnClick для кнопки з "."
        findViewById(R.id.btn_dot).setOnClickListener(new OnClickDotButton(dislayText));
        //встановлюю слухача події OnClick для кнопки, що очищує екран
        findViewById(R.id.btn_c).setOnClickListener(new OnClickClearButton(dislayText, miniDisplayText));
        //встановлюю слухача події OnClick для кнопки, що змінює знак числа
        findViewById(R.id.btn_plus_minus).setOnClickListener(new OnClickChengeSingButton(dislayText));
        //встановлюю слухача події OnClick для кнопок з математичними операціями
        findViewById(R.id.btn_plus).setOnClickListener(new OnClickOperationButton(dislayText, miniDisplayText, stack));
        findViewById(R.id.btn_minus).setOnClickListener(new OnClickOperationButton(dislayText, miniDisplayText, stack));
        findViewById(R.id.btn_multiplication).setOnClickListener(new OnClickOperationButton(dislayText, miniDisplayText, stack));
        findViewById(R.id.btn_division).setOnClickListener(new OnClickOperationButton(dislayText, miniDisplayText, stack));
        findViewById(R.id.btn_equal).setOnClickListener(new OnClickOperationButton(dislayText, miniDisplayText, stack));
        findViewById(R.id.btn_rate).setOnClickListener(new OnClickOperationButton(dislayText, miniDisplayText, stack));

    }
}