package edu.csce4623.eaduran.covid_19calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class welcome_screen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button button1;
        Button button2;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        button1 = findViewById(R.id.preSelectedButton);
        button2 = findViewById(R.id.newScenario);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLocationScreen();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLocationScreen();
            }
        });
    }

    public void openLocationScreen(){
        Intent intent = new Intent(this, location_screen.class);
        startActivity(intent);
    }
}
