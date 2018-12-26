package com.example.administrator.systemtts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etWords, etPitch, etSpeech;
    private Button btnPlay;
    private SystemTTS systemTTS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initData();

        initListener();
    }

    private void initView() {
        etWords = (EditText) findViewById(R.id.et_word);
        etPitch = (EditText) findViewById(R.id.et_pitch);
        etSpeech = (EditText) findViewById(R.id.et_speech);
        btnPlay = (Button) findViewById(R.id.btn_play);
    }


    private void initData() {
        systemTTS = SystemTTS.getInstance(this);
    }


    private void initListener() {
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String words = getWords();
                if (!TextUtils.isEmpty(words)) {
                    systemTTS.play(words);
                }
            }
        });
    }


    private String getWords() {
        return etWords.getText().toString().trim();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        systemTTS.destroy();
    }
}
