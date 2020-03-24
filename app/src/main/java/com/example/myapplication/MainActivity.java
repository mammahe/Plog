package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;

import com.example.logfilter.PLog;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PLog.v("P Log V");
        PLog.d("P Log D");
        PLog.i("P Log I");
        PLog.w("P Log W");
        PLog.e("P Log E");
    }
}
