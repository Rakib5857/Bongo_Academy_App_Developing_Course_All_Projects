package xyz.rakib.appdevelopingcourse;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class HomeWork236 extends AppCompatActivity {

    EditText ed_Name, ed_Email, ed_PhoneNumber, ed_passportId, ed_VotarId;
    Button b_Save, b_Next;
    TextView tv_Display;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_work236);

        initializeViews();

        sharedPreferences = getSharedPreferences(getString(R.string.app_name), MODE_PRIVATE);

        b_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });

        b_Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayData();
            }
        });
    }

    private void initializeViews() {
        ed_Name = findViewById(R.id.ed_Name);
        ed_Email = findViewById(R.id.ed_Email);
        ed_PhoneNumber = findViewById(R.id.ed_PhoneNumber);
        ed_passportId = findViewById(R.id.ed_passportId);
        ed_VotarId = findViewById(R.id.ed_VotarId);
        b_Next = findViewById(R.id.b_Next);
        b_Save = findViewById(R.id.b_Save);
        tv_Display = findViewById(R.id.tv_Display);
    }

    private void saveData() {
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("Name", ed_Name.getText().toString());
        editor.putString("Email", ed_Email.getText().toString());
        editor.putString("Phone Number", ed_PhoneNumber.getText().toString());
        editor.putString("Passport Number", ed_passportId.getText().toString());
        editor.putString("Votar Id Card", ed_VotarId.getText().toString());

        editor.apply();
    }

    private void displayData() {
        String name = sharedPreferences.getString("Name", "N/A");
        String email = sharedPreferences.getString("Email", "N/A");
        String phone = sharedPreferences.getString("Phone Number", "N/A");
        String passportId = sharedPreferences.getString("Passport Number", "N/A");
        String votarId = sharedPreferences.getString("Votar Id Card", "N/A");

        String displayText = "Name: " + name + "\n" +
                "Email: " + email + "\n" +
                "Phone Number: " + phone + "\n" +
                "Passport Number: " + passportId + "\n" +
                "Votar Id Card: " + votarId + "\n";

        tv_Display.setText(displayText);
    }
}
