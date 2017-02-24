package com.example.suhail.centralheatingdesign;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EditRoomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_room);
        // Orientation landscape
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        // Let 'back' button open the How Many Floors Activity
        Button loadOverviewActivity = (Button) findViewById(R.id.overviewButton);
        loadOverviewActivity.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EditRoomActivity.this, OverviewActivity.class);
                startActivity(intent);
            } // onClick
        });

    }
}
