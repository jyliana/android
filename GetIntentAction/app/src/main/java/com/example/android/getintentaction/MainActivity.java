package com.example.android.getintentaction;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnTime=(Button) findViewById(R.id.button_time);
        Button btnDate=(Button) findViewById(R.id.button_date);

        btnTime.setOnClickListener(this);
        btnDate.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent;

        switch (view.getId()){
            case R.id.button_time:
                intent=new Intent("intent.action.time");
                startActivity(intent);
                break;
            case R.id.button_date:
                intent=new Intent("intent.action.date");
                startActivity(intent);
                break;
        }

    }
}
