
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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class EditRoomActivity extends AppCompatActivity {
    private ImageView img;
    private ViewGroup rootLayout;

    private int _xDelta;
    private int _yDelta;

    private LinearLayout boilerButton;
    private LinearLayout radiatorButton;
    private LinearLayout bedButton;
    private LinearLayout bedSideButton;
    private LinearLayout wardrobeButton;
    private LinearLayout horizontalLineButton;
    private LinearLayout verticalLineButton;
    private LinearLayout topLeftLineButton;
    private LinearLayout topRightLineButton;
    private LinearLayout bottomRightLineButton;
    private LinearLayout bottomLeftLineButton;
    private LinearLayout priceButton;
    private RelativeLayout editRoomRelativeLayout;
    private int finalPrice = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Orientation landscape
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_room);

        editRoomRelativeLayout = (RelativeLayout) findViewById(R.id.editRoomRelativeLayout);

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
            } // onClick
        }); //Radiator onClick

        // Click on bed field
        bedButton = (LinearLayout) findViewById(R.id.bedField);
        bedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView i = new ImageView(EditRoomActivity.this);
                i.setImageResource(R.drawable.bed);
                i.setLayoutParams(new LinearLayout.LayoutParams(150, 150));
                // Add this image to the relative border
                editRoomRelativeLayout.addView(i);
                i.setOnTouchListener(new ChoiceTouchListener());
            } // onClick
        }); //Radiator onClick

        // Click on bed field
        bedSideButton = (LinearLayout) findViewById(R.id.bedSideField);
        bedSideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView i = new ImageView(EditRoomActivity.this);
                i.setImageResource(R.drawable.bed_side);
                i.setLayoutParams(new LinearLayout.LayoutParams(150, 150));
                // Add this image to the relative border
                editRoomRelativeLayout.addView(i);
                i.setOnTouchListener(new ChoiceTouchListener());
            } // onClick
        }); //Radiator onClick

        // Click on wardrobe field
        wardrobeButton = (LinearLayout) findViewById(R.id.wardrobeField);
        wardrobeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView i = new ImageView(EditRoomActivity.this);
                i.setImageResource(R.drawable.wardrobe);
                i.setLayoutParams(new LinearLayout.LayoutParams(150, 150));
                // Add this image to the relative border
                editRoomRelativeLayout.addView(i);
                i.setOnTouchListener(new ChoiceTouchListener());
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
            } // onClick
        });  //bottom left onClick





        // priceField
        priceButton = (LinearLayout) findViewById(R.id.priceField);
        priceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTxt = (EditText) findViewById(R.id.priceEditText);
                TextView i = new TextView(EditRoomActivity.this);
                // Update final price
                String value= editTxt.getText().toString();
                finalPrice = (Integer.parseInt(value) + finalPrice);
                i.setText(Integer.toString(finalPrice));
                i.setLayoutParams(new RelativeLayout.LayoutParams(150,150));
                i.setOnTouchListener(new ChoiceTouchListener());
                editRoomRelativeLayout.addView(i);
                editTxt.setText("");
            }
        });

        rootLayout = (ViewGroup) findViewById(R.id.activity_edit_room);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(150, 150);
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
}//EditRoomActivity