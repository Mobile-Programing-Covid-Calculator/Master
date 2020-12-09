package edu.csce4623.eaduran.covid_19calculator;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class activities_screen extends AppCompatActivity {

    Button back;
    Button submit;
    Spinner spinnerInteraction;
    Spinner spinnerVentilation;
    Spinner spinnerDistance;
    Spinner spinnerYourMask;
    Spinner spinnerTheirMask;
    Spinner spinnerConversation;
    Spinner spinnerTolerance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activities_screen);

        //Globals
        back = findViewById(R.id.backButtonActivites);
        submit = findViewById(R.id.activitiesSubmit);
        spinnerInteraction = (Spinner) findViewById(R.id.spinnerInteraction);
        spinnerVentilation = (Spinner) findViewById(R.id.spinnerVentilation);
        spinnerDistance = (Spinner) findViewById(R.id.spinnerDistance);
        spinnerYourMask = (Spinner) findViewById(R.id.spinnerYourMask);
        spinnerTheirMask = (Spinner) findViewById(R.id.spinnerTheirMask);
        spinnerConversation = (Spinner) findViewById(R.id.spinnerConversation);
        spinnerTolerance = (Spinner) findViewById(R.id.spinnerTolerance);


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

if(toleranceAdapter!=null){

}

    }
    //Getters for spinners
    public String getSpinnerInteraction() {
        String text = spinnerInteraction.getSelectedItem().toString();
        Log.d("SpinnerInteraction", text);
        return text;
    }

    public String getSpinnerVentilation() {
        String text = spinnerVentilation.getSelectedItem().toString();
        Log.d("SpinnerVentilation", text);
        return text;
    }

    public String getSpinnerDistance() {
        String text = spinnerDistance.getSelectedItem().toString();
        Log.d("SpinnerDistance", text);
        return text;
    }

    public String getSpinnerYourMask() {
        String text = spinnerYourMask.getSelectedItem().toString();
        Log.d("SpinnerYourMask", text);
        return text;
    }

    public String getSpinnerTheirMask() {
        String text = spinnerTheirMask.getSelectedItem().toString();
        Log.d("SpinnerTheirMask", text);
        return text;
    }

    public String getSpinnerConversation() {
        String text = spinnerConversation.getSelectedItem().toString();
        Log.d("SpinnerConversation", text);
        return text;
    }

    public String getSpinnerTolerance() {
        String text = spinnerTolerance.getSelectedItem().toString();
        Log.d("SpinnerTolerance", text);
        return text;
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