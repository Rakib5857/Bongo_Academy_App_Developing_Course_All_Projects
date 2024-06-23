package xyz.rakib.appdevelopingcourse;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HomeWork214_4 extends AppCompatActivity {

    EditText ed_Physics,ed_Chemistry,ed_Biology,ed_Mathematics,ed_Computer;
    Button b_ClickHere,b_reset;
    TextView tv_Display1,tv_Display2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_work214_4);



        ed_Physics = findViewById(R.id.ed_Physics);
        ed_Chemistry = findViewById(R.id.ed_Chemistry);
        ed_Biology = findViewById(R.id.ed_Biology);
        ed_Mathematics = findViewById(R.id.ed_Mathematics);
        ed_Computer = findViewById(R.id.ed_Computer);
        b_ClickHere = findViewById(R.id.b_ClickHere);
        b_reset = findViewById(R.id.b_reset);
        tv_Display1 = findViewById(R.id.tv_Display1);
        tv_Display2 = findViewById(R.id.tv_Display2);




        b_ClickHere.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                try {
                    float phy, chem, bio, math, comp, percentage;

                    // Parse marks from EditText fields
                    phy = Float.parseFloat(ed_Physics.getText().toString());
                    chem = Float.parseFloat(ed_Chemistry.getText().toString());
                    bio = Float.parseFloat(ed_Biology.getText().toString());
                    math = Float.parseFloat(ed_Mathematics.getText().toString());
                    comp = Float.parseFloat(ed_Computer.getText().toString());

                    // Calculate percentage
                    percentage = (phy + chem + bio + math + comp) / 5;

                    // Display percentage
                    tv_Display1.setText("Your Percentage: " + percentage + "%");

                    // Assign grade based on percentage
                    if (percentage >= 90) {
                        tv_Display2.setTextColor(Color.parseColor("#ADFF2F"));
                        tv_Display2.setText("Your Grade is: A");
                    }else if (percentage >= 80) {
                        tv_Display2.setTextColor(Color.parseColor("#EEE8AA"));
                        tv_Display2.setText("Your Grade is: B");
                    }else if (percentage >= 70) {
                        tv_Display2.setTextColor(Color.parseColor("#FF4500"));
                        tv_Display2.setText("Your Grade is: C");
                    }else if (percentage >= 60) {
                        tv_Display2.setTextColor(Color.parseColor("#FFA500"));
                        tv_Display2.setText("Your Grade is: D");
                    }else if (percentage >= 40) {
                            tv_Display2.setTextColor(Color.parseColor("#FF0000"));
                            tv_Display2.setText("Your Grade is: E");


                    } else tv_Display2.setText("Your Grade is: F");
                } catch (NumberFormatException e) {
                    Toast.makeText(HomeWork214_4.this, "Please enter valid marks", Toast.LENGTH_SHORT).show();
                }
            }
        });

        b_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Clear the text displayed in the TextViews
                tv_Display1.setText("");
                tv_Display2.setText("");

                // Clear the text entered in the EditText fields
                ed_Physics.setText("");
                ed_Chemistry.setText("");
                ed_Biology.setText("");
                ed_Mathematics.setText("");
                ed_Computer.setText("");
            }
        });

    }

}