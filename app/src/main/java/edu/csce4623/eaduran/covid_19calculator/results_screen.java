package edu.csce4623.eaduran.covid_19calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class results_screen extends AppCompatActivity {
    Button newTest;
    Button faqResources;
    Button backToRisk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_screen);

        newTest = findViewById(R.id.newtestButton);
        faqResources = findViewById(R.id.resultsFAQButton);
        backToRisk = findViewById(R.id.backButton3);

        //Open FAQ/Resources page
        faqResources.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

//Start new test
        newTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            openNewTest();
            }
        });
    }

    public void openNewTest(){
        Intent intent = new Intent(this,location_screen.class);
        startActivity(intent);
    }

    public void openRiskScreen(){
        Intent intent = new Intent(this,risk_screen.class);
        startActivity(intent);
    }


//    public void openFaqScreen(){
//        Intent intent = new Intent(this,location_screen.class);
//        startActivity(intent);
//    }

}