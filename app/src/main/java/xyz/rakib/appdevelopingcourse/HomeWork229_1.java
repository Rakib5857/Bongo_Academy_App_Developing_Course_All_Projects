package xyz.rakib.appdevelopingcourse;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HomeWork229_1 extends AppCompatActivity {
    EditText ed_InputValue, ed_InputValue2;
    Button b_ClickHere;
    TextView tv_Display;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_work229_1);

        ed_InputValue = findViewById(R.id.ed_InputValue);
        ed_InputValue2 = findViewById(R.id.ed_InputValue2);
        b_ClickHere = findViewById(R.id.b_ClickHere);

        tv_Display = findViewById(R.id.tv_Display);


        b_ClickHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = ed_InputValue.getText().toString();
                String string1 = ed_InputValue2.getText().toString();

                if (string.isEmpty() || string1.isEmpty()) {
                    if (string.isEmpty()) {
                        ed_InputValue.setError("Input your value");
                        tv_Display.setText("");
                    }
                    if (string1.isEmpty()) {
                        ed_InputValue2.setError("Input your value");
                        tv_Display.setText("");
                    }
                } else {
                    int a, b;
                    a = Integer.parseInt(ed_InputValue.getText().toString());
                    b = Integer.parseInt(ed_InputValue2.getText().toString());

                    tv_Display.setText("");

                    if (a >= b) {

                        tv_Display.setText("Input value 1 should be less than Input value 2");
                    } else {

                        for (int x = a; x <= b; x++) {
                            if (x % 2 != 0) {
                                tv_Display.append(" " + x);
                            }
                        }
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