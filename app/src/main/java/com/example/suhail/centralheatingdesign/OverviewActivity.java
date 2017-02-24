package com.example.suhail.centralheatingdesign;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class OverviewActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);

        // Let 'back' button open the How Many Floors Activity
        Button loadHowManyFloorsActivity = (Button) findViewById(R.id.howManyFloorsButton);
        loadHowManyFloorsActivity.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OverviewActivity.this, HowManyFloorsActivity.class);
                startActivity(intent);
            } // onClick
        });

        // Let 'edit room' button open the Edit Room activity
        Button loadEditRoomActivity = (Button) findViewById(R.id.editRoomButton);
        loadEditRoomActivity.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OverviewActivity.this, EditRoomActivity.class);
                startActivity(intent);
            }
        });
    }
}