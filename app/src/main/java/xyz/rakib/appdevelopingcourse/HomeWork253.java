package xyz.rakib.appdevelopingcourse;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class HomeWork253 extends AppCompatActivity {

        TextView tv_name,tv_number,tv_email,tv_address;
        ProgressBar progressBar;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_home_work253);

            tv_name = findViewById(R.id.tv_name);
            tv_number = findViewById(R.id.tv_number);
            tv_email = findViewById(R.id.tv_email);
            tv_address = findViewById(R.id.tv_address);
            progressBar = findViewById(R.id.progressBar);

            // Make the ProgressBar visible
            progressBar.setVisibility(View.VISIBLE);



            // Check internet connectivity
            if (isInternetConnected()) {
                // Internet connection available
                Toast.makeText(this, "Internet is connected", Toast.LENGTH_SHORT).show();
            } else {
                // No internet connection
                Toast.makeText(this, "No internet connection", Toast.LENGTH_SHORT).show();
            }

            // Instantiate the RequestQueue.
            RequestQueue queue = Volley.newRequestQueue(this);
            String url = "https://programmervai.000webhostapp.com/apps/info.json";



// Request a string response from the provided URL.
            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            // Display the first 500 characters of the response string.

                            progressBar.setVisibility(View.GONE);

                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                String name = jsonObject.getString("Name");
                                String number = jsonObject.getString("Mobile");
                                String email = jsonObject.getString("Email");
                                String address = jsonObject.getString("Address");

                                tv_name.setText( name);
                                tv_number.setText(number);
                                tv_email.setText(email);
                                tv_address.setText(address);

                            } catch (JSONException e) {
                                Log.e(TAG, "JSON parsing error: " + e.getMessage());
                                Toast.makeText(HomeWork253.this, "error_message", Toast.LENGTH_SHORT).show();

                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    tv_name.setText("That didn't work!");
                    progressBar.setVisibility(View.GONE);
                }
            });
            stringRequest.setShouldCache(false);
            queue.add(stringRequest);
        }
        private boolean isInternetConnected() {
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivityManager != null) {
                NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
                return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
            }
            return false;
        }
    }
