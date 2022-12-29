package com.example.labfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {

    EditText ename, emobile, epin, erpin;
    Button blogin, bsignup;

    String nam, mob, pin, rpin;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        emobile = findViewById(R.id.emobile);
        epin = findViewById(R.id.epin);
        erpin = findViewById(R.id.erpin);
        ename = findViewById(R.id.ename);
        blogin = findViewById(R.id.blogin);
        bsignup = findViewById(R.id.bsignup);

        db = openOrCreateDatabase("Mydb", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS user(name VARCHAR,mobile VARCHAR); ");

        bsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nam = ename.getText().toString();
                mob = emobile.getText().toString();
                pin = epin.getText().toString();
                rpin = epin.getText().toString();

                db.execSQL("INSERT INTO user VALUES('" + nam + "','" + mob + "');");

                Toast.makeText(getApplicationContext(), "Row Inserted", Toast.LENGTH_SHORT).show();
            }
        });


        blogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                startActivity(intent);
                finish();
            }
        });
    }
}