package xyz.rakib.appdevelopingcourse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PDF_Dashboard extends AppCompatActivity {

    Button button_1,button_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_dashboard);


        button_1 = findViewById(R.id.button_1);
        button_2 = findViewById(R.id.button_2);

        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HomeWork225.myString = "my_pdf.pdf";
                Intent intent = new Intent(PDF_Dashboard.this,HomeWork225.class);
                startActivity(intent);
            }
        });

        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HomeWork225.myString = "my_pdf_2.pdf";
                Intent intent = new Intent(PDF_Dashboard.this,HomeWork225.class);
                startActivity(intent);
            }
        });


    }
}