package xyz.rakib.appdevelopingcourse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Season1 extends AppCompatActivity {

    TextView button_HomeWork,button_Practice,tv_myApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_season1);

        button_HomeWork = findViewById(R.id.button_HomeWork);
        button_Practice = findViewById(R.id.button_Practice);
        tv_myApp = findViewById(R.id.tv_myApp);


        button_Practice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Season1.this, All_Practice_Challenge.class);
                startActivity(myIntent);
            }
        });

        button_HomeWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Season1.this, All_Home_Work.class);
                startActivity(myIntent);
            }
        });
        tv_myApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Season1.this, My_App.class);
                startActivity(myIntent);
            }
        });

    }
}