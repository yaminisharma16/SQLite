package com.aptron.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{
    EditText et3, et4;
    Button b3, b4;
    DBManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        et3= findViewById(R.id.eml1);
        et4= findViewById(R.id.pss1);
        b3= findViewById(R.id.lgn);
        b4= findViewById(R.id.bk);

        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        manager = new DBManager(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.lgn:
                String emltxt= et3.getText().toString();
                String psstxt= et4.getText().toString();
                boolean status= manager.getUser(emltxt, psstxt);
                if(status) {
                    Intent intent = new Intent(Main2Activity.this,Main3Activity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(this, "Email and password do not match", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.bk:
                finish();
                break;
        }
    }
}
