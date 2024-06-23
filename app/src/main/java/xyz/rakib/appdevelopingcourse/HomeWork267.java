package xyz.rakib.appdevelopingcourse;

import android.app.AlertDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class HomeWork267 extends AppCompatActivity {
    EditText editTextName, editTextNumber, editTextEmail;
    Button buttonSubmit;
    ProgressBar progressBar;
    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_work267);

        progressBar = findViewById(R.id.progressBar);
        editTextName = findViewById(R.id.editTextName);
        editTextNumber = findViewById(R.id.editTextNumber);
        editTextEmail = findViewById(R.id.editTextEmail);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        queue = Volley.newRequestQueue(this);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNetworkAvailable()) {
                    String n = editTextName.getText().toString();
                    String p = editTextNumber.getText().toString();
                    String e = editTextEmail.getText().toString();
                    String url = "https://programmervai.000webhostapp.com/apps/data.php?n=" + n + "&p=" + p + "&e=" + e;

                    progressBar.setVisibility(View.VISIBLE);

                    StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            progressBar.setVisibility(View.GONE);
                            new AlertDialog.Builder(HomeWork267.this)
                                    .setTitle("Done")
                                    .setMessage(response)
                                    .show();

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(HomeWork267.this, "Error occurred!", Toast.LENGTH_SHORT).show();
                        }
                    });

                    // Disable caching for this request
                    stringRequest.setShouldCache(false);

                    // Add the request to the RequestQueue
                    queue.add(stringRequest);
                } else {
                    Toast.makeText(HomeWork267.this, "No internet connection available!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Method to check network connectivity
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}