
package com.example.suhail.centralheatingdesign;

import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.view.ScaleGestureDetector;


public class EditRoomActivity extends AppCompatActivity {
    private ImageView img;
    private ViewGroup rootLayout;

    private int _xDelta;
    private int _yDelta;

    int numberOfBoilers = 0;
    int numberOfRadiators = 0;

    private LinearLayout boilerButton;
    private LinearLayout radiatorButton;
    private LinearLayout horizontalLineButton;
    private LinearLayout verticalLineButton;
    private LinearLayout topLeftLineButton;
    private LinearLayout topRightLineButton;
    private LinearLayout bottomRightLineButton;
    private LinearLayout bottomLeftLineButton;
    private RelativeLayout editRoomRelativeLayout;

    ImageView circleImage;
    private ScaleGestureDetector scaleGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Orientation landscape
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_room);

        // Let 'tips' button open the tips dialogue
        Button loadTipsDialogue = (Button) findViewById(R.id.tipsDialogue);
        loadTipsDialogue.setOnClickListener(new View.OnClickListener() {

            String tip1 = "Tip 1: Select the appliances you want in the room";
            String tip2 = "Tip 2: Place them where you want them in the room";
            String tip3 = "Tip 3: Join them up using the pipes available";
            String tip4 = "Tip 4: If circle is red, it means something is wrong";
            String tip5 = "Tip 5: If circle is green, everything seems right";
            String tip6 = "Tip 6: Screenshot your room to your device";

            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(EditRoomActivity.this);
                dialog.setCancelable(false);
                dialog.setTitle("Tips");
                dialog.setMessage(tip1 +"\n"+ tip2 +"\n"+ tip3 +"\n"+ tip4 +"\n"+ tip5 +"\n"+ tip6);
                dialog.setNeutralButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        //Action for "Delete".
                    }
                });
                final AlertDialog alert = dialog.create();
                alert.show();
            }
        }); //Tips onClick

        editRoomRelativeLayout = (RelativeLayout) findViewById(R.id.editRoomRelativeLayout);
        circleImage = (ImageView) findViewById(R.id.imageView);
