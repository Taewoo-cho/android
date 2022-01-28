package com.bitc.myapp0302;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity3 extends AppCompatActivity {

    int selectYear, selectMonth, selectDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        setTitle("시간 예약");

        Chronometer chronometer1 = findViewById(R.id.chronometer1);

        Button btnStart = findViewById(R.id.btnStart);
        Button btnEnd = findViewById(R.id.btnEnd);

        RadioButton rdoCal = findViewById(R.id.rdoCal);
        RadioButton rdoTime = findViewById(R.id.rdoTime);

        CalendarView calendarView1 = findViewById(R.id.calendarView1);

        TimePicker timePicker1 = findViewById(R.id.timePicker1);

        TextView tvYear = findViewById(R.id.tvYear);
        TextView tvMonth = findViewById(R.id.tvMonth);
        TextView tvDay = findViewById(R.id.tvDay);

        TextView tvHour = findViewById(R.id.tvHour);
        TextView tvMin = findViewById(R.id.tvMin);

        timePicker1.setVisibility((View.INVISIBLE));
        calendarView1.setVisibility(View.INVISIBLE);

        rdoCal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                timePicker1.setVisibility(View.INVISIBLE);
                calendarView1.setVisibility(View.VISIBLE);
            }
        });

        rdoTime.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                timePicker1.setVisibility(View.VISIBLE);
                calendarView1.setVisibility(View.INVISIBLE);
            }
        });

        btnStart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                chronometer1.setBase(SystemClock.elapsedRealtime());
                chronometer1.start();
                chronometer1.setTextColor(Color.RED);
            }
        });

        btnEnd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                chronometer1.stop();
                chronometer1.setTextColor(Color.BLUE);

                tvYear.setText(Integer.toString(selectYear));
                tvMonth.setText(Integer.toString(selectMonth));
                tvDay.setText(Integer.toString(selectDay));

                tvHour.setText(Integer.toString(timePicker1.getCurrentHour()));
                tvMin.setText(Integer.toString(timePicker1.getCurrentMinute()));
            }
        });

        calendarView1.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int year, int month, int dayOfMonth) {
                selectYear = year;
                selectMonth = month +1 ; // 0~11 까지 출력
                selectDay = dayOfMonth;
            }
        });
    }
}