package xyz.rakib.appdevelopingcourse;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HomeWork232_1 extends AppCompatActivity {
    EditText ed_InputValue;
    Button b_ClickHere;
    TextView tv_Display;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_work232_1);

        ed_InputValue = findViewById(R.id.ed_InputValue);
        b_ClickHere = findViewById(R.id.b_ClickHere);

        tv_Display = findViewById(R.id.tv_Display);


        b_ClickHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputString = ed_InputValue.getText().toString();

                if (inputString.isEmpty()) {
                    ed_InputValue.setError("Input your value");
                    tv_Display.setText("");
                } else {
                    int number = Integer.parseInt(inputString);
                    tv_Display.setText("");

                    for (int x = 1; x <= 10; x++) {
                        int multiplicationResult = number * x;
                        tv_Display.append(number + " * " + x + " = " + multiplicationResult + "\n");
                    }
                }
            }
        });



    }
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