package xyz.rakib.appdevelopingcourse;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class HomeWork254 extends AppCompatActivity {
    ListView listView;
    ProgressBar progressBar;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();

    // Constants
    private static final String TAG = AAA_Test.class.getSimpleName();
    private static final String JSON_URL = "https://programmervai.000webhostapp.com/apps/video.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_work254);

        progressBar = findViewById(R.id.progressBar);
        listView = findViewById(R.id.listView);

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

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, JSON_URL, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        progressBar.setVisibility(View.GONE);
                        try {
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject jsonObject = response.getJSONObject(i);
                                String titile = jsonObject.getString("titile");
                                String url = jsonObject.getString("url");


                                // Create a HashMap to store the data
                                HashMap<String, String> hashMap = new HashMap<>();
                                hashMap.put("Title", titile);
                                hashMap.put("Url", url);


                                // Add the HashMap to the ArrayList
                                arrayList.add(hashMap);
                            }
                            MyAdapter myAdapter = new MyAdapter();
                            listView.setAdapter(myAdapter);

                            // TODO: Set up adapter for listView and update UI

                        } catch (JSONException e) {
                            Log.e(TAG, "Error parsing JSON: " + e.getMessage());
                            Toast.makeText(HomeWork254.this, "Error parsing JSON", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Handle error response
                progressBar.setVisibility(View.GONE);
                Log.e(TAG, "Volley error: " + error.getMessage());
                Toast.makeText(HomeWork254.this, "Error fetching JSON data", Toast.LENGTH_SHORT).show();
            }
        });

        // Disable caching for this request
        jsonArrayRequest.setShouldCache(false);

        // Add the request to the RequestQueue
        queue.add(jsonArrayRequest);
    }

    private boolean isInternetConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
            return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        }
        return false;
    }

    private class MyAdapter extends BaseAdapter {

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
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
                convertView = layoutInflater.inflate(R.layout.list_view, parent, false);

                viewHolder = new ViewHolder();
                viewHolder.tv_title = convertView.findViewById(R.id.tv_title);
                viewHolder.iv_pic = convertView.findViewById(R.id.iv_pic);

                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            HashMap<String, String> hashMap = arrayList.get(position);
            String title = hashMap.get("Title");
            String url = hashMap.get("Url");
            String imageUrl = "https://img.youtube.com/vi/" + url + "/0.jpg";

            viewHolder.tv_title.setText(title);

            // Load image using Picasso with error handling and resizing
            Picasso.get()
                    .load(imageUrl)
                    .placeholder(R.drawable.ic_launcher_background) // Placeholder image while loading
                    .error(R.drawable.star) // Error image if Picasso fails to load
                    .resize(1100, 800) // Resize image
                    .into(viewHolder.iv_pic);

            return convertView;
        }

        private class ViewHolder {
            TextView tv_title;
            ImageView iv_pic;
        }

    }
}