package com.smafolo.android.coviditalia;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create an ArrayList of Regione objects using the basic view constructor
        ArrayList<Regione> regioni = new ArrayList<>();
        regioni.add(new Regione("Toscana", 100, 10));
        regioni.add(new Regione("Lombardia", 50, 20));
        regioni.add(new Regione("Lazio", 100, 30));
        regioni.add(new Regione("Venetao", 6500, 40));
        regioni.add(new Regione("Emilia", 32000, 50));
        regioni.add(new Regione("Toscana", 100, 10));
        regioni.add(new Regione("Lombardia", 50, 20));
        regioni.add(new Regione("Lazio", 100, 30));
        regioni.add(new Regione("Venetao", 6500, 40));
        regioni.add(new Regione("Emilia", 32000, 50));
        regioni.add(new Regione("Toscana", 100, 10));
        regioni.add(new Regione("Lombardia", 50, 20));
        regioni.add(new Regione("Lazio", 100, 30));
        regioni.add(new Regione("Venetao", 6500, 40));
        regioni.add(new Regione("Emilia", 32000, 50));
        regioni.add(new Regione("Toscana", 100, 10));
        regioni.add(new Regione("Lombardia", 50, 20));
        regioni.add(new Regione("Lazio", 100, 30));
        regioni.add(new Regione("Venetao", 6500, 40));
        regioni.add(new Regione("Emilia", 32000, 50));
        regioni.add(new Regione("Toscana", 100, 10));
        regioni.add(new Regione("Lombardia", 50, 20));
        regioni.add(new Regione("Lazio", 100, 30));
        regioni.add(new Regione("Venetao", 6500, 40));
        regioni.add(new Regione("Emilia", 32000, 50));

        // Create a RegioneAdapter, whose data source is a list of regioni. The adapter knows how to create list item views for each item  in the list.
        RegioneAdapter regioneAdapter = new RegioneAdapter(this, regioni);

        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView listView = (ListView) findViewById(R.id.list_view_regioni);
        listView.setAdapter(regioneAdapter);

    }
}
