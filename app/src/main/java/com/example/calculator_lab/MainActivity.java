package com.example.calculator_lab;

import org.mariuszgromada.math.mxparser.*;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display= findViewById(R.id.display);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            display.setShowSoftInputOnFocus(false); //hides the input thing making it possible to use buttons
        }

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getString(R.string.display).equals(display.getText().toString())){
                    display.setText("");
                }
            }
        });
    }

    private void updateStr(String newStr){

        String oldStr = display.getText().toString();
        int cursor = display.getSelectionStart();
        String left = oldStr.substring(0, cursor);
        String right = oldStr.substring(cursor);

        if(getString(R.string.display).equals(display.getText().toString())){
            display.setText(newStr);
        }
        else{
            display.setText(String.format("%s%s%s", left, newStr, right));
        }
        display.setSelection(cursor + 1);


    }

    public void zero(View v){
        updateStr("0");
    }

    public void one(View v){
        updateStr("1");
    }
    public void two(View v){
        updateStr("2");
    }
    public void three(View v){
        updateStr("3");
    }
    public void four(View v){
        updateStr("4");
    }
    public void five(View v){
        updateStr("5");
    }
    public void six(View v){
        updateStr("6");
    }
    public void seven(View v){
        updateStr("7");
    }
    public void eight(View v){
        updateStr("8");
    }
    public void nine(View v){
        updateStr("9");
    }
    public void clear(View v){
        display.setText("");
    }

    public void ac(View v){
        display.setText("");
    }

    public void mod(View v){
        updateStr("%");
    }

    public void div(View v){
        updateStr("/");
    }

    public void mult(View v){
        updateStr("x");
    }

    public void sub(View v){
        updateStr("-");
    }

    public void add(View v){
        updateStr("+");
    }

    public void equals(View v){
        String myStr = display.getText().toString();

        myStr = myStr.replace("x", "*");

        Expression exp = new Expression(myStr);
        String result = String.valueOf(exp.calculate()); //grabs in the result in a string result. Result is calculated using built-in calculate function of mxparser.

        display.setText(result);
        display.setSelection(result.length()); // places the cursor at the end of the answer
    }

    public void dot(View v){
        updateStr(".");
    }
    public void backSpace(View v){
        int  cursor = display.getSelectionStart();
        int len = display.getText().length();

        if(cursor != 0 && len != 0){
            SpannableStringBuilder select = (SpannableStringBuilder) display.getText();
            select.replace(cursor -1 , cursor, "");
            display.setText(select);
            display.setSelection(cursor - 1);
        }
    }


}