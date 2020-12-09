package edu.csce4623.eaduran.covid_19calculator;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class faq_screen extends AppCompatActivity {
    Button btnResources;
    Button backButton2;
    Button btnFAQ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq_screen);
        //declare button ids
        btnResources = findViewById(R.id.btnResources);
        backButton2 = findViewById(R.id.backButton2);
        btnFAQ = findViewById(R.id.btnFAQ);

        //set on click listeners
        btnResources.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openResourcesPage();
            }
        });
        btnFAQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFAQPage();
            }
        });
        backButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWelcomePage();
            }
        });

    }


    public void openResourcesPage() {
        Uri uri = Uri.parse("https://covidactnow.org/learn");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void openFAQPage() {
        Uri uri = Uri.parse("https://covidactnow.org/faq");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    public void openWelcomePage() {
        Intent intent = new Intent(this, welcome_screen.class);
        startActivity(intent);
    }
}
