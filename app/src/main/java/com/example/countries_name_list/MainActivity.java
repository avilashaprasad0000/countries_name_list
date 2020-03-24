package com.example.countries_name_list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.LauncherActivity;
import android.app.ListActivity;
import android.content.Context;
import android.nfc.Tag;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    List<countrynamemodalclass> modelList = new ArrayList<>();
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager layoutManager;
    countrynameAdapter adapter;
    //List<Country> trylist = new ArrayList<>();
//    Context context=this.getApplicationContext();
    public static final String URL_DATA="https://gist.githubusercontent.com/keeguon/2310008/raw/bdc2ce1c1e3f28f9cab5b4393c7549f38361be4e/countries.json";
    public static final String URL_DATA2="https://raw.githubusercontent.com/samayo/country-json/master/src/country-by-name.json";
    public static final String URL_DATA3="http://restcountries.eu/rest/v2/all";
    String TAG="Main";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerview_view);
        //set recycler views properties
        mRecyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(layoutManager);


        //getCountryList();
        loadRecyclewViewData();


    }

    private void loadRecyclewViewData() {
        StringRequest stringRequest= new StringRequest(Request.Method.GET,
                URL_DATA3, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray array=jsonObject.getJSONArray("array");

                    for(int i=0;i<array.length();i++){
                        JSONObject o=array.getJSONObject(i);
                        countrynamemodalclass item =new countrynamemodalclass(
                                o.getString("name"),
                                o.getString("alpha3Code"),
                                o.getString("capital")
                        );
                        modelList.add(item);

                    }
                    adapter=new countrynameAdapter(modelList,MainActivity.this);
                    mRecyclerView.setAdapter(adapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void getCountryList() {
        Locale[] locale= Locale.getAvailableLocales();
        ArrayList<String> countries= new ArrayList<String>();
        String country = null;
        for(Locale loc:locale){
            country=loc.getDisplayCountry();
            if(country.length()>0 && !countries.contains(country)){
                countries.add(country);
                //modelList.add(country);
            }
        }

        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,countries);
       // modelList.setAdapter(adapter);



        //modelList.add(cnamepicker);
        //adapter = new countrynameAdapter((ListActivity) getApplicationContext(), modelList, context);
        //mRecyclerView.setAdapter(adapter);




    }


}
