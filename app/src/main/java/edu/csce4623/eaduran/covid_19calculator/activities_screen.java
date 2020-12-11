package edu.csce4623.eaduran.covid_19calculator;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

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
    EditText editTextDuration;
    Integer getNumPeopleAround;
    Integer getMinuteAroundPeople;
    String getDistance;
    String getRiskProfile;
    String getActiveCases;
    int counter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activities_screen);
        //Globals
        getNumPeopleAround=Integer.valueOf(this.getIntent().getStringExtra("numPeopleAround"));
        getMinuteAroundPeople=Integer.valueOf(this.getIntent().getStringExtra("getMinuteAroundPeople"));
        getDistance=this.getIntent().getStringExtra("getDistance");
        getActiveCases=this.getIntent().getStringExtra("activeCases");
        back = findViewById(R.id.backButtonActivites);
        submit = findViewById(R.id.activitiesSubmit);
        spinnerVentilation = (Spinner) findViewById(R.id.spinnerVentilation);
        spinnerYourMask = (Spinner) findViewById(R.id.spinnerYourMask);
        spinnerTheirMask = (Spinner) findViewById(R.id.spinnerTheirMask);
        spinnerConversation = (Spinner) findViewById(R.id.spinnerConversation);


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
                int temp = 0;
                temp = Integer.parseInt(selectionPage());
                if(temp>100){
                    openBadResultsPage();
                }else{
                    openGoodResultsPage();
                }
            }
        });

        //adapters and onitemclick getters for spinner



        ArrayAdapter<String> ventilationAdapter = new ArrayAdapter<>(activities_screen.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.ventilation));
        ventilationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerVentilation.setAdapter(ventilationAdapter);

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

}
    public String selectionPage(){
        int riskiness=0;
        String riskinessStr = "";
        riskiness= getClosenes()+(int) getDurationRiskines()+(GetMaskLoad()+getNumPeopleAround+GetTheirMaskLoad())+getConversationRiskines()+getEnvironmentRiskines();
        riskinessStr=String.valueOf(riskiness);
        Log.d("numpeople", String.valueOf(getNumPeopleAround));
        Log.d("getClosenes()", String.valueOf(getClosenes()));
        Log.d("getDurationRiskines()", String.valueOf(getDurationRiskines()));
        Log.d("GetMaskLoad()", String.valueOf(GetMaskLoad()));
        Log.d("GetTheirMaskLoad()", String.valueOf(GetTheirMaskLoad()));
        Log.d("onmentRiskines()", String.valueOf(getEnvironmentRiskines()));
        Log.d("tionRiskines()", String.valueOf(getConversationRiskines()));
        Log.d("##############", String.valueOf(riskiness));
        return riskinessStr;
    }

    private int getEnvironmentRiskines() {
        int envRiskines=0;
        switch (getSpinnerVentilation()) {
            case "Inside[baseline risk]":
                envRiskines = 35;
                break;
            case "Outside[1/20 the risk]":
                envRiskines = 2;
                break;
            case "A train with air filtration[1/4 the risk]":
                envRiskines = 8;
                break;
            case "An airplane[1/6 the risk]":
                envRiskines = 4;
                break;
            case "A moving car with the windows rolled down[1/4 the risk]":
                envRiskines = 8;
                break;
            case "A space with one or more sides open the the outdoors[1/4 the risk]":
                envRiskines = 8;
                break;
        }
        return envRiskines;
    }

    private int getConversationRiskines() {
        int convRiskines=0;
        switch (getSpinnerConversation()) {
            case "Not talking(such as quietly riding the train)[1/5 the risk]":
                convRiskines = 2;
                break;
            case "Normal conversation[baseline risk]":
                convRiskines = 2;
                break;
            case "Loud talking(shouting, talking over music, singing)[5x the risk]":
                convRiskines = 10;
                break;
        }
        return convRiskines;
    }

    private double getDurationRiskines() {
        double durationRiskines=0;
        durationRiskines = (getMinuteAroundPeople/10.0)*5;
        return durationRiskines;
    }

    private int getClosenes() {
        int closenes=0;
        switch (getDistance) {
            case "Kissing [2x the risk]":
                closenes = 25;
                break;
            case "Close (&lt;1ft apart)[2x the risk]":
                closenes = 20;
                break;
            case "Normal socializing (~3ft apart)[baseline risk]":
                closenes = 10;
                break;
            case "6ft[1/2 the risk]":
                closenes = 5;
                break;
            case "10ft[1/4 the risk]":
                closenes = 1;
                break;
        }
        return closenes;
    }

    public int GetMaskLoad(){
        int MaskLoad=0;
        switch (getSpinnerYourMask()) {
            case "No Mask or poorly-worn mask[baseline risk]":
                MaskLoad = 15;
                break;
            case "Cotton mask, bandanna, or buff[baseline risk]":
                MaskLoad = 8;
                break;
            case "Surgical mask or mask with PM2.5 filter insert[1/2 the risk]":
                MaskLoad = 7;
                break;
            case "Well fitting, well sealed N95 respirator[1/10 the risk]":
                MaskLoad = 1;
                break;
        }
        return MaskLoad;
    }public int GetTheirMaskLoad(){
        int MaskLoad=0;
        switch (getSpinnerTheirMask()) {
            case "No Mask or poorly-worn mask[baseline risk]":
                MaskLoad = 15;
                break;
            case "Cotton mask, bandanna, or buff[baseline risk]":
                MaskLoad = 8;
                break;
            case "Surgical mask or mask with PM2.5 filter insert[1/2 the risk]":
                MaskLoad = 7;
                break;
            case "Well fitting, well sealed N95 respirator[1/10 the risk]":
                MaskLoad = 1;
                break;
        }
        return MaskLoad;
    }
    //Getters for spinner
    public String getSpinnerVentilation() {
        String text = spinnerVentilation.getSelectedItem().toString();
        Log.d("SpinnerVentilation", text);
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




    public void openBadResultsPage(){
        if((getSpinnerConversation().equals("Conversation..."))|| getSpinnerTheirMask().equals("Their Mask type...") || getSpinnerVentilation().equals("Environment...") || getSpinnerYourMask().equals("Your mask type...")){
            Toast.makeText(getApplicationContext(),"Please put inputs in all fields",Toast.LENGTH_LONG).show();
        }else {
            Intent intent = new Intent(this, results_screen_bad.class);
            intent.putExtra("selectionPage()", selectionPage());
            startActivity(intent);
        }
    }


    public void openGoodResultsPage(){
        if((getSpinnerConversation().equals("Conversation..."))|| getSpinnerTheirMask().equals("Their Mask type...") || getSpinnerVentilation().equals("Environment...") || getSpinnerYourMask().equals("Your mask type...")){
            Toast.makeText(getApplicationContext(),"Please put inputs in all fields",Toast.LENGTH_LONG).show();
        }else{
            Intent intent = new Intent(this, results_screen_good.class);
            intent.putExtra("selectionPage()", selectionPage());
            startActivity(intent);
        }
    }

    public void openRiskPage(){
        Intent intent = new Intent(this,risk_screen.class);
        startActivity(intent);
    }


}