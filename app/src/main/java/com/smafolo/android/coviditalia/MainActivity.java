package com.smafolo.android.coviditalia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create an ArrayList of "Regione" objects
        ArrayList<Regione> regioni = new ArrayList<>();

        //Load data from Protezione Civile
        String SAMPLE_REGIONI_RESPONSE = "[ { \"data\": \"2020-05-07T17:00:00\", \"stato\": \"ITA\", \"codice_regione\": 13, \"denominazione_regione\": \"Abruzzo\", \"lat\": 42.35122196, \"long\": 13.39843823, \"ricoverati_con_sintomi\": 263, \"terapia_intensiva\": 12, \"totale_ospedalizzati\": 275, \"isolamento_domiciliare\": 1495, \"totale_positivi\": 1770, \"variazione_totale_positivi\": -21, \"nuovi_positivi\": 25, \"dimessi_guariti\": 954, \"deceduti\": 348, \"totale_casi\": 3072, \"tamponi\": 45021, \"casi_testati\": 32186, \"note_it\": \"\", \"note_en\": \"\" }, { \"data\": \"2020-05-07T17:00:00\", \"stato\": \"ITA\", \"codice_regione\": 17, \"denominazione_regione\": \"Basilicata\", \"lat\": 40.63947052, \"long\": 15.80514834, \"ricoverati_con_sintomi\": 48, \"terapia_intensiva\": 2, \"totale_ospedalizzati\": 50, \"isolamento_domiciliare\": 105, \"totale_positivi\": 155, \"variazione_totale_positivi\": -17, \"nuovi_positivi\": -16, \"dimessi_guariti\": 202, \"deceduti\": 26, \"totale_casi\": 383, \"tamponi\": 16272, \"casi_testati\": 15780, \"note_it\": \"dc-IT-0022\", \"note_en\": \"dc-EN-0022\" }, { \"data\": \"2020-05-07T17:00:00\", \"stato\": \"ITA\", \"codice_regione\": 4, \"denominazione_regione\": \"P.A. Bolzano\", \"lat\": 46.49933453, \"long\": 11.35662422, \"ricoverati_con_sintomi\": 87, \"terapia_intensiva\": 11, \"totale_ospedalizzati\": 98, \"isolamento_domiciliare\": 453, \"totale_positivi\": 551, \"variazione_totale_positivi\": -28, \"nuovi_positivi\": 9, \"dimessi_guariti\": 1715, \"deceduti\": 286, \"totale_casi\": 2552, \"tamponi\": 47091, \"casi_testati\": 21284, \"note_it\": \"\", \"note_en\": \"\" }, { \"data\": \"2020-05-07T17:00:00\", \"stato\": \"ITA\", \"codice_regione\": 18, \"denominazione_regione\": \"Calabria\", \"lat\": 38.90597598, \"long\": 16.59440194, \"ricoverati_con_sintomi\": 81, \"terapia_intensiva\": 2, \"totale_ospedalizzati\": 83, \"isolamento_domiciliare\": 550, \"totale_positivi\": 633, \"variazione_totale_positivi\": -11, \"nuovi_positivi\": 3, \"dimessi_guariti\": 403, \"deceduti\": 89, \"totale_casi\": 1125, \"tamponi\": 42854, \"casi_testati\": 40806, \"note_it\": \"\", \"note_en\": \"\" }, { \"data\": \"2020-05-07T17:00:00\", \"stato\": \"ITA\", \"codice_regione\": 15, \"denominazione_regione\": \"Campania\", \"lat\": 40.83956555, \"long\": 14.25084984, \"ricoverati_con_sintomi\": 415, \"terapia_intensiva\": 27, \"totale_ospedalizzati\": 442, \"isolamento_domiciliare\": 1697, \"totale_positivi\": 2139, \"variazione_totale_positivi\": -201, \"nuovi_positivi\": 9, \"dimessi_guariti\": 2023, \"deceduti\": 379, \"totale_casi\": 4541, \"tamponi\": 101025, \"casi_testati\": 50463, \"note_it\": \"\", \"note_en\": \"\" }, { \"data\": \"2020-05-07T17:00:00\", \"stato\": \"ITA\", \"codice_regione\": 8, \"denominazione_regione\": \"Emilia-Romagna\", \"lat\": 44.49436681, \"long\": 11.3417208, \"ricoverati_con_sintomi\": 1726, \"terapia_intensiva\": 173, \"totale_ospedalizzati\": 1899, \"isolamento_domiciliare\": 6112, \"totale_positivi\": 8011, \"variazione_totale_positivi\": -380, \"nuovi_positivi\": 108, \"dimessi_guariti\": 14710, \"deceduti\": 3766, \"totale_casi\": 26487, \"tamponi\": 217039, \"casi_testati\": 141468, \"note_it\": \"\", \"note_en\": \"\" }, { \"data\": \"2020-05-07T17:00:00\", \"stato\": \"ITA\", \"codice_regione\": 6, \"denominazione_regione\": \"Friuli Venezia Giulia\", \"lat\": 45.6494354, \"long\": 13.76813649, \"ricoverati_con_sintomi\": 109, \"terapia_intensiva\": 2, \"totale_ospedalizzati\": 111, \"isolamento_domiciliare\": 816, \"totale_positivi\": 927, \"variazione_totale_positivi\": -35, \"nuovi_positivi\": 13, \"dimessi_guariti\": 1872, \"deceduti\": 308, \"totale_casi\": 3107, \"tamponi\": 82012, \"casi_testati\": 51123, \"note_it\": \"\", \"note_en\": \"\" }, { \"data\": \"2020-05-07T17:00:00\", \"stato\": \"ITA\", \"codice_regione\": 12, \"denominazione_regione\": \"Lazio\", \"lat\": 41.89277044, \"long\": 12.48366722, \"ricoverati_con_sintomi\": 1291, \"terapia_intensiva\": 89, \"totale_ospedalizzati\": 1380, \"isolamento_domiciliare\": 2968, \"totale_positivi\": 4348, \"variazione_totale_positivi\": -85, \"nuovi_positivi\": 39, \"dimessi_guariti\": 2143, \"deceduti\": 543, \"totale_casi\": 7034, \"tamponi\": 165340, \"casi_testati\": 130351, \"note_it\": \"\", \"note_en\": \"\" }, { \"data\": \"2020-05-07T17:00:00\", \"stato\": \"ITA\", \"codice_regione\": 7, \"denominazione_regione\": \"Liguria\", \"lat\": 44.41149315, \"long\": 8.9326992, \"ricoverati_con_sintomi\": 525, \"terapia_intensiva\": 57, \"totale_ospedalizzati\": 582, \"isolamento_domiciliare\": 2666, \"totale_positivi\": 3248, \"variazione_totale_positivi\": -58, \"nuovi_positivi\": 94, \"dimessi_guariti\": 4143, \"deceduti\": 1254, \"totale_casi\": 8645, \"tamponi\": 61446, \"casi_testati\": 38071, \"note_it\": \"\", \"note_en\": \"\" }, { \"data\": \"2020-05-07T17:00:00\", \"stato\": \"ITA\", \"codice_regione\": 3, \"denominazione_regione\": \"Lombardia\", \"lat\": 45.46679409, \"long\": 9.190347404, \"ricoverati_con_sintomi\": 5848, \"terapia_intensiva\": 480, \"totale_ospedalizzati\": 6328, \"isolamento_domiciliare\": 25687, \"totale_positivi\": 32015, \"variazione_totale_positivi\": 262, \"nuovi_positivi\": 720, \"dimessi_guariti\": 33329, \"deceduti\": 14745, \"totale_casi\": 80089, \"tamponi\": 455294, \"casi_testati\": 262964, \"note_it\": \"\", \"note_en\": \"\" }, { \"data\": \"2020-05-07T17:00:00\", \"stato\": \"ITA\", \"codice_regione\": 11, \"denominazione_regione\": \"Marche\", \"lat\": 43.61675973, \"long\": 13.5188753, \"ricoverati_con_sintomi\": 328, \"terapia_intensiva\": 41, \"totale_ospedalizzati\": 369, \"isolamento_domiciliare\": 2878, \"totale_positivi\": 3247, \"variazione_totale_positivi\": 11, \"nuovi_positivi\": 31, \"dimessi_guariti\": 2257, \"deceduti\": 948, \"totale_casi\": 6452, \"tamponi\": 71017, \"casi_testati\": 46258, \"note_it\": \"\", \"note_en\": \"\" }, { \"data\": \"2020-05-07T17:00:00\", \"stato\": \"ITA\", \"codice_regione\": 14, \"denominazione_regione\": \"Molise\", \"lat\": 41.55774754, \"long\": 14.65916051, \"ricoverati_con_sintomi\": 8, \"terapia_intensiva\": 0, \"totale_ospedalizzati\": 8, \"isolamento_domiciliare\": 162, \"totale_positivi\": 170, \"variazione_totale_positivi\": -9, \"nuovi_positivi\": 1, \"dimessi_guariti\": 113, \"deceduti\": 22, \"totale_casi\": 305, \"tamponi\": 8237, \"casi_testati\": 7912, \"note_it\": \"\", \"note_en\": \"\" }, { \"data\": \"2020-05-07T17:00:00\", \"stato\": \"ITA\", \"codice_regione\": 1, \"denominazione_regione\": \"Piemonte\", \"lat\": 45.0732745, \"long\": 7.680687483, \"ricoverati_con_sintomi\": 2147, \"terapia_intensiva\": 150, \"totale_ospedalizzati\": 2297, \"isolamento_domiciliare\": 12172, \"totale_positivi\": 14469, \"variazione_totale_positivi\": -389, \"nuovi_positivi\": 196, \"dimessi_guariti\": 10384, \"deceduti\": 3282, \"totale_casi\": 28135, \"tamponi\": 194584, \"casi_testati\": 134567, \"note_it\": \"\", \"note_en\": \"\" }, { \"data\": \"2020-05-07T17:00:00\", \"stato\": \"ITA\", \"codice_regione\": 16, \"denominazione_regione\": \"Puglia\", \"lat\": 41.12559576, \"long\": 16.86736689, \"ricoverati_con_sintomi\": 355, \"terapia_intensiva\": 35, \"totale_ospedalizzati\": 390, \"isolamento_domiciliare\": 2410, \"totale_positivi\": 2800, \"variazione_totale_positivi\": -103, \"nuovi_positivi\": 49, \"dimessi_guariti\": 1004, \"deceduti\": 441, \"totale_casi\": 4245, \"tamponi\": 72796, \"casi_testati\": 51638, \"note_it\": \"\", \"note_en\": \"\" }, { \"data\": \"2020-05-07T17:00:00\", \"stato\": \"ITA\", \"codice_regione\": 20, \"denominazione_regione\": \"Sardegna\", \"lat\": 39.21531192, \"long\": 9.110616306, \"ricoverati_con_sintomi\": 90, \"terapia_intensiva\": 9, \"totale_ospedalizzati\": 99, \"isolamento_domiciliare\": 484, \"totale_positivi\": 583, \"variazione_totale_positivi\": -40, \"nuovi_positivi\": 5, \"dimessi_guariti\": 622, \"deceduti\": 119, \"totale_casi\": 1324, \"tamponi\": 31064, \"casi_testati\": 27540, \"note_it\": \"\", \"note_en\": \"\" }, { \"data\": \"2020-05-07T17:00:00\", \"stato\": \"ITA\", \"codice_regione\": 19, \"denominazione_regione\": \"Sicilia\", \"lat\": 38.11569725, \"long\": 13.3623567, \"ricoverati_con_sintomi\": 349, \"terapia_intensiva\": 21, \"totale_ospedalizzati\": 370, \"isolamento_domiciliare\": 1757, \"totale_positivi\": 2127, \"variazione_totale_positivi\": -74, \"nuovi_positivi\": 7, \"dimessi_guariti\": 910, \"deceduti\": 251, \"totale_casi\": 3288, \"tamponi\": 95695, \"casi_testati\": 85674, \"note_it\": \"\", \"note_en\": \"\" }, { \"data\": \"2020-05-07T17:00:00\", \"stato\": \"ITA\", \"codice_regione\": 9, \"denominazione_regione\": \"Toscana\", \"lat\": 43.76923077, \"long\": 11.25588885, \"ricoverati_con_sintomi\": 437, \"terapia_intensiva\": 91, \"totale_ospedalizzati\": 528, \"isolamento_domiciliare\": 4188, \"totale_positivi\": 4716, \"variazione_totale_positivi\": -372, \"nuovi_positivi\": 26, \"dimessi_guariti\": 4052, \"deceduti\": 915, \"totale_casi\": 9683, \"tamponi\": 166062, \"casi_testati\": 124295, \"note_it\": \"\", \"note_en\": \"\" }, { \"data\": \"2020-05-07T17:00:00\", \"stato\": \"ITA\", \"codice_regione\": 4, \"denominazione_regione\": \"P.A. Trento\", \"lat\": 46.06893511, \"long\": 11.12123097, \"ricoverati_con_sintomi\": 99, \"terapia_intensiva\": 11, \"totale_ospedalizzati\": 110, \"isolamento_domiciliare\": 800, \"totale_positivi\": 910, \"variazione_totale_positivi\": -72, \"nuovi_positivi\": 3, \"dimessi_guariti\": 2935, \"deceduti\": 438, \"totale_casi\": 4283, \"tamponi\": 46500, \"casi_testati\": 28486, \"note_it\": \"\", \"note_en\": \"\" }, { \"data\": \"2020-05-07T17:00:00\", \"stato\": \"ITA\", \"codice_regione\": 10, \"denominazione_regione\": \"Umbria\", \"lat\": 43.10675841, \"long\": 12.38824698, \"ricoverati_con_sintomi\": 47, \"terapia_intensiva\": 9, \"totale_ospedalizzati\": 56, \"isolamento_domiciliare\": 85, \"totale_positivi\": 141, \"variazione_totale_positivi\": -30, \"nuovi_positivi\": 1, \"dimessi_guariti\": 1194, \"deceduti\": 70, \"totale_casi\": 1405, \"tamponi\": 42788, \"casi_testati\": 29708, \"note_it\": \"\", \"note_en\": \"\" }, { \"data\": \"2020-05-07T17:00:00\", \"stato\": \"ITA\", \"codice_regione\": 2, \"denominazione_regione\": \"Valle d'Aosta\", \"lat\": 45.73750286, \"long\": 7.320149366, \"ricoverati_con_sintomi\": 49, \"terapia_intensiva\": 2, \"totale_ospedalizzati\": 51, \"isolamento_domiciliare\": 79, \"totale_positivi\": 130, \"variazione_totale_positivi\": 3, \"nuovi_positivi\": 4, \"dimessi_guariti\": 881, \"deceduti\": 139, \"totale_casi\": 1150, \"tamponi\": 8939, \"casi_testati\": 6702, \"note_it\": \"\", \"note_en\": \"\" }, { \"data\": \"2020-05-07T17:00:00\", \"stato\": \"ITA\", \"codice_regione\": 5, \"denominazione_regione\": \"Veneto\", \"lat\": 45.43490485, \"long\": 12.33845213, \"ricoverati_con_sintomi\": 872, \"terapia_intensiva\": 87, \"totale_ospedalizzati\": 959, \"isolamento_domiciliare\": 5575, \"totale_positivi\": 6534, \"variazione_totale_positivi\": -255, \"nuovi_positivi\": 74, \"dimessi_guariti\": 10430, \"deceduti\": 1589, \"totale_casi\": 18553, \"tamponi\": 410212, \"casi_testati\": 236281, \"note_it\": \"\", \"note_en\": \"\" } ]";

        //Create teh JSON Array from the string
        JSONArray jsonArrayRegioni = null;
        try {
            jsonArrayRegioni = new JSONArray(SAMPLE_REGIONI_RESPONSE);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //Loop inside the array to create each regione
        assert jsonArrayRegioni != null;
        for (int i = 0; i < jsonArrayRegioni.length(); i++) {

            JSONObject currentRegione = null;
            try {
                currentRegione = jsonArrayRegioni.getJSONObject(i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            String name = null;
            try {
                assert currentRegione != null;
                name = currentRegione.getString("denominazione_regione");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            int totalePositivi = 0;
            try {
                totalePositivi = currentRegione.getInt("totale_positivi");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            int nuovipositivi = 0;
            try {
                nuovipositivi = currentRegione.getInt("nuovi_positivi");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            //Add to array regioni using the view constructor
            regioni.add(new Regione(name, totalePositivi, nuovipositivi));
        }


        // Create a RegioneAdapter, whose data source is a list of regioni. The adapter knows how to create list item views for each item  in the list.
        final RegioneAdapter regioneAdapter = new RegioneAdapter(this, regioni);

        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView regioniListView = findViewById(R.id.list_view_regioni);
        regioniListView.setAdapter(regioneAdapter);

        // Set an item click listener on the ListView.
        regioniListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                // Find the current regione that was clicked on
                Regione currentRegione = (Regione) regioneAdapter.getItem(position);

                //Intent to open activity DettaglioProvince
                Intent myIntent = new Intent(MainActivity.this, DettaglioProvince.class);
                myIntent.putExtra("Regione Cliccata", currentRegione.getName()); //Optional parameters
                MainActivity.this.startActivity(myIntent);


            }
        });


    }
}
