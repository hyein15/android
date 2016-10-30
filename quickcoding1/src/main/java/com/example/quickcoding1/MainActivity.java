package com.example.quickcoding1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.lang.Comparable;

public class MainActivity extends AppCompatActivity {

    int[] num = {3, 7, 1, -1, 3, 4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.MIN).setOnClickListener(this);
        findViewById(R.id.AVE).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        TextView textView3 = (TextView) findViewById(R.id.textView3);
        switch (v.getId()) {
            case R.id.MIN:

                for(int i=0; i<num.length-1;i++)
                {
                    for(int j=0; j<num.length-1;j++ )
                    {
                        if(num[j] > num[j+1])
                        {
                            int temp = num[j+1];
                            num[j+1] = num[j];
                            num[j] = temp;
                        }
                    }
                }
                double res = num[0];
                String b =  String.valueOf(res);

                textView3.setText(b);
                break;

            case R.id.AVE:
                double sum = 0;
                for (int i = 0; i < num.length; i++)
                    sum += num[i];
                sum = sum / num.length;

                String a =  String.valueOf(sum);

                textView3.setText(a);
                break;
        }
    }
};







