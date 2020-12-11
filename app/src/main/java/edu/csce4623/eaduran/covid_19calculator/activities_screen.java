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
                selectionPage();
                if(selectionPage()>500){
                    openBadResultsPage();
                }else{
                    openBadResultsPage();
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
    public int selectionPage(){
        int riskiness=0;
        int MaskRiskines=GetMaskLoad()*getNumPeopleAround;
        int closenesRiskines= getClosenes();
        int durationRiskines= getDurationRiskines();


        return riskiness;
    }

    private int getDurationRiskines() {
        int durationRiskines=(getMinuteAroundPeople/30)*6;;
        return durationRiskines;
    }

    private int getClosenes() {
        int closenes=0;
        if(getDistance=="Kissing[2x the risk"){
            closenes=50;
        }else if(getDistance=="Close (&lt;1ft apart)[2x the risk]"){
            closenes=30;
        }else if(getDistance=="Normal socializing (~3ft apart)[baseline risk]"){
            closenes=10;
        }else if(getDistance=="6ft[1/2 the risk]"){
            closenes=5;
        }else if(getDistance=="10ft[1/4 the risk]"){
            closenes=1;
        }
        return closenes;
    }

    public int GetMaskLoad(){
        int MaskLoad=0;
        if(getSpinnerYourMask()=="No Mask or poorly-worn[baseline risk]"){
            MaskLoad=5;
        }
        else if(getSpinnerYourMask()=="Cotton mask, bandanna, or buff[baseline risk]") {
            MaskLoad=3;
        }
        else if(getSpinnerYourMask()=="Surgical mask or mask with PM2.5 filter insert[1/2 the risk]") {
            MaskLoad=2;
        }
        else if(getSpinnerYourMask()=="Well fitting, well sealed N95 respirator[1/10 the risk]") {
            MaskLoad=1;
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
            startActivity(intent);
        }
    }


    public void openGoodResultsPage(){
        if((getSpinnerConversation().equals("Conversation..."))|| getSpinnerTheirMask().equals("Their Mask type...") || getSpinnerVentilation().equals("Environment...") || getSpinnerYourMask().equals("Your mask type...")){
            Toast.makeText(getApplicationContext(),"Please put inputs in all fields",Toast.LENGTH_LONG).show();
        }else{
            Intent intent = new Intent(this, results_screen_good.class);
            startActivity(intent);
        }
    }

    public void openRiskPage(){
        Intent intent = new Intent(this,risk_screen.class);
        startActivity(intent);
    }


}