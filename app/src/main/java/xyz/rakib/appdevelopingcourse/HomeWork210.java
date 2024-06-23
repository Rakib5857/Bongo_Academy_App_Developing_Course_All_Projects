package xyz.rakib.appdevelopingcourse;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HomeWork210 extends AppCompatActivity {
    EditText ed_InputNumber;
    Button b_ClickHere;
    TextView tv_Display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_work210);

        ed_InputNumber = findViewById(R.id.ed_InputNumber);
        b_ClickHere = findViewById(R.id.b_ClickHere);
        tv_Display = findViewById(R.id.tv_Display);


        b_ClickHere.setOnClickListener(v -> {


            String myString = ed_InputNumber.getText().toString();
            int num = Integer.parseInt(myString);


            if(num % 2 == 0){
                tv_Display.setTextColor(Color.parseColor("#9ACD32"));
                tv_Display.setText("এটা জোড় সংখ্যা");

            }else {
                tv_Display.setTextColor(Color.parseColor("#FF0000"));
                tv_Display.setText("এটা বিজোড় সংখ্যা");
            }

        });


    }
}