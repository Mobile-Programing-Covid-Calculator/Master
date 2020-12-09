package edu.csce4623.eaduran.covid_19calculator;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
//import android.widget.EditText;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class risk_screen extends AppCompatActivity {

    //Globals
    Button back;
    Button submit;
    Spinner spinnerRisk;
    Spinner spinnerDistance;
    EditText peopleNearby;
    EditText minAroundPeople;
    TextView Population;
    TextView Cases;
    private String state;
    private String county;
    String cases;
    String population;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_risk_screen);
        //Globals
        back = findViewById(R.id.backButton3);
        submit = findViewById(R.id.riskSubmit);
        Cases= findViewById(R.id.tvActiveCases);
        Population= findViewById(R.id.tvCountyPopulation);

        spinnerRisk = (Spinner) findViewById(R.id.spinnerRiskProfile);
        spinnerDistance = (Spinner) findViewById(R.id.spinnerAvgDistance);

        peopleNearby = (EditText) findViewById(R.id.riskNumPeopleInput);
        minAroundPeople = (EditText) findViewById(R.id.riskNumPeopleInput2);

        state=this.getIntent().getStringExtra("State");
        county=this.getIntent().getStringExtra("County");
        getInfo();
        Cases.setText(cases);
        Population.setText(population);


        //Set risk spinner

        ArrayAdapter<String> distanceAdapter = new ArrayAdapter<>(risk_screen.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.averageDistance));
        distanceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDistance.setAdapter(distanceAdapter);

        ArrayAdapter<String> riskAdapter = new ArrayAdapter<>(risk_screen.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.riskProfiles));
        riskAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       spinnerRisk.setAdapter(riskAdapter);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLocationScreen();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivitiesPage();
            }
        });

//        getNumPeopleAround();
//        getMinAroundPeople();

    }
    private void getInfo() {
        String json;
        try {
            InputStream inputStream= getAssets().open("covidact.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json= new String(buffer,"UTF-8");
            JSONArray jsonArray = new JSONArray(json);
            for (int i =0; i< jsonArray.length()-1; i++){
                JSONObject obj = jsonArray.getJSONObject(i);
                if((obj.getString("state")).equals(state)&&(obj.getString("county").equals(county))){
                    population="County Population : "+obj.getString("population");
                    String temp=obj.getString("actuals");
                    JSONArray obj2 = new JSONArray("["+temp+"]");
                    JSONObject param1 = obj2.getJSONObject(0);
                    cases= "Active Cases : " + param1.getString("cases");
                }
            }
        } catch (IOException | JSONException e) {
            Log.d("Failed","Error");
            e.printStackTrace();
        }
    }
    public void openLocationScreen(){
        Intent intent = new Intent(this,location_screen.class);
        startActivity(intent);
    }

    public String getNumPeopleAround(){
        String peopleNear = peopleNearby.getText().toString();
        Log.d("Number of people:  ", peopleNear);
        return peopleNear;
    }

    public String getMinAroundPeople(){
        String minAround = minAroundPeople.getText().toString();
        Log.d("Minutes people around  ", minAround);
        return minAround;
    }

    public void openActivitiesPage(){
        Intent intent = new Intent(this,activities_screen.class);
        String temp = getNumPeopleAround();
        String temp2 = getMinAroundPeople();
        Log.d("numPeopleAround", temp);
        Log.d("minAroundPeople", temp2);
        intent.putExtra("numPeopleAround",getNumPeopleAround());
        intent.putExtra("getMinuteAroundPeople",getMinAroundPeople());

        startActivity(intent);
    }

}
