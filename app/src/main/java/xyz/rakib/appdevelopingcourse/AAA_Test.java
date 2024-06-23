package xyz.rakib.appdevelopingcourse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AAA_Test extends AppCompatActivity {
    EditText editTextName, editTextNumber, editTextEmail;
    Button buttonSubmit;
    ProgressBar progressBar;
    ListView listView;
    HashMap<String,String> hashMap = new HashMap<>();
    ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aaa_test);

        progressBar = findViewById(R.id.progressBar);
        editTextName = findViewById(R.id.editTextName);
        editTextNumber = findViewById(R.id.editTextNumber);
        editTextEmail = findViewById(R.id.editTextEmail);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        listView = findViewById(R.id.listView);
        RequestQueue queue = Volley.newRequestQueue(AAA_Test.this);
        String url = "https://programmervai.000webhostapp.com/apps/view.php";

        progressBar.setVisibility(View.VISIBLE);



        // JsonArrayRequest to fetch data from server
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        // Handle success response
                        progressBar.setVisibility(View.GONE);
                        try {
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject jsonObject = response.getJSONObject(i);
                                String name = jsonObject.getString("name");
                                String number = jsonObject.getString("number");
                                String email = jsonObject.getString("email");

                                hashMap.put("name: ",name);
                                hashMap.put("number: ",number);
                                hashMap.put("email: ",email);
                                arrayList.add(hashMap);
                            }
                            adapter.notifyDataSetChanged(); // Notify adapter of data change
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (arrayList.size()>0){
                            MyAdapter myAdapter = new MyAdapter();
                            listView.setAdapter(adapter);
                        }
                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Handle error
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(AAA_Test.this, "Error fetching data", Toast.LENGTH_SHORT).show();
                    }
                });
        queue.add(jsonArrayRequest);


        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);

                String name = editTextName.getText().toString();
                String number = editTextNumber.getText().toString();
                String email = editTextEmail.getText().toString();

                // Instantiate the RequestQueue

                String url = "https://programmervai.000webhostapp.com/apps/insert.php";

                // Post request to save data
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                // Handle success response
                                progressBar.setVisibility(View.GONE);
                                Toast.makeText(AAA_Test.this, "Data saved successfully", Toast.LENGTH_SHORT).show();

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                // Handle error
                                progressBar.setVisibility(View.GONE);
                                Toast.makeText(AAA_Test.this, "Error saving data", Toast.LENGTH_SHORT).show();
                            }
                        }) {
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<>();
                        params.put("name", name);
                        params.put("number", number);
                        params.put("email", email);
                        return params;
                    }
                };

                // Add the request to the RequestQueue
                queue.add(stringRequest);
            }
        });

    }
    public class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
           return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater = getLayoutInflater();
           // View view = layoutInflater.inflate(R.layout.activity_aaa_test);

            return null;
        }
    }
}
