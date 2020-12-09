package edu.csce4623.eaduran.covid_19calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class results_screen_good extends AppCompatActivity {
    Button newTest;
    Button btnFAQResults;
    Button backToRisk;
//    private TextView riskNumPeople;
//    private TextView resultsRisk2;
//    private TextView resultsRiskAllocation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_results_screen_good);


        newTest = findViewById(R.id.newtestButton);
        btnFAQResults = findViewById(R.id.btnFAQResults);
        backToRisk = findViewById(R.id.backButton3);

        //Open FAQ/Resources page
        btnFAQResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFAQScreen();
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

    public void openFAQScreen(){
        Intent intent = new Intent(this,faq_screen.class);
        startActivity(intent);
    }

}