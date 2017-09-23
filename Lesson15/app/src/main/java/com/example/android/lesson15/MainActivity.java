package com.example.android.lesson15;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvColor, tvSize;
    final int MENU_COLOR_RED = 1;
    final int MENU_COLOR_GREEN = 2;
    final int MENU_COLOR_BLUE = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvColor = (TextView) findViewById(R.id.tvColor);
        tvSize = (TextView) findViewById(R.id.tvSize);

        registerForContextMenu(tvColor);
        registerForContextMenu(tvSize);
    }
}
