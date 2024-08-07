package com.example.firstproject;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ConstraintLayout extends AppCompatActivity {

    ListView listView;
    String countries[];
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listView = findViewById(R.id.list);
        countries = getResources().getStringArray(R.array.countries);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // when user click an item on the list, it will return to integer
                // click first item, it will return to 0
                // click second item, return to 1 and so on
                String country_name = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(getApplicationContext(), "You selected" + country_name, Toast.LENGTH_LONG).show();
            }
        });
    }
}