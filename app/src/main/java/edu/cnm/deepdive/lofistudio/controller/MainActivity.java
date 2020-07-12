package edu.cnm.deepdive.lofistudio.controller;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import edu.cnm.deepdive.lofistudio.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout linearLayout = findViewById(R.id.layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) linearLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        Button butt1 = findViewById(R.id.butt1);
        Button butt2 = findViewById(R.id.butt2);
        Button butt3 = findViewById(R.id.butt3);

        butt1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 = new Intent(MainActivity.this,Activity1.class);
                startActivity(int1);
            }
        });

        butt2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int2 = new Intent(MainActivity.this,Activity2.class);
                startActivity(int2);
            }
        });

        butt3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int3 = new Intent(MainActivity.this,Activity3.class);
                startActivity(int3);
            }
        });



    }
}
