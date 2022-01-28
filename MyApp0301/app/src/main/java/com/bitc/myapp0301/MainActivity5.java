package com.bitc.myapp0301;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity5 extends AppCompatActivity {

    String num1, num2, sign = "";
    Integer result;
    Button[] numButtons = new Button[10];
    Integer[] numBtnIDs = {R.id.btn00, R.id.btn01, R.id.btn02, R.id.btn03, R.id.btn04,
            R.id.btn05, R.id.btn06, R.id.btn07, R.id.btn08, R.id.btn09};
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        setTitle("계산기");

        EditText edit01 = findViewById(R.id.edit01);
        edit01.setInputType(0); // 터치키보드 호출 금지
        EditText edit02 = findViewById(R.id.edit02);
        edit02.setInputType(0); // 터치키보드 호출 금지

        TextView textResult = findViewById(R.id.textResult);

        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnSub = findViewById(R.id.btnSub);
        Button btnMul = findViewById(R.id.btnMul);
        Button btnDiv = findViewById(R.id.btnDiv);
        Button btnResult = findViewById(R.id.btnResult);

        btnAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                sign = "+";
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                sign = "-";
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                sign = "*";
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                sign = "/";
            }
        });

        btnResult.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                num1 = edit01.getText().toString();
                num2 = edit02.getText().toString();
                // 각 필요 칸이 비어있는지 체크
                if(num1.matches("") || num2.matches("") || sign.matches("")) {
                    Toast.makeText(getApplicationContext(),
                            "숫자와 기호를 입력해주세요", Toast.LENGTH_SHORT).show();
                } else {
                    switch (sign) {
                        case "+":
                            result = Integer.parseInt(num1) + Integer.parseInt(num2);
                            break;
                        case "-":
                            result = Integer.parseInt(num1) - Integer.parseInt(num2);
                            break;
                        case "*":
                            result = Integer.parseInt(num1) * Integer.parseInt(num2);
                            break;
                        case "/":
                            result = Integer.parseInt(num1) / Integer.parseInt(num2);
                            break;
                    }
                    textResult.setText("계산결과 : " + result);
                    edit01.setText("");
                    edit02.setText("");
                    sign = "";
                }
            }
        });

//      각 숫자 버튼의 id 등록
        for(i = 0; i< numBtnIDs.length; i++) {
            numButtons[i] = (Button) findViewById(numBtnIDs[i]);
        }

//      각 숫자 버튼의 이벤트 등록
        for( i = 0; i < numBtnIDs.length; i++) {
            final int index;    // 내부 규칙으로 인해 final 사용
            index = i;

            numButtons[index].setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if(edit01.isFocused() == true) {
                        num1 = edit01.getText().toString() + numButtons[index].getText().toString();
                        edit01.setText(num1);
                    } else if(edit02.isFocused() == true) {
                        num2 = edit02.getText().toString() + numButtons[index].getText().toString();
                        edit02.setText(num2);
                    } else {
                        Toast.makeText(getApplicationContext(),
                                "먼저 에디트텍스트를 선택하세요", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}