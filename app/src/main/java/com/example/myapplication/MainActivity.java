package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.logfilter.PLog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PLog.v("SAMPLE","printing P Log");
        PLog.d("SAMPLE","printing P Log");
        PLog.i("SAMPLE","printing P Log");
        PLog.wtf("SAMPLE","printing P Log");
        PLog.w("SAMPLE","printing P Log");
        PLog.e("SAMPLE","printing P Log");
    }
}
