package edu.csce4623.eaduran.covid_19calculator;

import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import android.widget.AdapterView;
import android.widget.TextView;

public class location_screen extends AppCompatActivity {
    //private Button button;
    private Button backButton;
    private Button submit;
    public static Spinner stateSpinner;
    public static Spinner countySpinner;
    private ArrayAdapter<String> stateAdapter;
    private ArrayAdapter<String> countyAdapter;
    //arraylist for state spinner items
    private ArrayList<String> states;
    private String result = "";

    //covid info list
    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_screen);

        textView2 = findViewById(R.id.textView2);
        //declaring buttons and spinners
        backButton = (Button) findViewById(R.id.backButton);
        submit = (Button) findViewById(R.id.location_submit);
        stateSpinner = (Spinner) findViewById(R.id.state_spinner);
        countySpinner = (Spinner) findViewById(R.id.county_spinner);

        states = new ArrayList<String>();
        // stateSpinner.setOnItemSelectedListener(this);


        stateAdapter = new ArrayAdapter<>(location_screen.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.states));
        stateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        stateSpinner.setAdapter(stateAdapter);


        countyAdapter = new ArrayAdapter<>(location_screen.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.counties));
        countyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countySpinner.setAdapter(countyAdapter);

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

    //static final String BASE_URL = "https://api.covidactnow.org/"; /
    public void openWelcomeScreen(){
        Intent intent = new Intent(this,welcome_screen.class);
        startActivity(intent);
    }
    public void openRiskScreen(){
        Intent intent = new Intent(this,risk_screen.class);
        startActivity(intent);
    }
}