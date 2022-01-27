package com.bitc.myapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//  버튼태그를 자바와 연동하기 위해 사용
    Button button1;
    Button button2;

    //  app 의 시작점
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//      activity_main.xml 파일과 연동
        setContentView(R.layout.activity_main);

//      findViewById() : id를 기반으로 해당 ui를 찾음
//      R 클래스 : res폴더를 뜻함, 안드로이드의 resource 부분
        button1 = (Button) findViewById(R.id.btn1);
//      setOnClickListener() : 버튼 객체에 클릭 이벤트 리스너를 설정
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              Toast : 안드로이드의 간단한 알림창
//              show() : 화면에 Toast 메세지를 화면에 출력
                Toast.makeText(MainActivity.this, "버튼1을 눌렀습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        button2 = (Button) findViewById(R.id.btn2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "버튼2을 눌렀습니다.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}