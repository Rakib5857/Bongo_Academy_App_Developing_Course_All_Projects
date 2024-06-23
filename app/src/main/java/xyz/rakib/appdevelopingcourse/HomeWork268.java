package xyz.rakib.appdevelopingcourse;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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

public class HomeWork268 extends AppCompatActivity {
    private static final String TAG = HomeWork268.class.getSimpleName();
    private static final String URL_FETCH_DATA = "https://programmervai.000webhostapp.com/apps/view.php";
    private static final String URL_INSERT_DATA = "https://programmervai.000webhostapp.com/apps/insert_data.php";
    private static final String URL_UPDATE_DATA = "https://programmervai.000webhostapp.com/apps/update.php";
    private static final String URL_DELETE_DATA = "https://programmervai.000webhostapp.com/apps/delete.php";
    private static final String URL_SEARCH_DATA = "https://programmervai.000webhostapp.com/apps/search.php";

    EditText editTextName, editAge, editTextNumber, editTextEmail, editText_Search;
    Button buttonSubmit, btn_Search;
    TextView tv_Display;
    ProgressBar progressBar;
    ListView listView;
    Context context;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_work268);

        progressBar = findViewById(R.id.progressBar);
        editTextName = findViewById(R.id.editTextName);
        editAge = findViewById(R.id.editAge);
        editTextNumber = findViewById(R.id.editTextNumber);
        editTextEmail = findViewById(R.id.editTextEmail);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        listView = findViewById(R.id.listView);
        editText_Search = findViewById(R.id.editText_Search);
        btn_Search = findViewById(R.id.btn_Search);
        tv_Display = findViewById(R.id.tv_Display);


        progressBar.setVisibility(View.VISIBLE);
        loadData();

        // Check internet connectivity
        if (isInternetConnected()) {
            // Internet connection available
            Toast.makeText(this, "Internet is connected", Toast.LENGTH_SHORT).show();
        } else {
            // No internet connection
            Toast.makeText(this, "No internet connection", Toast.LENGTH_SHORT).show();
        }


        buttonSubmit.setOnClickListener(v -> {
            insertData();
        });
        btn_Search.setOnClickListener(v -> searchData());
    }


    private void insertData() {
        String name = editTextName.getText().toString();
        String age = editAge.getText().toString();
        String number = editTextNumber.getText().toString();
        String email = editTextEmail.getText().toString();
        String url = URL_INSERT_DATA + "?name=" + name + "&age=" + age +
                "&number=" + number + "&email=" + email;
        ;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(HomeWork268.this, response, Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "Response: " + response);
                        loadData();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(HomeWork268.this, "Error saving data", Toast.LENGTH_SHORT).show();
                        Log.e(TAG, "Error: " + error.toString());
                    }
                });

        // Add the request to the RequestQueue
        RequestQueue queue = Volley.newRequestQueue(HomeWork268.this);
        queue.add(stringRequest);
    }

    private void searchData() {
        if (isInternetConnected()) {
            String name = editText_Search.getText().toString();
            String url = URL_FETCH_DATA + "?name=" + Uri.encode(name); // Use Uri.encode to handle special characters

            JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                    response -> {
                        try {
                            ArrayList<HashMap<String, String>> searchResults = new ArrayList<>();

                            for (int i = 0; i < response.length(); i++) {
                                JSONObject jsonObject = response.getJSONObject(i);
                                String id = jsonObject.getString("id");
                                String nameResult = jsonObject.getString("name");
                                String age = jsonObject.getString("age");
                                String number = jsonObject.getString("number");
                                String email = jsonObject.getString("email");

                                HashMap<String, String> result = new HashMap<>();
                                result.put("id", id);
                                result.put("name", nameResult);
                                result.put("age", age);
                                result.put("number", number);
                                result.put("email", email);

                                searchResults.add(result);
                            }

                            MyAdapter myAdapter = new MyAdapter(HomeWork268.this, searchResults);
                            listView.setAdapter(myAdapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(HomeWork268.this, "Error parsing data!", Toast.LENGTH_SHORT).show();
                        }
                    },
                    error -> {
                        Toast.makeText(HomeWork268.this, "Error occurred!", Toast.LENGTH_SHORT).show();
                        Log.e(TAG, "Error searching data: " + error.toString());
                    });

            RequestQueue queue = Volley.newRequestQueue(HomeWork268.this);
            queue.add(jsonArrayRequest);
        } else {
            Toast.makeText(HomeWork268.this, "No internet connection available!", Toast.LENGTH_SHORT).show();
        }
    }


    private boolean isInternetConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
            return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        }
        return false;
    }

    public class MyAdapter extends BaseAdapter {
        private ArrayList<HashMap<String, String>> arrayList;
        private Context context;

        public MyAdapter(Context context, ArrayList<HashMap<String, String>> arrayList) {
            this.context = context;
            this.arrayList = arrayList;
        }

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return arrayList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @SuppressLint("SetTextI18n")
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
                convertView = layoutInflater.inflate(R.layout.item, parent, false);

                holder = new ViewHolder();
                holder.textViewId = convertView.findViewById(R.id.text_id);
                holder.textViewName = convertView.findViewById(R.id.text_name);
                holder.text_age = convertView.findViewById(R.id.text_age);
                holder.textViewNumber = convertView.findViewById(R.id.text_email);
                holder.textViewEmail = convertView.findViewById(R.id.text_phone);
                holder.btn_update = convertView.findViewById(R.id.btn_update);
                holder.btn_delete = convertView.findViewById(R.id.btn_delete);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            HashMap<String, String> hashMap = arrayList.get(position);
            String id = hashMap.get("id");

            holder.textViewId.setText("Id: " + id);
            holder.textViewName.setText("Name: " + hashMap.get("name"));
            holder.text_age.setText("Age: " + hashMap.get("age"));
            holder.textViewNumber.setText("Number: " + hashMap.get("number"));
            holder.textViewEmail.setText("Email: " + hashMap.get("email"));

            holder.btn_update.setOnClickListener(v -> onUpdateClicked(id));
            holder.btn_delete.setOnClickListener(v -> onDeleteClicked(hashMap));
            return convertView;
        }

        private class ViewHolder {
            TextView textViewId;
            TextView textViewName, text_age;
            TextView textViewNumber;
            TextView textViewEmail;
            Button btn_update;
            Button btn_delete;
        }

        private void onUpdateClicked(String id) {
            if (isInternetConnected()) {
                String name = editTextName.getText().toString();
                String age = editAge.getText().toString();
                String number = editTextNumber.getText().toString();
                String email = editTextEmail.getText().toString();
                String url = URL_UPDATE_DATA + "?id=" + id + "&name=" + name + "&age=" + age +
                        "&number=" + number + "&email=" + email;
                ;

                progressBar.setVisibility(View.VISIBLE);

                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        response -> {
                            progressBar.setVisibility(View.GONE);
                            AlertDialog alertDialog = new AlertDialog.Builder(HomeWork268.this)
                                    .setTitle("Update")
                                    .setMessage(response)
                                    .show();

                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    if (alertDialog.isShowing()) {
                                        alertDialog.dismiss();
                                        loadData();
                                    }
                                }
                            }, 1000);

                            loadData();
                        },
                        error -> {
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(HomeWork268.this, error.toString(), Toast.LENGTH_SHORT).show();
                        });

                // Disable caching for this request
                stringRequest.setShouldCache(false);

                // Add the request to the RequestQueue
                RequestQueue queue = Volley.newRequestQueue(HomeWork268.this);
                queue.add(stringRequest);
            } else {
                Toast.makeText(HomeWork268.this, "No internet connection", Toast.LENGTH_SHORT).show();
            }
        }

        private void onDeleteClicked(HashMap<String, String> data) {
            if (isInternetConnected()) {
                String id = data.get("id");
                String url = URL_DELETE_DATA + "?id=" + id;

                progressBar.setVisibility(View.VISIBLE);

                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        response -> {
                            progressBar.setVisibility(View.GONE);
                            AlertDialog alertDialogg = new AlertDialog.Builder(HomeWork268.this)
                                    .setTitle("Delete")
                                    .setMessage(response)
                                    .show();
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    if (alertDialogg.isShowing()) {
                                        alertDialogg.dismiss();
                                        loadData();
                                    }
                                }
                            }, 1000);

                            loadData();
                        },
                        error -> {
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(HomeWork268.this, error.toString(), Toast.LENGTH_SHORT).show();
                        });

                // Disable caching for this request
                stringRequest.setShouldCache(false);

                RequestQueue queue = Volley.newRequestQueue(HomeWork268.this);
                queue.add(stringRequest);
            } else {
                Toast.makeText(HomeWork268.this, "No internet connection", Toast.LENGTH_SHORT).show();
            }
        }



    }
    public void loadData() {
        arrayList = new ArrayList<>();
        progressBar.setVisibility(View.VISIBLE); // Show the progress bar while loading data

        // JsonArrayRequest to fetch data from server
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, URL_FETCH_DATA, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        progressBar.setVisibility(View.GONE); // Hide the progress bar after loading data
                        try {
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject jsonObject = response.getJSONObject(i);
                                String id = jsonObject.getString("id");
                                String name = jsonObject.getString("name");
                                String age = jsonObject.getString("age");
                                String number = jsonObject.getString("number");
                                String email = jsonObject.getString("email");

                                HashMap<String, String> hashMap = new HashMap<>();
                                hashMap.put("id", id);
                                hashMap.put("age", age);
                                hashMap.put("name", name);
                                hashMap.put("number", number);
                                hashMap.put("email", email);
                                arrayList.add(hashMap);
                            }
                            if (!arrayList.isEmpty()) {
                                MyAdapter myAdapter = new MyAdapter(HomeWork268.this, arrayList);
                                listView.setAdapter(myAdapter);
                            }
                        } catch (JSONException e) {
                            Log.e(TAG, "Error parsing JSON: " + e.getMessage());
                            Toast.makeText(HomeWork268.this, "Error parsing JSON", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressBar.setVisibility(View.GONE); // Hide the progress bar on error
                        Log.e(TAG, "Volley error: " + error.getMessage());
                        Toast.makeText(HomeWork268.this, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });

        jsonArrayRequest.setShouldCache(false);
        RequestQueue queue = Volley.newRequestQueue(HomeWork268.this);
        queue.add(jsonArrayRequest);
    }

}