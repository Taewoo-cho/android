package com.bitc.myapp4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        setTitle("애완동물 사진보기");

        CheckBox chkAgree = findViewById(R.id.chkAgree);
        TextView text1 = findViewById(R.id.text1);

        TextView text2 = findViewById(R.id.text2);
        RadioGroup rGroup = findViewById(R.id.rGroup);
        RadioButton rBtnDog = findViewById(R.id.rBtnDog);
        RadioButton rBtnCat = findViewById(R.id.rBtnCat);
        RadioButton rBtnRabbit = findViewById(R.id.rBtnRabbit);

        Button btnOk = findViewById(R.id.btnOk);
        ImageView imgPet = findViewById(R.id.imgPet);

        chkAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(chkAgree.isChecked() == true) {
                    text2.setVisibility(View.VISIBLE);
                    rGroup.setVisibility(View.VISIBLE);
                    btnOk.setVisibility(View.VISIBLE);
                    imgPet.setVisibility(View.VISIBLE);
                } else {
                    text2.setVisibility(View.INVISIBLE);
                    rGroup.setVisibility(View.INVISIBLE);
                    btnOk.setVisibility(View.INVISIBLE);
                    imgPet.setVisibility(View.INVISIBLE);
                }
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                switch(rGroup.getCheckedRadioButtonId()) {
                    case R.id.rBtnDog:
                        imgPet.setImageResource(R.drawable.img_dog);
                        break;
                    case R.id.rBtnCat:
                        imgPet.setImageResource(R.drawable.img_cat);
                        break;
                    case R.id.rBtnRabbit:
                        imgPet.setImageResource(R.drawable.img_rabbit);
                        break;
                }
            }
        });



    }
}
