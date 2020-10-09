package edu.csce4623.eaduran.covid_19calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class location_screen extends AppCompatActivity {
    //private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_screen);
      //  Button backButton = (Button) findViewById(R.id.backButton);
       // Spinner stateSpinner = (Spinner) findViewById(R.id.state_spinner);

       // ArrayAdapter<String> stateAdapter = new ArrayAdapter<>(location_screen.this,
          //      android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.states));
       // stateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       // stateSpinner.setAdapter(stateAdapter);
    }
}