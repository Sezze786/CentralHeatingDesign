package com.example.suhail.centralheatingdesign;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class EditRoomActivity extends AppCompatActivity {

    private ImageView img;
    private ViewGroup rootLayout;
    private int _xDelta;
    private int _yDelta;
    private LinearLayout boilerButton;
    private LinearLayout radiatorButton;
    private LinearLayout horizontalLineButton;
    private RelativeLayout editRoomRelativeLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Orientation landscape
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_room);

        editRoomRelativeLayout = (RelativeLayout) findViewById(R.id.editRoomRelativeLayout);

        // Click on boiler field
        boilerButton = (LinearLayout) findViewById(R.id.boilerField);
        boilerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView i = new ImageView(EditRoomActivity.this);
                i.setImageResource(R.drawable.boiler);
                i.setLayoutParams(new LinearLayout.LayoutParams(150, 150));
                // Add this image to the relative layout
                editRoomRelativeLayout.addView(i);
                i.setOnTouchListener(new ChoiceTouchListener());
            } // onClick
        });

        // Click on radiator field
        radiatorButton = (LinearLayout) findViewById(R.id.radiatorField);
        radiatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView i = new ImageView(EditRoomActivity.this);
                i.setImageResource(R.drawable.radiator);
                i.setLayoutParams(new LinearLayout.LayoutParams(150, 150));
                // Add this image to the relative layout
                editRoomRelativeLayout.addView(i);
                i.setOnTouchListener(new ChoiceTouchListener());
            } // onClick
        });

        // Click on horizontal line field
        horizontalLineButton = (LinearLayout) findViewById(R.id.horizontalLineField);
        horizontalLineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView i = new ImageView(EditRoomActivity.this);
                i.setImageResource(R.drawable.horizontal_line);
                i.setLayoutParams(new LinearLayout.LayoutParams(150, 150));
                // Add this image to the relative layout
                editRoomRelativeLayout.addView(i);
                i.setOnTouchListener(new ChoiceTouchListener());
            } // onClick
        });


        rootLayout = (ViewGroup) findViewById(R.id.activity_edit_room);
        img = (ImageView) rootLayout.findViewById(R.id.imageView);

        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(150, 150);
        img.setLayoutParams(layoutParams);
        img.setOnTouchListener(new ChoiceTouchListener());
    } // onCreate


    // This method moves the image about
    private final class ChoiceTouchListener implements OnTouchListener {
        public boolean onTouch(View view, MotionEvent event) {
            final int X = (int) event.getRawX();
            final int Y = (int) event.getRawY();
            RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            switch (event.getAction() & MotionEvent.ACTION_MASK) {
                case MotionEvent.ACTION_DOWN:
                    _xDelta = X - lParams.leftMargin;
                    _yDelta = Y - lParams.topMargin;
                    break;
                case MotionEvent.ACTION_UP:
                    break;
                case MotionEvent.ACTION_POINTER_DOWN:
                    view.setLayoutParams(lParams);
                    break;
                case MotionEvent.ACTION_POINTER_UP:
                    view.setLayoutParams(lParams);
                    break;
                case MotionEvent.ACTION_MOVE:
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view
                            .getLayoutParams();
                    layoutParams.leftMargin = X - _xDelta;
                    layoutParams.topMargin = Y - _yDelta;
                    // Set boundary for top margin
                    if(lParams.topMargin < 0) {
                        lParams.topMargin = 0;
                        view.setLayoutParams(layoutParams);
                        return true;
                    }
                    // Set boundary for left margin
                    else if(lParams.leftMargin < 0) {
                        lParams.leftMargin = 0;
                        view.setLayoutParams(layoutParams);
                        return true;
                    }
                    view.setLayoutParams(layoutParams);
                    break;
            } // switch
            rootLayout.invalidate();
            return true;
        } // onTouch
    } // ChoiceTouchListener
}//EditRoomActivity








