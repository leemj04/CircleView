package com.example.bottom;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    private CircleView circleView;
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        circleView = findViewById(R.id.circleView);
        seekBar = findViewById(R.id.seekBar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // SeekBar의 값에 따라 레벨 변경
                circleView.setLevel(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // 터치가 시작될 때 호출 (필요 시 구현)
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // 터치가 멈췄을 때 호출 (필요 시 구현)
            }
        });
    }
}