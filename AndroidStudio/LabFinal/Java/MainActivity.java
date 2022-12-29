package com.example.labfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText emobile, epin;
    Button blogin, bsignup;

    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        emobile = findViewById(R.id.emobile);
        epin = findViewById(R.id.epin);
        blogin = findViewById(R.id.blogin);
        bsignup = findViewById(R.id.bsignup);


        db = openOrCreateDatabase("Mydb", MODE_PRIVATE, null);

//        final Cursor c = db.rawQuery("select * from user", null);
//        c.moveToFirst();
//
//        emobile.setText(c.getString(c.getColumnIndex("mobile")));
//        epin.setText(c.getString(c.getColumnIndex("pin")));

        blogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), third.class);

                startActivity(intent);
                finish();
            }
        });



        bsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), signup.class);

                startActivity(intent);
                finish();
            }
        });
    }
}