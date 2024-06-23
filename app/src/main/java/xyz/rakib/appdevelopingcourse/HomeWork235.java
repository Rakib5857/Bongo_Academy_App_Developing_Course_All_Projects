package xyz.rakib.appdevelopingcourse;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class HomeWork235 extends AppCompatActivity {

    ListView lv_aa;
    ImageView add;

    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
    HashMap<String, String> hashMap;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_work235);

        lv_aa = findViewById(R.id.lv_aa);
        add = findViewById(R.id.iv_add);
        sharedPreferences = getSharedPreferences(getString(R.string.app_name), MODE_PRIVATE);

        AppAdapter adapter = new AppAdapter();
        lv_aa.setAdapter(adapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog();
            }
        });
    }

    private void saveData() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Name", hashMap.get("Name"));
        editor.putString("Number", hashMap.get("Number"));
        editor.apply();
    }

    public void dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.add_user, null);

        EditText ed_Name = dialogView.findViewById(R.id.ed_Name);
        EditText ed_Number = dialogView.findViewById(R.id.ed_Number);
        Button btn_Add = dialogView.findViewById(R.id.btn_Add);
        Button btn_No = dialogView.findViewById(R.id.btn_No);

        builder.setView(dialogView);
        builder.setTitle("Enter Your Name and Number");

        final AlertDialog dialog = builder.create();
        dialog.show();

        btn_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = ed_Name.getText().toString();
                String number = ed_Number.getText().toString();

                if (name.isEmpty() || number.isEmpty()) {
                    ed_Name.setError("Input Your Name");
                    ed_Number.setError("Input Your Number");
                } else {
                    hashMap = new HashMap<>();
                    hashMap.put("Name", name);
                    hashMap.put("Number", number);
                    arrayList.add(hashMap);

                    // Notify the adapter that the dataset has changed
                    ((BaseAdapter) lv_aa.getAdapter()).notifyDataSetChanged();

                    saveData();

                    // Dismiss the dialog
                    dialog.dismiss();
                }
            }
        });

        btn_No.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

    private class AppAdapter extends BaseAdapter {

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
            if (convertView == null) {
                LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = layoutInflater.inflate(R.layout.list_view, parent, false);
            }

            TextView name = convertView.findViewById(R.id.tv_name);
            TextView number = convertView.findViewById(R.id.tv_number);

            hashMap = arrayList.get(position);
            name.setText(hashMap.get("Name"));
            number.setText(hashMap.get("Number"));

            return convertView;
        }
    }
}
