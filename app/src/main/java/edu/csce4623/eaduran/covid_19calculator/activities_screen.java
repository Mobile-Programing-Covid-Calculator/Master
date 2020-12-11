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
    String getNumPeopleAround;
    String getMinuteAroundPeople;
    String getDistance;
    String getRiskProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activities_screen);

        //Globals
        getNumPeopleAround=this.getIntent().getStringExtra("numPeopleAround");;
        getMinuteAroundPeople=this.getIntent().getStringExtra("getMinuteAroundPeople");;
        getDistance=this.getIntent().getStringExtra("getDistance");;
        getRiskProfile=this.getIntent().getStringExtra("getRiskProfile");;
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
            }
        });

        //adapters and onitemclick getters for spinner



        ArrayAdapter<String> ventilationAdapter = new ArrayAdapter<>(activities_screen.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.ventilation));
        ventilationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerVentilation.setAdapter(ventilationAdapter);

        spinnerVentilation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                getSpinnerVentilation();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });




        ArrayAdapter<String> yourMaskAdapter = new ArrayAdapter<>(activities_screen.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.yourMask));
        yourMaskAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerYourMask.setAdapter(yourMaskAdapter);

        spinnerYourMask.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                getSpinnerYourMask();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });




        ArrayAdapter<String> theirMaskAdapter = new ArrayAdapter<>(activities_screen.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.theirMask));
        theirMaskAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTheirMask.setAdapter(theirMaskAdapter);

        spinnerTheirMask.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                getSpinnerTheirMask();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


//get the bad screen to display

        ArrayAdapter<String> conversationAdapter = new ArrayAdapter<>(activities_screen.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.conversation));
        conversationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerConversation.setAdapter(conversationAdapter);

        spinnerConversation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                String text = getSpinnerConversation();
//
//                if(text=="Loud talking(shouting, talking over music, singing)[5x the risk]"){
//                    isBad=true;
//                    if(isBad==true){
//                        Log.d("TRUE!!!!!!!!!!!!", "SOOOOOOOO TRUEEE!!!!!!");
//                    }
//                }
                getSpinnerConversation();


            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

}


    //Getters for spinners

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

    public void selectionPage(){

        //String text = getSpinnerConversation();
       // Log.d("getSpinnerConvo", text);
        int test = spinnerConversation.getSelectedItemPosition();
        String testS = Integer.toString(test);
        Log.d("TESTSSSSSSSSSSSSSSSSS: ", testS);
        if(spinnerConversation.getSelectedItemPosition()==3){
                openBadResultsPage();
                Log.d("TRUE!!!!!!!!!!!!", "SOOOOOOOO TRUEEE!!!!!!");
            }
            else{
                openGoodResultsPage();
            }

        }


    public void openBadResultsPage(){
        Intent intent = new Intent(this, results_screen_bad.class);
        startActivity(intent);
//        String temp = getDuration();
//        Log.d("DURATION", getDuration());
//        intent.putExtra("getDuration",getDuration());
    }


    public void openGoodResultsPage(){
        if((getSpinnerConversation().equals("Conversation..."))|| getSpinnerTheirMask().equals("Their Mask type...") || getSpinnerVentilation().equals("Environment...") || getSpinnerYourMask().equals("Your mask type...")){
            Toast.makeText(getApplicationContext(),"Please put inputs in all fields",Toast.LENGTH_LONG).show();
        }else{
            Intent intent = new Intent(this, results_screen_good.class);
            startActivity(intent);
        }
//        String temp = getDuration();
//        Log.d("DURATION", getDuration());
//        intent.putExtra("getDuration",getDuration());
    }

    public void openRiskPage(){
        if((getSpinnerConversation().equals("Conversation..."))|| getSpinnerTheirMask().equals("Their Mask type...") || getSpinnerVentilation().equals("Environment...") || getSpinnerYourMask().equals("Your mask type...")){
            Toast.makeText(getApplicationContext(),"Please put inputs in all fields",Toast.LENGTH_LONG).show();
        }else {
            Intent intent = new Intent(this, risk_screen.class);
            startActivity(intent);
        }
    }


}