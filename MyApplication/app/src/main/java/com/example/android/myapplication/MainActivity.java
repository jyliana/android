package com.example.android.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button1;
    Button button2;
    Button button3;

    private static final String TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "найдем View элементы");
        textView = (TextView) findViewById(R.id.textView);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button1:
                        try {
                            int i = 6 / 0;
                            textView.setText("Результат деления = " + i);
                        } catch (Exception e) {
                            Log.d(TAG, "Делить на ноль нельзя", e);
                        }

                        Log.d(TAG, "Обработаем нажатие кнопки 1");
                        break;
                    case R.id.button2:
                        textView.setText(R.string.text2);
                        Toast toast = Toast.makeText(MainActivity.this, "Нажата кнопка 1", Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        LinearLayout toastImage=(LinearLayout) toast.getView();
                        ImageView imageView = new ImageView(MainActivity.this);
                        imageView.setImageResource(R.drawable.happy);
                        toastImage.addView(imageView);
                        toast.show();
                        Log.d(TAG, "Обработаем нажатие кнопки 2");
                        break;
                    case R.id.button3:
                        textView.setText(R.string.text3);
                        Log.d(TAG, "Обработаем нажатие кнопки 3");
                        break;
                }
            }
        };

        button1.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button3.setText(R.string.textButton);
            }
        });

    }

     /*   button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("Нажата кнопка 1");
            }
        });
        button2.setOnClickListener(this);
    }

    public void clickButton3(View view) {
        textView.setText("Нажата кнопка 3");
    }

    @Override
    public void onClick(View view) {
        textView.setText("Нажата кнопка 2");
    }*/
}
