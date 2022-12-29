package com.example.labfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class day extends AppCompatActivity {

    TextView tday, ttotal;
    Button bprev, bnext, bhome;

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day);

        tday = findViewById(R.id.tday);
        ttotal = findViewById(R.id.ttotal);
        bprev = findViewById(R.id.bprev);
        bnext = findViewById(R.id.bnext);
        bhome = findViewById(R.id.bhome);


        bhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                startActivity(intent);
                finish();
            }
        });


        db = openOrCreateDatabase("Mydb", MODE_PRIVATE, null);

        final Cursor c = db.rawQuery("select * from list", null);
        c.moveToFirst();
        tday.setText(c.getString(c.getColumnIndex("day")));
        ttotal.setText(c.getString(c.getColumnIndex("total")));

        bnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    c.moveToNext();
                    tday.setText(c.getString(c.getColumnIndex("day")));
                    ttotal.setText(c.getString(c.getColumnIndex("total")));
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Last Record", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });

        bprev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    c.moveToPrevious();
                    tday.setText(c.getString(c.getColumnIndex("day")));
                    ttotal.setText(c.getString(c.getColumnIndex("total")));
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "First Record", Toast.LENGTH_LONG).show();

                    e.printStackTrace();
                }
            }
        });
    }
}