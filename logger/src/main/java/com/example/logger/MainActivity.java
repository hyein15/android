package com.example.logger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private GpsInfo gps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DBHelper dbHelper = new DBHelper(getApplicationContext(), "logger.db", null, 1);

        final TextView result = (TextView) findViewById(R.id.result);
        final EditText etDate = (EditText) findViewById(R.id.date);
        final EditText etContent = (EditText) findViewById(R.id.content);
        final EditText etLocation = (EditText) findViewById(R.id.location);

        // 현재 시간 구하기
        long now = System.currentTimeMillis();
        Date date = new Date(now);


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
        etDate.setText(simpleDateFormat.format(date));


        Button insert = (Button) findViewById(R.id.insert);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date = etDate.getText().toString();
                String item = etContent.getText().toString();
                String price = etLocation.getText().toString();

                dbHelper.insert(date, item, price);
                result.setText(dbHelper.getResult());

                etLocation.setText(null);
                etContent.setText(null);
            }
        });


        Button updataLocation = (Button) findViewById(R.id.updataLocation);
        updataLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                gps = new GpsInfo(MainActivity.this);
                // GPS 사용유무 가져오기
                if (gps.isGetLocation()) {

                    double latitude = gps.getLatitude();
                    double longitude = gps.getLongitude();

                    String a = "위도="+ String.valueOf(latitude)+ " 경도="+String.valueOf(longitude);

                    etLocation.setText(a);

                } else {
                    gps.showSettingsAlert();
                }


            }
        });


        Button delete = (Button) findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = etContent.getText().toString();

                dbHelper.delete(item);
                result.setText(dbHelper.getResult());
            }
        });
    }
}
