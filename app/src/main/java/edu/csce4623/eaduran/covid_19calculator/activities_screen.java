package edu.csce4623.eaduran.covid_19calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class activities_screen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activities_screen);

        //Globals
        Button back = findViewById(R.id.backButtonActivites);
        Button submit = findViewById(R.id.activitiesSubmit);
        Spinner spinnerInteraction = (Spinner) findViewById(R.id.spinnerInteraction);
        Spinner spinnerVentilation = (Spinner) findViewById(R.id.spinnerVentilation);
        Spinner spinnerDistance = (Spinner) findViewById(R.id.spinnerDistance);
        Spinner spinnerYourMask = (Spinner) findViewById(R.id.spinnerYourMask);
        Spinner spinnerTheirMask = (Spinner) findViewById(R.id.spinnerTheirMask);
        Spinner spinnerConversation = (Spinner) findViewById(R.id.spinnerConversation);
        Spinner spinnerTolerance = (Spinner) findViewById(R.id.spinnerTolerance);


        //Set buttons
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            openRiskPage();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            openResultsPage();
            }
        });

        //Set risk spinner

        ArrayAdapter<String> interactionAdapter = new ArrayAdapter<>(activities_screen.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.interaction));
        interactionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerInteraction.setAdapter(interactionAdapter);

        ArrayAdapter<String> ventilationAdapter = new ArrayAdapter<>(activities_screen.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.ventilation));
        ventilationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerVentilation.setAdapter(ventilationAdapter);

        ArrayAdapter<String> distanceAdapter = new ArrayAdapter<>(activities_screen.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.distance));
        distanceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDistance.setAdapter(distanceAdapter);

        ArrayAdapter<String> yourMaskAdapter = new ArrayAdapter<>(activities_screen.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.yourMask));
        yourMaskAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerYourMask.setAdapter(yourMaskAdapter);

        ArrayAdapter<String> theirMaskAdapter = new ArrayAdapter<>(activities_screen.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.theirMask));
        theirMaskAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTheirMask.setAdapter(theirMaskAdapter);

        ArrayAdapter<String> conversationAdapter = new ArrayAdapter<>(activities_screen.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.conversation));
        conversationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerConversation.setAdapter(conversationAdapter);

        ArrayAdapter<String> toleranceAdapter = new ArrayAdapter<>(activities_screen.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.tolerance));
        toleranceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTolerance.setAdapter(toleranceAdapter);



    }

    public void openResultsPage(){
        Intent intent = new Intent(this,results_screen.class);
        startActivity(intent);
    }
    public void openRiskPage(){
        Intent intent = new Intent(this,risk_screen.class);
        startActivity(intent);
    }
}