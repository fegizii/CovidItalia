package com.smafolo.android.coviditalia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create a fake list of regioni.
        ArrayList<String> regioni = new ArrayList<>();
        regioni.add("Toscana");
        regioni.add("Lombardia");
        regioni.add("Lazio");
        regioni.add("Sicilia");

        // Find a reference to the {@link ListView} in the layout
        ListView regioniListView = findViewById(R.id.list_view);

        // Create a new {@link ArrayAdapter} of regioni
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, regioni);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        regioniListView.setAdapter(adapter);

    }
}
