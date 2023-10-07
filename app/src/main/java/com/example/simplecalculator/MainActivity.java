package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.google.android.material.button.MaterialButton;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;


public class MainActivity extends AppCompatActivity {


    private TextView inputDisplay, outputDisplay;

    String data;
    boolean checkbracket=false;
    private MaterialButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9,
            buttonDot, buttonAdd, buttonSub, buttonMultiply, buttonDivide, buttonPercent, buttonClear, buttonbracket, buttonEqual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputDisplay = findViewById(R.id.input);
        outputDisplay = findViewById(R.id.output);
        button0 = findViewById(R.id.btn0);
        button1 = findViewById(R.id.btn1);
        button2 = findViewById(R.id.btn2);
        button3 = findViewById(R.id.btn3);
        button4 = findViewById(R.id.btn4);
        button5 = findViewById(R.id.btn5);
        button6 = findViewById(R.id.btn6);
        button7 = findViewById(R.id.btn7);
        button8 = findViewById(R.id.btn8);
        button9 = findViewById(R.id.btn9);
        buttonAdd = findViewById(R.id.add);
        buttonSub = findViewById(R.id.subtract);
        buttonDivide = findViewById(R.id.division);
        buttonDot = findViewById(R.id.btnPoint);
        buttonMultiply = findViewById(R.id.multiply);
        buttonClear = findViewById(R.id.clear);
        buttonbracket = findViewById(R.id.bracket);
        buttonEqual = findViewById(R.id.equal);
        buttonPercent = findViewById(R.id.percent);
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputDisplay.getText().toString();
                inputDisplay.setText(data + "0");
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputDisplay.getText().toString();
                inputDisplay.setText(data + "1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputDisplay.getText().toString();
                inputDisplay.setText(data + "2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputDisplay.getText().toString();
                inputDisplay.setText(data + "3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputDisplay.getText().toString();
                inputDisplay.setText(data + "4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputDisplay.getText().toString();
                inputDisplay.setText(data + "5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputDisplay.getText().toString();
                inputDisplay.setText(data + "6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputDisplay.getText().toString();
                inputDisplay.setText(data + "7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputDisplay.getText().toString();
                inputDisplay.setText(data + "8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputDisplay.getText().toString();
                inputDisplay.setText(data + "9");
            }
        });
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputDisplay.getText().toString();
                inputDisplay.setText(data + "+");
            }
        });
        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputDisplay.getText().toString();
                inputDisplay.setText(data + "-");

            }
        });
        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputDisplay.getText().toString();
                inputDisplay.setText(data + "x");

            }
        });
        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputDisplay.getText().toString();
                inputDisplay.setText(data + "÷");

            }
        });
        buttonPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputDisplay.getText().toString();
                inputDisplay.setText(data + "%");


            }
        });
        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputDisplay.getText().toString();
                inputDisplay.setText(data + ".");

            }
        });
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisplay.setText("");
                outputDisplay.setText("");

            }

        });
        buttonbracket.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {

                if (checkbracket){
                    data=inputDisplay.getText().toString();
                    inputDisplay.setText(data + ")");
                    checkbracket = false;
                }
                else{
                    data=inputDisplay.getText().toString();
                    inputDisplay.setText(data + "(");
                    checkbracket = true;
                }



            }
        });
        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = inputDisplay.getText().toString();

                data = data.replace("x","*");
                data = data.replace("%","/100");
                data = data.replace("÷","/");

                Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);
                String finalResult="";
                Scriptable scriptable = rhino.initStandardObjects();
                finalResult=rhino.evaluateString(scriptable,data,"Javascript",1,null).toString();

                outputDisplay.setText(finalResult);
            }
        });
    }


    }
