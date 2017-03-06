package com.example.suhail.centralheatingdesign;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;


public class HowManyFloorsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner numberOfFloorsSpinner;
    private LinearLayout linearLayout;
    private int numberOfFloors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_many_floors);

        numberOfFloorsSpinner = (Spinner) findViewById(R.id.howManyFloorsSpinner);
        linearLayout = (LinearLayout) findViewById(R.id.linearLayoutHowManyFloors);
        numberOfFloorsSpinner.setOnItemSelectedListener(this);

        // Let 'back' button open the main activity
        Button loadMainActivity = (Button) findViewById(R.id.mainButton);
        loadMainActivity.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HowManyFloorsActivity.this, MainActivity.class);
                startActivity(intent);
            } // onClick
        });

        // Let 'next' button open the overview activity
        Button loadOverviewActivity = (Button) findViewById(R.id.overviewButton);
        loadOverviewActivity.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HowManyFloorsActivity.this, OverviewActivity.class);
                startActivity(intent);
            } // onClick
        });
    } // onCreate

    @SuppressLint("SetTextI18n")
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        textView.setText(numberOfFloorsSpinner.getSelectedItem().toString());
        float weight = (float) 0.5;

        // Delete all layouts except the Spinner and text box border
        removeDynamicLayouts();

        // How many floors do we want
        numberOfFloors = Integer.parseInt(numberOfFloorsSpinner.getSelectedItem().toString());
        // Create i amount of layouts
        for (int i = 1; i <= numberOfFloors; i++) {
            LinearLayout ll = new LinearLayout(this);
            ll.setOrientation(LinearLayout.VERTICAL);
            ll.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, weight));
            ll.setId(i);
            linearLayout.addView(ll);
            // Add Floor i text
            TextView tx1 = new TextView(this);
            tx1.setText("Floor " + Integer.toString(i));
            ll.addView(tx1);
            // Add 'add a room' button
            Button addRoom = new Button(this);
            ll.addView(addRoom);
            addRoom.setText("Add Room");
        } // for
    } // onItemSelected



    private void removeDynamicLayouts(){
        for(int i = 1; i <= 4; i++)
        {
            LinearLayout ll = (LinearLayout) findViewById(i);
            if(ll != null)
                linearLayout.removeView(ll);
        }
    } // removeDynamicLayouts

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
} // HowManyFloorsActivity
