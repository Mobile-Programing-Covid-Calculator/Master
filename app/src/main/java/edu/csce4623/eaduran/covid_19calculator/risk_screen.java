package edu.csce4623.eaduran.covid_19calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class risk_screen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_risk_screen);
        //Globals
        Button back2 = findViewById(R.id.backButton2);
        Button submit = findViewById(R.id.location_submit);
        Spinner spinnerRisk = (Spinner) findViewById(R.id.spinnerRiskProfile);

        //Set

        ArrayAdapter<String> riskAdapter = new ArrayAdapter<>(risk_screen.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.riskProfiles));
        riskAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       spinnerRisk.setAdapter(riskAdapter);

        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLocationScreen();
            }
        });
    }
    public void openLocationScreen(){
        Intent intent = new Intent(this,location_screen.class);
        startActivity(intent);
    }
}