//        scaleGestureDetector = new ScaleGestureDetector(this, new MySimpleOnScaleGestureListener(myImage));

        // Click on boiler field
        boilerButton = (LinearLayout) findViewById(R.id.boilerField);
        boilerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView i = new ImageView(EditRoomActivity.this);
                i.setImageResource(R.drawable.boiler);
                i.setLayoutParams(new LinearLayout.LayoutParams(150, 150));
                // Add this image to the relative border
                editRoomRelativeLayout.addView(i);
                i.setOnTouchListener(new ChoiceTouchListener());
                // Make this image scalable
                scaleGestureDetector =  new ScaleGestureDetector(getApplicationContext(),new MySimpleOnScaleGestureListener(i));
                numberOfBoilers ++;
                ConstraintChecker(numberOfBoilers,numberOfRadiators);
            }
        }); //Boiler onClick

        // Click on radiator field
        radiatorButton = (LinearLayout) findViewById(R.id.radiatorField);
        radiatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView i = new ImageView(EditRoomActivity.this);
                i.setImageResource(R.drawable.radiator);
                i.setLayoutParams(new LinearLayout.LayoutParams(150, 150));
                // Add this image to the relative border
                editRoomRelativeLayout.addView(i);
                i.setOnTouchListener(new ChoiceTouchListener());
                // Make this image scalable
                scaleGestureDetector =  new ScaleGestureDetector(getApplicationContext(),new MySimpleOnScaleGestureListener(i));
                numberOfRadiators ++;
                ConstraintChecker(numberOfBoilers,numberOfRadiators);
            } // onClick
        }); //Radiator onClick

        // Click on horizontal line field
        horizontalLineButton = (LinearLayout) findViewById(R.id.horizontalLineField);
        horizontalLineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView i = new ImageView(EditRoomActivity.this);
                i.setImageResource(R.drawable.horizontal_line);
                i.setLayoutParams(new LinearLayout.LayoutParams(150, 150));
                // Add this image to the relative border
                editRoomRelativeLayout.addView(i);
                i.setOnTouchListener(new ChoiceTouchListener());
                // Make this image scalable
                scaleGestureDetector =  new ScaleGestureDetector(getApplicationContext(),new MySimpleOnScaleGestureListener(i));
            } // onClick
        }); //Horizontal onClick

        // Click on vertical line field
        verticalLineButton = (LinearLayout) findViewById(R.id.verticalLineField);
        verticalLineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView i = new ImageView(EditRoomActivity.this);
                i.setImageResource(R.drawable.vertical_line);
                i.setLayoutParams(new LinearLayout.LayoutParams(150, 150));
                // Add this image to the relative border
                editRoomRelativeLayout.addView(i);
                i.setOnTouchListener(new ChoiceTouchListener());
                // Make this image scalable
                scaleGestureDetector =  new ScaleGestureDetector(getApplicationContext(),new MySimpleOnScaleGestureListener(i));
            } // onClick
        }); //vertical line onClick

        // Click on top left line field
        topLeftLineButton = (LinearLayout) findViewById(R.id.topLeftLineField);
        topLeftLineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView i = new ImageView(EditRoomActivity.this);
                i.setImageResource(R.drawable.top_left);
                i.setLayoutParams(new LinearLayout.LayoutParams(150, 150));
                // Add this image to the relative border
                editRoomRelativeLayout.addView(i);
                i.setOnTouchListener(new ChoiceTouchListener());
                // Make this image scalable
                scaleGestureDetector =  new ScaleGestureDetector(getApplicationContext(),new MySimpleOnScaleGestureListener(i));
            } // onClick
        }); //top left onClick

        // Click on top right line field
        topRightLineButton = (LinearLayout) findViewById(R.id.topRightLineField);
        topRightLineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView i = new ImageView(EditRoomActivity.this);
                i.setImageResource(R.drawable.top_right);
                i.setLayoutParams(new LinearLayout.LayoutParams(150, 150));
                // Add this image to the relative border
                editRoomRelativeLayout.addView(i);
                i.setOnTouchListener(new ChoiceTouchListener());
                // Make this image scalable
                scaleGestureDetector =  new ScaleGestureDetector(getApplicationContext(),new MySimpleOnScaleGestureListener(i));
            } // onClick
        }); //top right onClick

        // Click on bottom right line field
        bottomRightLineButton = (LinearLayout) findViewById(R.id.bottomRightLineField);
        bottomRightLineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView i = new ImageView(EditRoomActivity.this);
                i.setImageResource(R.drawable.bottom_right);
                i.setLayoutParams(new LinearLayout.LayoutParams(150, 150));
                // Add this image to the relative border
                editRoomRelativeLayout.addView(i);
                i.setOnTouchListener(new ChoiceTouchListener());
                // Make this image scalable
                scaleGestureDetector =  new ScaleGestureDetector(getApplicationContext(),new MySimpleOnScaleGestureListener(i));
            }
        }); //bottom right onClick

        // Click on bottom left line field
        bottomLeftLineButton = (LinearLayout) findViewById(R.id.bottomLeftLineField);
        bottomLeftLineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView i = new ImageView(EditRoomActivity.this);
                i.setImageResource(R.drawable.bottom_left);
                i.setLayoutParams(new LinearLayout.LayoutParams(150, 150));
                // Add this image to the relative border
                editRoomRelativeLayout.addView(i);
                i.setOnTouchListener(new ChoiceTouchListener());
                // Make this image scalable
                scaleGestureDetector =  new ScaleGestureDetector(getApplicationContext(),new MySimpleOnScaleGestureListener(i));
            } // onClick
        });  //bottom left onClick

        rootLayout = (ViewGroup) findViewById(R.id.activity_edit_room);
        img = (ImageView) rootLayout.findViewById(R.id.imageView);

        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(150, 150);
        img.setLayoutParams(layoutParams);
        img.setOnTouchListener(new ChoiceTouchListener());
    } // onCreate

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        scaleGestureDetector.onTouchEvent(event);
//        return true;
        return super.onTouchEvent(event);
    } // onTouchEvent

    private class MySimpleOnScaleGestureListener
            extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        ImageView viewMyImage;
        float factor;

        public MySimpleOnScaleGestureListener(ImageView iv) {
            super();
            viewMyImage = iv;
        } // MySimpleOnScaleGestureListener

        @Override
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            factor = 1.0f;
            return true;
            //return super.onScaleBegin(detector);
        } // onScaleBegin

        @Override
        public boolean onScale(ScaleGestureDetector detector) {

            float scaleFactor = detector.getScaleFactor() - 1;
            factor += scaleFactor;
            viewMyImage.setScaleX(factor);
            viewMyImage.setScaleY(factor);
            return true;
            //return super.onScale(detector);
        } // onScale
    } // MySimpleOnScaleGestureListener

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
                    if (lParams.topMargin < 0) {
                        lParams.topMargin = 0;
                        view.setLayoutParams(layoutParams);
                        return true;
                    }
                    // Set boundary for left margin
                    else if (lParams.leftMargin < 0) {
                        lParams.leftMargin = 0;
                        view.setLayoutParams(layoutParams);
                        return true;
                    }
                    else if (lParams.leftMargin < 0 && lParams.topMargin < 0) {
                        lParams.leftMargin = 0;
                        lParams.topMargin = 0;
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

    // Method to check whether the constraints have been met
    // Changes Picture red/green according to conditions met
    private void ConstraintChecker(int numberOfBoilers, int numberOfRadiators){
        if((numberOfBoilers>=1) && (numberOfRadiators>=1)){
            circleImage.setImageResource(R.drawable.circle_green);
        }
        else{
            circleImage.setImageResource(R.drawable.circle_red);
        }
    }
}//EditRoomActivity