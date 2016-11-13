package com.example.quickcoding5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static ArrayList<String> arr_str = new ArrayList<>();
    static ArrayList<Integer> arr_num = new ArrayList<>();
    Button send;
    Button complete;
    TextView str_view;
    TextView num_view;
    EditText edit_text;
    String print_str="";
    String print_num="";
    int cnt_str=0;
    int cnt_num=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        send = (Button)findViewById(R.id.send);
        complete =  (Button)findViewById(R.id.complete);

        str_view = (TextView) findViewById(R.id.show_str);
        num_view = (TextView) findViewById(R.id.show_num);
        edit_text = (EditText) findViewById(R.id.editText);

    }

    public void send(View v) {

        String edit_str = String.valueOf(edit_text.getText());

        try{

           int temp = Integer.parseInt(edit_str);
            arr_num.add(temp);

            cnt_num++;
            edit_text.setText(null);

        }catch(NumberFormatException e){
            arr_str.add(edit_str);

            cnt_str++;
            edit_text.setText(null);

        }

    }

    public void complete(View v) {

        print_str="";
        print_num="";

        for(int i=0; i<cnt_str; i++)
        {
           print_str += arr_str.get(i);
            print_str +=",";
        }

        for(int i=0; i<cnt_num; i++)
        {
            print_num += arr_num.get(i);
            print_num +=",";

        }

        str_view.setText(print_str);
        num_view.setText(print_num);

    }

    }

