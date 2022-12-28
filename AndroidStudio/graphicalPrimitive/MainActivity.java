package com.example.labthree;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    DemoView dv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dv = new DemoView(this);
        setContentView(dv);
    }

    private class DemoView extends View {
        public DemoView(Context context) {
            super(context);
        }
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint ob = new Paint();
            ob.setStyle(Paint.Style.FILL);
            ob.setColor(Color.WHITE); //set the background color
            canvas.drawPaint(ob);
            ob.setColor(Color.GRAY);

            ob.setColor(Color.YELLOW);
            canvas.drawCircle(400, 1000, 200, ob);

            ob.setColor(Color.RED);
            canvas.drawCircle(350, 920, 20, ob);
            ob.setColor(Color.RED);
            canvas.drawCircle(450, 920, 20, ob);
            ob.setColor(Color.BLACK);
            canvas.drawRect(350, 1040, 450, 1060, ob);


            ob.setColor(Color.GREEN);
            canvas.drawRect(100, 100, 600, 400, ob);
            ob.setColor(Color.RED);
            canvas.drawCircle(350, 250, 100, ob);
            ob.setColor(Color.BLACK);
            canvas.drawRect(95, 100, 100, 1000, ob);

//            canvas.drawLine(200, 200, 350, 400, ob);
//            canvas.rotate(-45);
        }
    }
}