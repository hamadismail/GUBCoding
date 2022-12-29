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

public class third extends AppCompatActivity {


    String day, breakf, lunch, vehicle, others, total;
    SQLiteDatabase db;

    int amount;

    EditText eday, ebreakfast, elunch, evehicle, eothers;
    Button bttotal, bhome, bsum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        eday = findViewById(R.id.eday);
        ebreakfast = findViewById(R.id.ebreakfast);
        elunch = findViewById(R.id.elunch);
        evehicle = findViewById(R.id.evehicle);
        eothers = findViewById(R.id.eothers);
        bttotal = findViewById(R.id.bttotal);
        bhome = findViewById(R.id.bhome);
        bsum = findViewById(R.id.bsum);


        db = openOrCreateDatabase("Mydb", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS list(day VARCHAR,breakf VARCHAR,lunch VARCHAR,vehicle VARCHAR,others VARCHAR, total VARCHAR); ");


        bttotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                day = eday.getText().toString();
                breakf = ebreakfast.getText().toString();
                lunch = elunch.getText().toString();
                vehicle = evehicle.getText().toString();
                others = eothers.getText().toString();
//                total = eothers.getText().toString();

                amount = Integer.parseInt(breakf) + Integer.parseInt(lunch) + Integer.parseInt(vehicle) + Integer.parseInt(others);

                total = String.valueOf(amount);
//                total = Integer.toString(amount);

                db.execSQL("INSERT INTO list VALUES('" + day + "','" + breakf + "','" + lunch + "','" + vehicle + "','"+others+"','"+total+"');");
                Toast.makeText(getApplicationContext(), "Total Cost :"+amount, Toast.LENGTH_SHORT).show();
            }
        });

        bsum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), day.class);

                startActivity(intent);
                finish();
            }
        });

        bhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                startActivity(intent);
                finish();
            }
        });

    }
}