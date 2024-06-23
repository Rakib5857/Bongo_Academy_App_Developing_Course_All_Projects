package xyz.rakib.appdevelopingcourse;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HomeWork232_5 extends AppCompatActivity {
    EditText ed_InputValue;
    Button b_ClickHere;
    TextView tv_Display;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_work232_5);

        ed_InputValue = findViewById(R.id.ed_InputValue);
        b_ClickHere = findViewById(R.id.b_ClickHere);

        tv_Display = findViewById(R.id.tv_Display);



        b_ClickHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputString = ed_InputValue.getText().toString();

                if (inputString.isEmpty()) {
                    ed_InputValue.setError("Please enter the number to check palindrome");
                    tv_Display.setText("");
                } else {
                    int maxNumber = Integer.parseInt(inputString);
                    StringBuilder palindromeNumbers = new StringBuilder();

                    for (int number = 0; number <= maxNumber; number++) {
                        int originalNumber = number;
                        int reversedNumber = 0;
                        int tempNumber = originalNumber;

                        while (tempNumber > 0) {
                            int digit = tempNumber % 10;
                            reversedNumber = reversedNumber * 10 + digit;
                            tempNumber /= 10;
                        }

                        if (originalNumber == reversedNumber) {
                            palindromeNumbers.append(originalNumber).append(", ");
                        }
                    }

                    if (palindromeNumbers.length() > 0) {
                        palindromeNumbers.setLength(palindromeNumbers.length() - 2); // Remove trailing comma and space
                        tv_Display.setText("Palindrome numbers up to " + maxNumber + ": " + palindromeNumbers.toString());
                    } else {
                        tv_Display.setText("No palindrome numbers found up to " + maxNumber);
                    }
                }
            }
        });


    }

            // Function to check if a number is palindrome

    ////back prees exit dilog
    public void showCustomExitDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.custom_exit_dialog, null);
        builder.setView(dialogView);

        final AlertDialog dialog = builder.create();
        dialog.show();

        // Set up button click listeners
        Button btnExitYes = dialog.findViewById(R.id.btn_exit_yes);
        btnExitYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform exit action
                finish();
            }
        });

        Button btnExitNo = dialog.findViewById(R.id.btn_exit_no);
        btnExitNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Dismiss the dialog
                dialog.dismiss();
            }
        });
    }

    public void onExitYesClicked(View view) {
        // This method is called when the "Yes" button is clicked (defined in XML)
        finish(); // Perform exit action
    }

    public void onExitNoClicked(View view) {
        // This method is called when the "No" button is clicked (defined in XML)
        // Dismiss the dialog
        AlertDialog dialog = (AlertDialog) ((AlertDialog.Builder) view.getTag()).create();
        dialog.dismiss();
    }

    @Override
    public void onBackPressed() {
        // Handle back button press by showing the custom exit dialog
        showCustomExitDialog();
    }


}