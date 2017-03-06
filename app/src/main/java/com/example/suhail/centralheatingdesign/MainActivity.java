package com.example.suhail.centralheatingdesign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Let 'begin' button open the How Many Floors activity
        Button loadHowManyFloorsActivity = (Button) findViewById(R.id.beginButton);
        loadHowManyFloorsActivity.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, HowManyFloorsActivity.class);
                Intent intent = new Intent(MainActivity.this, EditRoomActivity.class);
                startActivity(intent);
            }
        });
    }
}