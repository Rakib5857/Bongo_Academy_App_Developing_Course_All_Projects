package xyz.rakib.appdevelopingcourse;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HomeWork210_1 extends AppCompatActivity {
    EditText ed_InputNumber1, ed_InputNumber2; // Declaring EditText variables
    Button b_ClickHere; // Declaring Button variable
    TextView tv_Display; // Declaring TextView variable

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_work210_1); // Setting the layout for this activity

        // Initializing EditText, Button, and TextView objects by referencing their IDs defined in the layout XML file
        ed_InputNumber1 = findViewById(R.id.ed_InputNumber1);
        ed_InputNumber2 = findViewById(R.id.ed_InputNumber2);
        b_ClickHere = findViewById(R.id.b_ClickHere);
        tv_Display = findViewById(R.id.tv_Display);

        // Setting a click listener for the button
        b_ClickHere.setOnClickListener(v -> {
            try {
                // Retrieving text from EditText fields and converting them to integers
                String myString1 = ed_InputNumber1.getText().toString();
                int num1 = Integer.parseInt(myString1);
                String myString2 = ed_InputNumber2.getText().toString();
                int num2 = Integer.parseInt(myString2);

                // Comparing the numbers and displaying a message indicating which is larger and which is smaller
                if (num1 < num2) {
                    tv_Display.setText("ছোট সংখ্যা : " + num1 + "\nবড় সংখ্যা : " + num2);
                } else {
                    tv_Display.setText("বড় সংখ্যা : " + num1 + "\nছোট সংখ্যা : " + num2);
                }
            } catch (NumberFormatException e) {
                // Displaying a toast message if the input is not a valid integer
                Toast.makeText(HomeWork210_1.this, "Please enter valid marks", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
