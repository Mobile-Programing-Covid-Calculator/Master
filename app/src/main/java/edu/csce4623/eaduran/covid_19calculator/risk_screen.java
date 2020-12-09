package edu.csce4623.eaduran.covid_19calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
//import android.widget.EditText;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class risk_screen extends AppCompatActivity {
    private Button back ;
    private  Button submit ;
    private Spinner spinnerRisk ;
    private  Spinner spinnerDistance ;
    private  EditText peopleNearby ;
    private  EditText minAroundPeople ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_risk_screen);
        //Globals
        back = findViewById(R.id.backButton3);
        submit = findViewById(R.id.riskSubmit);
        spinnerRisk = (Spinner) findViewById(R.id.spinnerRiskProfile);
        spinnerDistance = (Spinner) findViewById(R.id.spinnerAvgDistance);
        peopleNearby = (EditText) findViewById(R.id.riskNumPeopleInput);
        minAroundPeople = (EditText) findViewById(R.id.riskNumPeopleInput2);


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



    }
    public void openLocationScreen(){
        Intent intent = new Intent(this,location_screen.class);
        startActivity(intent);
    }

    public int getNumPeopleAround(){
        int numPeople = Integer.parseInt(peopleNearby.getText().toString());

        return numPeople;
    }

    public int getMinAroundPeople(){
        int minAround = Integer.parseInt(minAroundPeople.getText().toString());
        return minAround;
    }

    public void openActivitiesPage(){
        Intent intent = new Intent(this,activities_screen.class);
        intent.putExtra("numPeopleAround",getNumPeopleAround());
        intent.putExtra("getMinuteAroundPeople",getMinAroundPeople());
        startActivity(intent);
    }

}