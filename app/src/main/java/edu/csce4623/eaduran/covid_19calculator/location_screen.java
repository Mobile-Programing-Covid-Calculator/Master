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

import java.util.ArrayList;
import java.util.List;

import android.widget.AdapterView;
import android.widget.TextView;

//import com.android.volley.RequestQueue;
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.StringRequest;
//import com.android.volley.toolbox.Volley;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import edu.csce4623.eaduran.covid_19calculator.API.CovidInfo;
import edu.csce4623.eaduran.covid_19calculator.API.CovidInfoAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class location_screen extends AppCompatActivity implements Spinner.OnItemSelectedListener, Callback<List<CovidInfo>> {
    //private Button button;
    private Button backButton;
    private Button submit;
    public static Spinner stateSpinner;
    public static Spinner countySpinner;
    private ArrayAdapter<String> stateAdapter;
    private ArrayAdapter<String> countyAdapter;
    //arraylist for state spinner items
    private ArrayList<String> states;
    private String result = "";

    //covid info list
    ArrayList<CovidInfo> covidInfoList;
    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_screen);

        textView2 = findViewById(R.id.textView2);
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
        startQuery();
        //getData();
        startQuery();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();

    }

//    void itemClicked(AdapterView<?> parent, View view, int position, long id) {
//        Intent intent = new Intent(this, location_screen.class);
//        intent.putExtra("state", covidInfoList.get(position).getState());
//
//        startActivity(intent);
//    }

    //static final String BASE_URL = "https://api.covidactnow.org/"; /
    static final String BASE_URL = "https://api.covidactnow.org/v2/";
    //static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    //full URL
    //https://api.covidactnow.org/v2/counties.json?apiKey=d6f5ac0f7c0143b683aa50bf7bf163dd

    public void startQuery() {

        Debug.startMethodTracing("test");

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        CovidInfoAPI covidInfoAPI = retrofit.create(CovidInfoAPI.class);

        Call<List<CovidInfo>> call = covidInfoAPI.loadInfo();
        call.enqueue(this);

    }

    @Override
    public void onResponse(Call<List<CovidInfo>> call, Response<List<CovidInfo>> response) {
        //covidInfoList = new ArrayList<CovidInfo>(response.body());
        if(!response.isSuccessful())
        {
            System.out.println(response.errorBody());
            Log.d("FAILURE","testing" + "\n" + "testing" + "\n" + "testing" + "\n" + "testing" + "\n" + "testing" + "\n" + "testing" + "\n" + "testing" + "\n" + "testing" + "\n");
            return;
            //CovidInfo covidInfo = null;
            //Log.d("location_screen","testing" + "\n" + "testing" + "\n" + "testing" + "\n" + "testing" + "\n" + "testing" + "\n" + "testing" + "\n" + "testing" + "\n" + "testing" + "\n");
           // Log.d("location_screen", covidInfo.getCounty());
            

        }
        else {
            //System.out.println(response.errorBody());
            //Log.d("location_screen", covidInfo.getState());
            Log.d("SUCCESS","testing" + "\n" + "testing" + "\n" + "testing" + "\n" + "testing" + "\n" + "testing" + "\n" + "testing" + "\n" + "testing" + "\n" + "testing" + "\n");
        }
        List<CovidInfo> covidInfos = response.body();

        for (CovidInfo covidInfo : covidInfos) {
            //String content = "";
            //content += covidInfo.getState();
            //Log.d("location_screen_success", )
            Log.d("SUCCESS","testing" + "\n" + "testing" + "\n" + "testing" + "\n" + "testing" + "\n" + "testing" + "\n" + "testing" + "\n" + "testing" + "\n" + "testing" + "\n");
            //textView2.append(content);
        }
//        else {
//
//            Log.d("location_screen_success","testing" + "\n" + "testing" + "\n" + "testing" + "\n" + "testing" + "\n" + "testing" + "\n" + "testing" + "\n" + "testing" + "\n" + "testing" + "\n");
//        }
        Debug.stopMethodTracing();

    }
    @Override
    public void onFailure(Call<List<CovidInfo>> call, Throwable t) {
        t.printStackTrace();
    }

//    private void getCountyData() {
//
//    }
/*
    private void getData(){
        //Creating a string request
        final String result = "";
        StringRequest stringRequest = new StringRequest(Config.DATA_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONArray j = null;
                        try {
                            //Parsing the fetched Json String to JSON Object


                            //Storing the Array of JSON String to our JSON Array
                            JSONArray json = new JSONArray(result);

                            //Calling method getStudents to get the students from the JSON Array
                            getStates(json);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //Creating a request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        //Adding request to the queue
        requestQueue.add(stringRequest);
    }


    private void getStates(JSONArray j){
        //Traversing through all the items in the json array
        for(int i=0;i<j.length();i++){
            try {
                //Getting json object
                JSONObject json = j.getJSONObject(i);

                //Adding the name of the student to array list
                states.add(json.getString(Config.TAG_STATE));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        //Setting adapter to show the items in the spinner
        stateSpinner.setAdapter(new ArrayAdapter<String>(location_screen.this, android.R.layout.simple_spinner_dropdown_item, states));
    }

*/
    public void openWelcomeScreen(){
        Intent intent = new Intent(this,welcome_screen.class);
        startActivity(intent);
    }
    public void openRiskScreen(){
        Intent intent = new Intent(this,risk_screen.class);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}