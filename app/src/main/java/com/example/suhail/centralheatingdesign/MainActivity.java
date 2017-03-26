package com.example.suhail.centralheatingdesign;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth.AuthStateListener authListener;
    FirebaseAuth auth = FirebaseAuth.getInstance();

    @Override
    protected void onStart() {
        super.onStart();
        auth.addAuthStateListener(authListener);
    } // onStart

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button signOut = (Button) findViewById(R.id.signOutButton);
        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.signOut();
            }
        });

        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    // user auth state is changed - user is null
                    // launch login activity
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                }
            }
        };

        // Let 'begin' button open the How Many Floors activity
        Button loadHowManyFloorsActivity = (Button) findViewById(R.id.beginButton);
        loadHowManyFloorsActivity.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HowManyFloorsActivity.class);
//                Intent intent = new Intent(MainActivity.this, EditRoomActivity.class);
                startActivity(intent);
            }
        });
    }
}