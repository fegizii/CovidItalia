package com.smafolo.android.coviditalia;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.ArrayList;

public class ProvinceAdapter extends ArrayAdapter {

    public ProvinceAdapter(Activity context, ArrayList<Provincia> province) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list. The second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for three TextViews the adapter is not going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, province);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.province_list, parent, false);     //TODO adapt to province
        }

        // Get the Regione object located at this position in the list
        Provincia currentProvincia = (Provincia) getItem(position);

        // Find the TextView in the list_item.xml layout with the ID nome_provincia
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.nome_provincia);
        // Get the name from the current Regione object and set this text on the name TextView
        nameTextView.setText(currentProvincia.getmNome());

        // Find the TextView in the list_item.xml layout with the ID totale_casi
        TextView totalePositiviTextView = (TextView) listItemView.findViewById(R.id.totale_casi);
        // Get the Totale Positivi number from the current Regione object and set this text on the TextView
        totalePositiviTextView.setText("Totale Casi: " + NumberFormat.getInstance().format(currentProvincia.getmTotaleCasi())); //TODO try not to use hard coded strings

        // Return the whole list item layout so that it can be shown in the ListView
        return listItemView;
    }

}
