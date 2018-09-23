package com.aptron.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main3Activity extends AppCompatActivity {
    Button lo;
    Session session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        lo= findViewById(R.id.lgot);
        session= new Session(this);
        lo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//session management if session=true then it should stay logged in
                if(session.getSession()){

                }
            }
        });
    }
}
