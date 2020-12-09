package edu.csce4623.eaduran.covid_19calculator;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import android.widget.Toast;

//import edu.csce4623.eaduran.covid_19calculator.API.CovidInfo;
//import edu.csce4623.eaduran.covid_19calculator.API.CovidInfoAPI;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class location_screen extends AppCompatActivity {//implements Callback<List<CovidInfo>> {

    private Button backButton;
    private Button submit;
    public static Spinner stateSpinner;
    public static Spinner countySpinner;
    private ArrayAdapter<String> stateAdapter;
    private ArrayAdapter<String> countyAdapter;
    //arraylist for state spinner items
    private ArrayList<String> statesList;
    private ArrayList<String> countiesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_screen);
        getJsonState();
        countiesList= new ArrayList<String>();
        countiesList.add("Counties");

        backButton = (Button) findViewById(R.id.backButton);
        submit = (Button) findViewById(R.id.location_submit);
        stateSpinner = (Spinner) findViewById(R.id.state_spinner);
        countySpinner = (Spinner) findViewById(R.id.county_spinner);


        countyAdapter = new ArrayAdapter<>(location_screen.this,
                android.R.layout.simple_list_item_1, countiesList);
        countyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countySpinner.setAdapter(countyAdapter);

        stateAdapter = new ArrayAdapter<>(location_screen.this,
                android.R.layout.simple_list_item_1, statesList);
        stateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        stateSpinner.setAdapter(stateAdapter);
        stateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(stateSpinner.getSelectedItemPosition()!=0){
                    countiesList.removeAll(countiesList);
                    getCounties(getState());
                    countyAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Log.d("Failed", "Failed");
            }
        });


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWelcomeScreen();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRiskScreen();
            }
        });
        
    }

    private void getCounties(String State) {
        String json;
        try {
            InputStream inputStream= getAssets().open("covidact.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json= new String(buffer,"UTF-8");
            JSONArray jsonArray = new JSONArray(json);
            countiesList.add("Counties");
            for (int i =0; i< jsonArray.length()-1; i++){
                JSONObject obj = jsonArray.getJSONObject(i);
                if(obj.getString("state").equals(State)){
                        countiesList.add(obj.getString("county"));
                }
            }
        } catch (IOException | JSONException e) {
            Log.d("Failed","Error");
            e.printStackTrace();
        }
    }

    private void getJsonState() {
        String json;
        try {
            InputStream inputStream= getAssets().open("covidact.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json= new String(buffer,"UTF-8");
            JSONArray jsonArray = new JSONArray(json);
            statesList= new ArrayList<String>();
            statesList.add("States");
            for (int i =0; i< jsonArray.length()-1; i++){
                JSONObject obj = jsonArray.getJSONObject(i);
                JSONObject obj2 =jsonArray.getJSONObject(i+1);
                if(!(obj.getString("state")).equals(obj2.getString("state"))){
                    statesList.add(obj.getString("state"));
                }
            }
        } catch (IOException | JSONException e) {
            Log.d("Failed","Error");
            e.printStackTrace();
        }
    }
    public String getState() {
        String text = stateSpinner.getSelectedItem().toString();
        Log.d("Selected State", text);
        return text;
    }
    public String getCounty() {
        String text = countySpinner.getSelectedItem().toString();
        Log.d("Selected State", text);
        return text;
    }
    public void openWelcomeScreen() {
        Intent intent = new Intent(this,welcome_screen.class);
        startActivity(intent);
    }
    public void openRiskScreen() {
        String state= getState();
        String county= getCounty();
        if (state.equals("States") || county.equals("Counties")){
            Toast.makeText(getApplicationContext(),"Please select a State and a County",Toast.LENGTH_LONG).show();
        }else {
            Intent intent = new Intent(this, risk_screen.class);
            intent.putExtra("State",state);
            intent.putExtra("County", county);
            startActivity(intent);
        }
    }
}