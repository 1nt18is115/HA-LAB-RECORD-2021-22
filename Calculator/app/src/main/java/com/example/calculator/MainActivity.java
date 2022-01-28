package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView display;
    String number;
    String operand1, operand2;
    String operation;
    boolean isNewOp = true;
    double result = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);
    }

    public void numberEvent(View view) {
        if(isNewOp)
            display.setText("");
        isNewOp = false;
        number = display.getText().toString();

        switch (view.getId()) {
            case R.id.button0: number += "0";   break;
            case R.id.button1: number += "1";   break;
            case R.id.button2: number += "2";   break;
            case R.id.button3: number += "3";   break;
            case R.id.button4: number += "4";   break;
            case R.id.button5: number += "5";   break;
            case R.id.button6: number += "6";   break;
            case R.id.button7: number += "7";   break;
            case R.id.button8: number += "8";   break;
            case R.id.button9: number += "9";   break;
        }
        display.setText(number);
    }

    public void operatorEvent(View view) {
        isNewOp = true;
        operand1 = display.getText().toString();

        switch (view.getId()) {
            case R.id.buttonAdd: operation = "+";   break;
            case R.id.buttonSub: operation = "-";   break;
            case R.id.buttonMul: operation = "*";   break;
            case R.id.buttonDiv: operation = "/";   break;
        }
    }

    public void equalEvent(View view) {
        operand2 = display.getText().toString();

        switch (operation) {
            case "+": result = Double.parseDouble(operand1) + Double.parseDouble(operand2); break;
            case "-": result = Double.parseDouble(operand1) - Double.parseDouble(operand2); break;
            case "*": result = Double.parseDouble(operand1) * Double.parseDouble(operand2); break;
            case "/": result = Double.parseDouble(operand1) / Double.parseDouble(operand2); break;
        }
        display.setText(result + "");
    }

    public void clearEvent(View view) {
        display.setText("0");
        isNewOp = true;
    }
}