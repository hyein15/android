package com.example.quickcoding2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.Send).setOnClickListener(mClickListener);
        findViewById(R.id.BIGGER).setOnClickListener(mClickListener);
        findViewById(R.id.SMALLER).setOnClickListener(mClickListener);
        findViewById(R.id.BINGO).setOnClickListener(mClickListener);
    }

    int max = 100;
    int min = 0;
    int random=0;
    int cnt  =1;

    Button.OnClickListener mClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            EditText editText = (EditText) findViewById(R.id.editText);
            TextView Test = (TextView) findViewById(R.id.Test);
            TextView YourShow = (TextView) findViewById(R.id.YourShow);
            TextView  textView3 = (TextView) findViewById(R.id. textView3);

            switch (v.getId()) {
                case R.id.Send:
                    String res = editText.getText().toString();
                    //Test.setText(res);

                    random = (int)(Math.random()*(max-min+1))+min;
                    String a =  String.valueOf(random);
                    YourShow.setText(a);

                    break;

                case R.id.BIGGER:

                    min = random;

                    random = (min+max)/2;
                    String b =  String.valueOf(random);
                    YourShow.setText(b);
                    cnt++;
                    break;

                case R.id.SMALLER:

                    max = random;
                    random = (min+max)/2;
                    String c =  String.valueOf(random);
                    YourShow.setText(c);

                    cnt++;
                    break;

                case R.id.BINGO:

                    String d =  String.valueOf(cnt);
                    textView3.setText(d);

                    break;
            }
        }
    };




}

