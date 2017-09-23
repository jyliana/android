package com.example.android.myapplication2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox chb1, chb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chb1 = (CheckBox) findViewById(R.id.checkBox);
        chb2 = (CheckBox) findViewById(R.id.checkBox2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
       /* MenuItem action_mail = menu.findItem(R.id.action_mail);
        if (chb2.isChecked()) {
            action_mail.setVisible(true);
        } else action_mail.setVisible(false);*/

        menu.setGroupVisible(R.id.group1, chb1.isChecked());
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        chb2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MenuItem action_mail = menu.findItem(R.id.action_mail);
                if (chb2.isChecked()) {
                    action_mail.setVisible(true);
                } else action_mail.setVisible(false);
            }
        });
        menu.add(2, 4, 4, "item4").setCheckable(true);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.action_settings:
                Toast.makeText(MainActivity.this, getString(R.string.action_settings), Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_item1:
                Toast.makeText(MainActivity.this, getString(R.string.action_item1), Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_item2:
                Toast.makeText(MainActivity.this, getString(R.string.action_item2), Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_item3:
                Toast.makeText(MainActivity.this, getString(R.string.action_item3), Toast.LENGTH_SHORT).show();
                break;
            case 4:
                item.setChecked(!item.isChecked());
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
