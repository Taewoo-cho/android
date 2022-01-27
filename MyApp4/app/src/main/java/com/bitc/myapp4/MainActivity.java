package com.bitc.myapp4;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.text.TextRunShaper;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String num1, num2;
    Integer result, remain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("초간단 계산기");

        EditText editNum1 = (EditText) findViewById(R.id.Edit01);
        EditText editNum2 = (EditText) findViewById(R.id.Edit02);

        Button btnAdd = (Button) findViewById(R.id.btnAdd);
        Button btnSub = (Button) findViewById(R.id.btnSub);
        Button btnMul = (Button) findViewById(R.id.btnMul);
        Button btnDiv = (Button) findViewById(R.id.btnDiv);
        Button btnRemainder = (Button) findViewById(R.id.btnRemainder);

        TextView textResult = (TextView) findViewById(R.id.result);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = editNum1.getText().toString();
                num2 = editNum2.getText().toString();
                result = Integer.parseInt(num1) + Integer.parseInt(num2);
                textResult.setText("계산 결과 : " + result);
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                num1 = editNum1.getText().toString();
                num2 = editNum2.getText().toString();
                result = Integer.parseInt(num1) - Integer.parseInt(num2);
                textResult.setText("계산 결과 : " + result);
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                num1 = editNum1.getText().toString();
                num2 = editNum2.getText().toString();
                result = Integer.parseInt(num1) * Integer.parseInt(num2);
                textResult.setText("계산 결과 : " + result);
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                num1 = editNum1.getText().toString();
                num2 = editNum2.getText().toString();
                result = Integer.parseInt(num1) / Integer.parseInt(num2);
                textResult.setText("계산 결과 : " + result);
            }
        });

        btnRemainder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = editNum1.getText().toString();
                num2 = editNum2.getText().toString();
                result = Integer.parseInt(num1) / Integer.parseInt(num2);
                remain = Integer.parseInt(num1) % Integer.parseInt(num2);
                textResult.setText("계산 결과 : " + result + " 나머지 : " + remain);
            }
        });

    }
}