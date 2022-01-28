package com.bitc.myapp0302;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        String[] items = {"CSI-뉴욕", "CSI-라스베가스", "CSI-마이애미", "Friends", "Fringe", "Lost"};

        AutoCompleteTextView auto = findViewById(R.id.actv1);
        ArrayAdapter<String> adapter
                = new ArrayAdapter<String>(MainActivity4.this,
                android.R.layout.simple_dropdown_item_1line, items);
        auto.setAdapter(adapter);


        MultiAutoCompleteTextView multiAuto = findViewById(R.id.mactv);
        MultiAutoCompleteTextView.CommaTokenizer token = new MultiAutoCompleteTextView.CommaTokenizer();
        multiAuto.setTokenizer((token));
        multiAuto.setAdapter(adapter);

    }
}