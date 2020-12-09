package edu.csce4623.eaduran.covid_19calculator;

import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import android.widget.AdapterView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

//import edu.csce4623.eaduran.covid_19calculator.API.CovidInfo;
//import edu.csce4623.eaduran.covid_19calculator.API.CovidInfoAPI;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class location_screen extends AppCompatActivity {//implements Callback<List<CovidInfo>> {
    //private Button button;
    private Button backButton;
    private Button submit;
    public static Spinner stateSpinner;
    public static Spinner countySpinner;
    private ArrayAdapter<String> stateAdapter;
    private ArrayAdapter<String> countyAdapter;
    //arraylist for state spinner items
    private ArrayList<String> states;
    private ArrayList<String> counties;
    //covid info list
    //ArrayList<CovidInfo> covidInfoList;
    //private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_screen);
        getjsonState();
        String State="AR";
        getCounties(State);
        //textView2 = findViewById(R.id.textView2);
        //declaring buttons and spinners
        backButton = (Button) findViewById(R.id.backButton);
        submit = (Button) findViewById(R.id.location_submit);
        stateSpinner = (Spinner) findViewById(R.id.state_spinner);
        countySpinner = (Spinner) findViewById(R.id.county_spinner);

        states = new ArrayList<String>();
        // stateSpinner.setOnItemSelectedListener(this);


        stateAdapter = new ArrayAdapter<>(location_screen.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.states));
        stateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        stateSpinner.setAdapter(stateAdapter);


        countyAdapter = new ArrayAdapter<>(location_screen.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.counties));
        countyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countySpinner.setAdapter(countyAdapter);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWelcomeScreen();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRiskScreen();
            }
        });
        
    }

    private void getCounties(String State) {
        String json;
        try {
            InputStream inputStream= getAssets().open("covidact.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json= new String(buffer,"UTF-8");
            JSONArray jsonArray = new JSONArray(json);
            counties= new ArrayList<String>();
            for (int i =0; i< jsonArray.length()-1; i++){
                JSONObject obj = jsonArray.getJSONObject(i);
                int j=0;
                if(obj.getString("state").equals(State)){
                        counties.add(obj.getString("county"));
                }
            }
        } catch (IOException | JSONException e) {
            Log.d("Failed","Error");
            e.printStackTrace();
        }
    }

    private void getjsonState() {
        String json;
        try {
            InputStream inputStream= getAssets().open("covidact.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json= new String(buffer,"UTF-8");
            JSONArray jsonArray = new JSONArray(json);
            states= new ArrayList<String>();
            for (int i =0; i< jsonArray.length()-1; i++){
                JSONObject obj = jsonArray.getJSONObject(i);
                JSONObject obj2 =jsonArray.getJSONObject(i+1);
                if(!(obj.getString("state")).equals(obj2.getString("state"))){
                    states.add(obj.getString("state"));
                }
            }
        } catch (IOException | JSONException e) {
            Log.d("Failed","Error");
            e.printStackTrace();
        }


    }

    public void openWelcomeScreen() {
        Intent intent = new Intent(this,welcome_screen.class);
        startActivity(intent);
    }
    public void openRiskScreen() {
        Intent intent = new Intent(this,risk_screen.class);
        startActivity(intent);
    }
}