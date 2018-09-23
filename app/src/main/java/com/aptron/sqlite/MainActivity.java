package com.aptron.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText et1, et2;
    Button b1, b2;
    DBManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.eml);
        et2 = findViewById(R.id.pss);
        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        manager = new DBManager(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                String emlTxt = et1.getText().toString();
                String pssTxt = et2.getText().toString();
                if(emlTxt.isEmpty() && pssTxt.isEmpty()) {
                    Toast.makeText(this, "Please Insert Valid Details", Toast.LENGTH_SHORT).show();
                }
                else {
                    long id = manager.insertData(emlTxt, pssTxt);

                    if (id > 0) {

                        Toast.makeText(MainActivity.this, "Data Saved SuccessFully " + id, Toast.LENGTH_SHORT).show();

                    } else
                        {
                        Toast.makeText(MainActivity.this, "Data Not Saved", Toast.LENGTH_SHORT).show();
                    }

                }
                break;
            case R.id.button2:
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
                break;

        }
    }
}
