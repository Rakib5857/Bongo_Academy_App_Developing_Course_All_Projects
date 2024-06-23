package xyz.rakib.appdevelopingcourse;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class All_Practice_Challenge extends AppCompatActivity {

    LinearLayout layout_Calculator,layout_Nagad,layout_GoZayan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_practice_challenge);

        layout_Calculator = findViewById(R.id.layout_Calculator);
        layout_Nagad = findViewById(R.id.layout_Nagad);
        layout_GoZayan = findViewById(R.id.layout_GoZayan);


        layout_Calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(All_Practice_Challenge.this, Practice_Challenge1.class);
                startActivity(myIntent);
            }
        });
        layout_Nagad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(All_Practice_Challenge.this, Practice_Challenge2.class);
                startActivity(myIntent);
            }
        });
        layout_GoZayan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(All_Practice_Challenge.this, Practice_Challenge3.class);
                startActivity(myIntent);
            }
        });
    }
}