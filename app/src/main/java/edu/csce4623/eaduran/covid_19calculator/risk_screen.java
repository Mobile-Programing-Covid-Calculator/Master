package edu.csce4623.eaduran.covid_19calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class risk_screen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button back = findViewById(R.id.backButton);
        Button submit = findViewById(R.id.location_submit);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_risk_screen);

        back.setOnClickListener(new View.OnClickListener() {
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
