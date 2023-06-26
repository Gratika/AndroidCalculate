package com.gatikahome.androidhw1.myListeners;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.gatikahome.androidhw1.R;

import java.util.Stack;

public class OnClickOperationButton implements View.OnClickListener {
    final private TextView displayText;
    final private  TextView miniDisplay;
    final private Stack<String> stack;

    public OnClickOperationButton(TextView editText, TextView miniDisplay, Stack <String> stack){

        this.displayText=editText;
        this.miniDisplay = miniDisplay;
        this.stack= stack;
    }
    @Override
    public void onClick(View view) {
        String operation = ((TextView)view).getText().toString();
        String num2 = displayText.getText().toString();
        if(!"%".equals(operation)) miniDisplay.setText(miniDisplay.getText()+num2+operation);
        try{
            switch ( operation){
                case "+":
                case "-": onClickPlusOrMinusButton(num2, operation); break;
                case "*":
                case "/": onClickMultiplicationOrDivision(num2, operation); break;
                case "=":onClickEqualsButton(num2); break;
                case "%":onClickPersentButton(num2); break;
                default:return;
            }
        }catch (Exception e){
            displayText.setText("error");
            Log.e("помилка при обчисленні: ",e.getMessage());
        }

    }
    private void onClickPersentButton(String num2){
        if(num2!="" && num2!="0"){
            double number = Double.parseDouble(num2);
            String oldOperation = this.stack.peek();
            double result;
            if("*".equals(oldOperation)||"/".equals(oldOperation)){
                result = number/100;
            }
            else{
                this.stack.pop();
                double num1 = Double.parseDouble(this.stack.peek());
                 result = num1*number/100;
                 this.stack.push(oldOperation);

            }
            displayText.setText(String.valueOf(result));
        }



    }
    private void  onClickEqualsButton(String num2){
        double result = doCalculation(num2);
        displayText.setText(String.valueOf(result));


    }

    private void onClickMultiplicationOrDivision(String num2, String operation){
        if(num2!=""){
            pushStack(num2,operation);
        }
    }
    private void onClickPlusOrMinusButton(String num2, String operation){

        if(num2!=""){
            num2 = String.valueOf(doCalculation(num2));
            pushStack(num2,operation);
        }
    }
    private void pushStack(String num2, String operation){
        this.stack.push(num2);
        this.stack.push(operation);
        String def_display_val =displayText.getResources().getString(R.string.display);
        displayText.setText(def_display_val);
    }
    private double doCalculation(String num2){
        double result = Double.parseDouble(num2);
        while(!this.stack.isEmpty()){
            String operation = this.stack.pop();
            double num1 = Double.parseDouble(this.stack.pop());
            result = doOperation(operation,num1,result);
        }
        return result;
    }

    private double doOperation(String oldOperation, double number1, double number2) {

            double result;
            switch (oldOperation){
                case "+": result=number1+number2; break;
                case "-": result=number1-number2;break;
                case "*": result=number1*number2;break;
                case "/": result=number1/number2;break;
                default:result=number1+number2;break;
            }
            return result;
    }
}
