package xyz.rakib.appdevelopingcourse;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HomeWork233 extends AppCompatActivity {

    EditText ed_InputValue;
    Button b_ClickHere;
    TextView tv_Display;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_work233);

        ed_InputValue = findViewById(R.id.ed_InputValue);
        b_ClickHere = findViewById(R.id.b_ClickHere);

        tv_Display = findViewById(R.id.tv_Display);

        b_ClickHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s = ed_InputValue.getText().toString();
                if (s.isEmpty()){
                    ed_InputValue.setError("Input your value");
                } else {
                    tv_Display.setText("");
                    int yD = Integer.parseInt(s);
                    int[] rainbowColors = {
                            Color.RED,
                            Color.YELLOW,
                            Color.GREEN,
                            Color.CYAN,
                            Color.BLUE,
                            Color.MAGENTA
                    };

                    for (int x = 1; x <= yD; x++){
                        int colorIndex = 0; // Reset color index for each line
                        for (int i = 1; i <= x; i++){
                            // Set rainbow color for each asterisk
                            tv_Display.append("*");
                            tv_Display.setTextColor(rainbowColors[colorIndex]);
                            colorIndex = (colorIndex + 1) % rainbowColors.length;
                        }
                        tv_Display.append("\n");
                    }
                }
            }
        });


    }
}