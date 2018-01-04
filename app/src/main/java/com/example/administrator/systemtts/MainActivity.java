package com.example.administrator.systemtts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SystemTTS systemTTS = SystemTTS.getInstance(getApplicationContext());
        systemTTS.playText("你好,世界，我是小白");
    }
}
