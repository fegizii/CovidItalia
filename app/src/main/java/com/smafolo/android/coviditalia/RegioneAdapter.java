package com.smafolo.android.coviditalia;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.ArrayList;

public class RegioneAdapter extends ArrayAdapter {

    public RegioneAdapter(Activity context, ArrayList<Regione> regioni) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list. The second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for three TextViews the adapter is not going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, regioni);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.regione_list, parent, false);
        }

        // Get the Regione object located at this position in the list
        Regione currentRegione = (Regione) getItem(position);
        int totalePositivi = currentRegione.getTotalePositivi();
        int nuoviPositivi = currentRegione.getNuoviPositivi();
        int aumetopercentuale = (int) Math.round(((double) nuoviPositivi / totalePositivi) *100);

        // Find the TextView in the list_item.xml layout with the ID nome_regione...
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.nome_regione);
        // Get the name from the current Regione object and set this text on the name TextView
        nameTextView.setText(currentRegione.getName());

        // Find the TextView in the list_item.xml layout with the ID totale_positivi)
        TextView totalePositiviTextView = (TextView) listItemView.findViewById(R.id.totale_positivi);
        // Get the Totale Positivi number from the current Regione object and set this text on the TextView
        totalePositiviTextView.setText("Totale Positivi: " + NumberFormat.getInstance().format(totalePositivi)); //TODO try not to use hard coded strings


        // Find the TextView in the list_item.xml layout with the ID nuovi_positivi
        TextView nuoviPositiviTextView = (TextView) listItemView.findViewById(R.id.nuovi_positivi);
        // Get the image resource ID from the current AndroidFlavor object and set the image to iconView
        nuoviPositiviTextView.setText("Nuovi Positivi: " + NumberFormat.getInstance().format(nuoviPositivi) + " (" + aumetopercentuale+ "%)"); //TODO try not to use hard coded strings

        // Return the whole list item layout so that it can be shown in the ListView
        return listItemView;
    }

}
